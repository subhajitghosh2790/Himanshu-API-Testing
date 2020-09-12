@AllEmployees
Feature: TC01 (GET) All Employees

        *The scenarios covered are -

        *


    Scenario: Positive Scenario (200 Ok Response)
        Given the URL is "http://dummy.restapiexample.com/api/v1"
        When the HTTP request type is "GET"  and resource is "/employee/2982"
        Then verify the Response code is "200"
        And the verify the Response schema from
        """
       {
           "userId": 1,
           "id": 1,
           "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
           "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
       }
        """