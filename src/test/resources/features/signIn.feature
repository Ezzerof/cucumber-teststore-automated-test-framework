Feature: Create user account

  @CreateUser
  Scenario: Go to Sign in page
    Given I am on the http://teststore.automationtesting.co.uk/login?back=my-account
    When I press on No acocunt? Create one here
    Then I go to http://teststore.automationtesting.co.uk/login?create_account=1

  @CreateUser
  Scenario: Create valid user account
    Given I am on http://teststore.automationtesting.co.uk/login?create_account=1
    When I select Mr.
    And enter first and last name
    And enter email and password
    And enter birthdate MM/DD/YYYY
    And tick all checkboxes
    And press on Save button
    Then I go to Account page

  @CreateUser
  Scenario: Create user account without data
    Given I am on http://teststore.automationtesting.co.uk/login?create_account=1
    When press on Save button
    Then I remain on http://teststore.automationtesting.co.uk/login?create_account=1

  @CreateUser
  Scenario: Create user account without first and last name
    Given I am on http://teststore.automationtesting.co.uk/login?create_account=1
    When I select Mrs.
    And not entering first and last name
    And enter email and password
    And enter birthdate MM/DD/YYYY
    And tick all checkboxes
    And press on Save button
    Then I remain on http://teststore.automationtesting.co.uk/login?create_account=1

  @CreateUser
  Scenario: Create user with details from an existing user
    Given I am on http://teststore.automationtesting.co.uk/login?create_account=1
    When I select Mr.
    And enter first and last name
    And enter email and password
    And enter birthdate MM/DD/YYYY
    And tick all checkboxes
    And press on Save button
    Then I see error message