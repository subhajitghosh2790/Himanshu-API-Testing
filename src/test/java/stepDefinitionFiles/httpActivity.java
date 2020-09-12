package stepDefinitionFiles;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.HTTP_Methods;


public class httpActivity extends HTTP_Methods {

    @Given("^the URL is \"([^\"]*)\"$")
    public void the_URL_is(String url) throws Throwable {
        baseURL(url);
    }

    @When("^the HTTP request type is \"([^\"]*)\"  and resource is \"([^\"]*)\"$")
    public void the_HTTP_request_type_is_and_resource_is(String httpMethod, String resource) throws Throwable {
        httpMethod(httpMethod, resource);
    }

    @Then("^verify the Response code is \"([^\"]*)\"$")
    public void verify_the_Response_code_is(String respCode) throws Throwable {
        responseCode(respCode);
    }

    @When("^the verify the Response schema from$")
    public void the_verify_the_Response_schema_from(String arg1) throws Throwable {
        requestAssertion(arg1);
    }

}

