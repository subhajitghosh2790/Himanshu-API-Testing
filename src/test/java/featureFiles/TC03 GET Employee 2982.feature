@AllEmployees
Feature: TC03 (GET) Employee 2982

  

    Scenario: Positive Scenario (200 Ok Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "GET"  and resource is "/employee/2982"
        Then verify the Response code is "200"
       And ignore attribute "" and verify the Response schema
        """
       {
    "status": "success",
    "data": null,
    "message": "Successfully! Record has been fetched."
}
        """
       
       
       
       
       Scenario: Negative Scenario (400 Bad Request Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "GET"  and resource is "/employee/0"
        Then verify the Response code is "400"
       And ignore attribute "" and verify the Response schema
        """
       {
    "status": "error",
    "message": "Not found record",
    "code": 400,
    "errors": "id is empty"
}
        """