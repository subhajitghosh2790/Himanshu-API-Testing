
package utility;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.filter.FilteringParserDelegate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.config.ParamConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.fail;

import org.json.simple.JSONValue;

import com.flipkart.zjsonpatch.JsonDiff;

public class HTTP_Methods {
	protected static RequestSpecification httpRequest = RestAssured.given();
	private static Response response;
	Logger log = Logger.getLogger("HTTP_Methods.class");
	

	public static String reqPL;
	public static String reqPLq;

	static PropertiesConfigure p = new PropertiesConfigure();

	public void printMsg() {
		String valueFromMaven = System.getProperty("propertyName");
		fail("This is the value -------> " + valueFromMaven);
	}

	public void baseURL(final String url) {
		System.out.println("url is -->" + p.readprop(url));
		RestAssured.baseURI = p.readprop(url);
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
			fail("Expected Status code as per test cases is = " + respCode + " but Status code recieved is = " + response.getStatusCode()
					+ " was found instead..." + "\nBody coming from backend is-->" + response.getBody().prettyPrint());
		}
	}

	public void newReqPL(final String jsonStr) {
		final JSONObject jsonObject = (JSONObject) JSONValue.parse(jsonStr);
		httpRequest.body(jsonObject);
	}

	public void responseAssertion(final String ignoreAttribute, final String expectedBody) {
		final ObjectMapper mapper = new ObjectMapper();
		try {
		final JsonParser filteredParser = new FilteringParserDelegate(
				mapper.getFactory()
						.createParser(new ByteArrayInputStream(expectedBody.getBytes(StandardCharsets.UTF_8))),
				new PropertyBasedIgnoreFilter(ignoreAttribute), true, true);

		final JsonParser filteredParser1 = new FilteringParserDelegate(
				mapper.getFactory().createParser(
						new ByteArrayInputStream(response.getBody().asString().getBytes(StandardCharsets.UTF_8))),
				new PropertyBasedIgnoreFilter(ignoreAttribute), true, true);

		

			final JsonNode beforeNode = mapper.readTree(filteredParser);
			final JsonNode afterNode = mapper.readTree(filteredParser1);
			final JsonNode patch = JsonDiff.asJson(beforeNode, afterNode);
			final String diffs = patch.toString();
			if (patch.size() > 0) {
				fail("The difference in the response is -->" + diffs + "\n Actual Response from Backend is --> "
						+ response.getBody().prettyPrint());
			}
		} catch (final Exception e) {
			e.printStackTrace();
			fail("was in catch block" + e.getMessage());
		}

	}

	public void queryParam_new(final String queryParam, final String value) {
		final Map<String, String> m = new HashMap<>();

		m.put(queryParam.trim(), value.trim());

		for (final Map.Entry<String, String> me : m.entrySet()) {
			httpRequest
					.config(RestAssuredConfig.config().paramConfig(ParamConfig.paramConfig().replaceAllParameters()));
			httpRequest.queryParam(me.getKey(), me.getValue());
			
		}

	}
}
