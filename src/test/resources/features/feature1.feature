Feature: Title of your feature
  I want to use this template for my feature file

  @apitest
  Scenario: To verify get call which gives details of all users
    Given I have Base URL
    And I have Parameters
    And I have Headers
    When I make a Get request to End point
    Then Reponse has status code 200
    And Response has Valid content type header
    And Response has valid body

    
    