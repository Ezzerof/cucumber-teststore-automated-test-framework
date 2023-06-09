Feature: Create user account

  @CreateUser
  Scenario: User go to Registration page
    Given I lunch browser
    And I go to the Sign in page
    When I press on No account? Create one here
    Then I go to Registration page

  @CreateUser
  Scenario: Create valid user account
    Given I am on Registration page
    When I select Mr.
    And enter first and last name
    And enter email and password
    And enter birthdate
    And tick all checkboxes
    And press on Save button
    Then I go to Account page

  @CreateUser
  Scenario: Create user account without data
    Given I am on Registration page
    When press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user account without first and last name
    Given I am on Registration page
    When I select Mrs.
    And not entering first and last name
    And enter email and password
    And enter birthdate
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user with details from an existing user
    Given I am on Registration page
    When I select Mr.
    And enter first and last name
    And enter email and password
    And enter birthdate
    And tick all checkboxes
    And press on Save button
    Then I see error message