Feature: Registered and non registered user will come on application and perform activities

  Scenario: Registered user comes to application to login
    Given User is on login page
    When  User enters username
    And   User enters password
    And  User clicks on login button
    Then User should be loggedin


