@AllEmployees
Feature: TC01 (GET) All Employees

  

    Scenario: Positive Scenario (200 Ok Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "GET"  and resource is "/employees"
        Then verify the Response code is "200"
       
       
       
        Scenario: Negative Scenario (404 Not Found Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "GET"  and resource is "/employe"
        Then verify the Response code is "404"
        And ignore attribute "" and verify the Response schema
        """
       {
    "message": "Error Occured! Page Not found, contact rstapi2example@gmail.com"
}
        """
        
        
        
        
        
        Scenario: Hard Failure Scenario (Incorrect Response Validation)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "GET"  and resource is "/employees"
        Then verify the Response code is "201"
        