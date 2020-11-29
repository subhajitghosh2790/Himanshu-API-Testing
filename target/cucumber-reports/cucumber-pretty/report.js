$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("TC01 GET All Employees.feature");
formatter.feature({
  "line": 2,
  "name": "TC01 (GET) All Employees",
  "description": "",
  "id": "tc01-(get)-all-employees",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@AllEmployees"
    }
  ]
});
formatter.scenario({
  "line": 6,
  "name": "Positive Scenario (200 Ok Response)",
  "description": "",
  "id": "tc01-(get)-all-employees;positive-scenario-(200-ok-response)",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@testing"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "the URL is \"url\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "the HTTP request type is \"GET\"  and resource is \"/employees\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "verify the Response code is \"200\"",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "url",
      "offset": 12
    }
  ],
  "location": "httpActivity.the_URL_is(String)"
});
formatter.result({
  "duration": 1104577900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "GET",
      "offset": 26
    },
    {
      "val": "/employees",
      "offset": 49
    }
  ],
  "location": "httpActivity.the_HTTP_request_type_is_and_resource_is(String,String)"
});
formatter.result({
  "duration": 2787179301,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 29
    }
  ],
  "location": "httpActivity.verify_the_Response_code_is(String)"
});
formatter.result({
  "duration": 111400,
  "status": "passed"
});
});