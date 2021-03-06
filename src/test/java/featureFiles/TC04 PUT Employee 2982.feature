@AllEmployees
Feature: TC04 (PUT) Employee 2982

  

    Scenario: Positive Scenario (200 Ok Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "PUT"  and resource is "/update/2982"
        Then verify the Response code is "200"
        And ignore attribute "" and verify the Response schema
        """
       {
    "status": "success",
    "data": [],
    "message": "Successfully! Record has been updated."
}
        """
        
        
        
        Scenario: Negative Scenario (405 Method Not Allowed Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "PUT"  and resource is "/update/2982/10"
        Then verify the Response code is "405"
        