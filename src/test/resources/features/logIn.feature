Feature: Log in into personal account

  @LogIn
  Scenario: Log in with valid details
    Given I lunch the browser
    And I go to Log in page
    When I enter "dan.williams@gmail.com"
    And I then enter "1234567a"
    Then I will go to my account

  @LogIn
  Scenario: Log in with invalid email
    Given I lunch the browser
    And I go to Log in page
    When I enter invalid "chris.john@gmail.com"
    And I then enter "1234567a"
    Then I will remain on Log in page

  @LogIn
  Scenario: Log in with invalid password
    Given I lunch the browser
    And I go to Log in page
    When I enter "dan.williams@gmail.com"
    And I enter an invalid "498325"
    Then I will remain on Log in page

  @LogIn
  Scenario: Log in with empty fields
    Given I lunch the browser
    And I go to Log in page
    When I click on sing in button
    Then I will remain on Log in page
