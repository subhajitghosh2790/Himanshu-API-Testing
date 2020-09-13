@AllEmployees
Feature: TC02 (POST) All Employees

  

    Scenario: Positive Scenario (200 Ok Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        And the request payload is
        """
        {
    "name": "test_gk_unique",
    "salary": "123",
    "age": "23"
}
        """
        When the HTTP request type is "POST"  and resource is "/create"
        Then verify the Response code is "200"
        And ignore attribute "data" and verify the Response schema
        """
       {
    "status": "success",
    "data": {
        "id": 932
    },
    "message": "Successfully! Record has been added."
}
        """
        
        
        Scenario: Negative Scenario (404 Not Found Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "GET"  and resource is "/create"
        Then verify the Response code is "404"
        And ignore attribute "" and verify the Response schema
        """
       {
    "message": "Error Occured! Page Not found, contact rstapi2example@gmail.com"
}
        """
        
        
        
        
        Scenario: Hard Failure Scenario (Incorrect Body Validation)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "GET"  and resource is "/create"
        Then verify the Response code is "404"
        And ignore attribute "" and verify the Response schema
        """
       {
    "Himashu": "Dhingra"
}
        """