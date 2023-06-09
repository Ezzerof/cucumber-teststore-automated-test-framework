Feature: Create user account

  @CreateUser
  Scenario: User go to Registration page
    Given I lunch browser
    And I go to the Sign in page
    When I press on No account? Create one here
    Then I am on Registration page

  @CreateUser
  Scenario: Create valid user account
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "John" and last name "Williams"
    And enter email "jo.williams@gmail.com" and password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I am logged in

  @CreateUser
  Scenario: Create user account without data
    Given I lunch browser
    And I go to Registration page
    When press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user account without first and last name
    Given I lunch browser
    And I go to Registration page
    When I select Mrs.
    And not entering first and last name
    And enter new email "danniel.williams@gmail.com" and password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user with details from an existing user
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Josh" and last name "Williams"
    And enter email "josh.williams@gmail.com" and password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I see error message