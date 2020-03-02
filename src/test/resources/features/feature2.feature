Feature: Title of your feature
  I want to use this template for my feature file

  @nonapitest
  Scenario Outline: Title of your scenario outline
    Given i am on login page
    When I enter "<uname>" in uname field
    And I enter "<pwd>" in password field
    And i click login button
    Then login status should be "<loginstatus>"

    Examples: 
      | uname           | pwd             | loginstatus |
      | validusername   | validpassword   | success     |
      | validusername   | invalidpassword | fail        |
      | invalidusername | validpassword   | fail        |
      | invalidusername | invalidpassword | fail        |
