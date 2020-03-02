Feature: Testing a REST API
  Users should be able to submit GET,POST and Delete requests to a web service

  Scenario: Make Post Request
    Given I have a request base url
    And I have a request Content type header
    And I have a request body
    When I make a Post  request
    Then response code is 201 
    And response content type is json
    And response body has booking id

