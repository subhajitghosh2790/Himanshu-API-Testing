
package utility;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.filter.FilteringParserDelegate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.HeaderConfig;
import io.restassured.config.ParamConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class HTTP_Methods {
    protected static RequestSpecification httpRequest = RestAssured.given();
    private static Response response;
    private JSONObject reqestParams;
    Logger log = Logger.getLogger("HTTP_Methods.class");
    static ReadProperties p = new ReadProperties();
    private byte[] fileContent;
    private File testUploadFile;
    public static String reqPL;
    public static String reqPLq;
    ReadFromJSFile h = new ReadFromJSFile();
    private String path;


    public void printMsg() {
        String valueFromMaven = System.getProperty("propertyName");
        fail("This is the value -------> " + valueFromMaven);
    }

    public void baseURL(final String url) {
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
    }

    public void httpMethod(final String httpMethod, final String pathParams) {

        if (httpMethod.equalsIgnoreCase("Get")) {
            response = httpRequest.request(Method.GET, pathParams);
        } else if (httpMethod.equalsIgnoreCase("post")) {
            response = httpRequest.request(Method.POST, pathParams);
        } else if (httpMethod.equalsIgnoreCase("put")) {
            response = httpRequest.request(Method.PUT, pathParams);
        } else if (httpMethod.equalsIgnoreCase("delete")) {
            response = httpRequest.request(Method.DELETE, pathParams);
        } else if (httpMethod.equalsIgnoreCase("patch")) {
            response = httpRequest.request(Method.PATCH, pathParams);
        }

    }


    public void responseCode(final String respCode) {
        if (!(response.getStatusCode() + "").equals(respCode)) {
            fail("Expected Status code = " + respCode + " but Status code = " + response.getStatusCode()
                    + " was found instead..." + "\nBody coming from backend is-->" + response.getBody().prettyPrint());
        }
    }


    public void requestPayload(final String stringToParse) {
        reqestParams = new JSONObject();
        final String z = stringToParse.replace("\"", "");

        final Map<String, String> result = Arrays.stream(z.split(",")).map(s -> s.split(":"))
                .collect(Collectors.toMap(a -> a[0], // key
                        a -> a[1] // value
                ));

        for (final Map.Entry<String, String> me : result.entrySet()) {
            reqestParams.put(me.getKey().trim(), me.getValue().trim());
        }

        httpRequest.body(reqestParams.toJSONString());
    }


    public void requestAssertion(final String expectedBody) {
        final JSONObject jsonObject = (JSONObject) JSONValue.parse(expectedBody);

        final ObjectMapper mapper = new ObjectMapper();

        try {

            System.out.println("Body Subhajit is -->"+jsonObject.toJSONString());
            // System.out.println("Reached response body method");
            Assert.assertEquals(matchesJsonSchema(jsonObject.toJSONString()), response.getBody().asString());
            // System.out.println("Completed response body method");
        } catch (final Exception e) {
        }
    }

    public void queryParam_new(final String queryParam, final String value) {
        final Map<String, String> m = new HashMap<>();

        m.put(queryParam.trim(), value.trim());

        for (final Map.Entry<String, String> me : m.entrySet()) {
            httpRequest
                    .config(RestAssuredConfig.config().paramConfig(ParamConfig.paramConfig().replaceAllParameters()));
            httpRequest.queryParam(me.getKey(), me.getValue());
            // System.out.println("Query Param is --> " + queryParam + " Value is -->" +
            // value);
        }

    }
}
