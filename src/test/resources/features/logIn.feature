@LogIn
Feature: Log in into personal account

  Scenario: Log in with valid details
    Given I lunch the browser
    And I go to Log in page
    When I enter a valid email "dan.williams@gmail.com"
    And I then enter password "1234567a"
    Then I will go to my account

  Scenario: Log in with invalid email
    Given I lunch the browser
    And I go to Log in page
    When I enter invalid email "chris.john@gmail.com"
    And I then enter password "1234567a"
    Then I will remain on Log in page

    Scenario: Log in while leaving email field empty
      Given I lunch the browser
      And I go to Log in page
      When I then enter password "1234567a"
      And I click on sing in button
      Then I will remain on Log in page

  Scenario: Log in with invalid password
    Given I lunch the browser
    And I go to Log in page
    When I enter a valid email "dan.williams@gmail.com"
    And I enter an invalid password "498325"
    Then I will remain on Log in page

  Scenario: Log in while leaving password field empty
    Given I lunch the browser
    And I go to Log in page
    When I enter a valid email "dan.williams@gmail.com"
    And I click on sing in button
    Then I will remain on Log in page

  Scenario: Log in with empty fields
    Given I lunch the browser
    And I go to Log in page
    When I click on sing in button
    Then I will remain on Log in page
