Feature: Create user account

  @CreateUser
  Scenario: User go to Registration page
    Given I lunch browser
    And I go to the Sign in page
    When I press on No account? Create one here
    Then I am on Registration page

  @CreateUser
  Scenario: User selects Mr as social title
    Given  I lunch browser
    And I go to Registration page
    When I select Mr.
    Then Mr is selected

  @CreateUser
  Scenario: User selects Mrs as social title
    Given  I lunch browser
    And I go to Registration page
    When I select Mrs.
    Then Mrs is selected

  @CreateUser
  Scenario: Create valid user account
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Daniel" 
    And enter last name "Williams"
    And enter email "dan.williams@gmail.com" 
    And enter password "123456a"
    And enter birthdate "10/12/2001"
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
    And not entering first name
    And enter email "danniel.williams@gmail.com" 
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user account without first name
    Given I lunch browser
    And I go to Registration page
    When I select Mrs.
    And enter first name "Andrew"
    And not entering last name
    And enter email "danniel.williams@gmail.com" 
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user account without last name
    Given I lunch browser
    And I go to Registration page
    When I select Mrs.
    And not entering first name
    And enter last name "Williams"
    And enter email "danniel.williams@gmail.com"
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page  

  @CreateUser
  Scenario: Create user account without social title
    Given I lunch browser
    And I go to Registration page
    When enter first name "Daniel" 
    And enter last name "Williams"
    And enter email "danniel.williams@gmail.com" 
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user account without email
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Daniel"
    And enter last name "Williams"
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user account without password
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Daniel"
    And enter last name "Williams"
    And enter email "danniel.williams@gmail.com"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user account without selecting to receive offers
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Daniel"
    And enter last name "Williams"
    And enter password "123456a"
    And enter email "danniel.williams@gmail.com"
    And enter birthdate "05/12/2000"
    And tick sign up for newsletters checkbox
    And tick agree terms checkbox
    And press on Save button
    Then I am logged in

  @CreateUser
  Scenario: Create user account without selecting sign up for newsletters
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Daniel"
    And enter last name "Williams"
    And enter password "123456a"
    And enter email "danniel.williams@gmail.com"
    And enter birthdate "05/12/2000"
    And tick to receive offers checkbox
    And tick agree terms checkbox
    And press on Save button
    Then I am logged in

  @CreateUser
  Scenario: Create user account without selecting I agree terms
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Daniel"
    And enter last name "Williams"
    And enter password "123456a"
    And enter email "danniel.williams@gmail.com"
    And enter birthdate "05/12/2000"
    And tick to receive offers checkbox
    And tick sign up for newsletters checkbox
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user account without birthday
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Daniel"
    And enter last name "Williams"
    And enter password "123456a"
    And enter email "danniel.williams@gmail.com"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page

  @CreateUser
  Scenario: Create user with details from an existing user
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name "Josh" 
    And enter last name "Williams"
    And enter email "josh.williams@gmail.com" 
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I see error message

  @CreateUser
  Scenario: Create user with first name that contains digits
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name with digits "Josh123"
    And enter last name "Williams"
    And enter email "josh1.williams@gmail.com"
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I see error message under first name field

  @CreateUser
  Scenario: Create user with last name that contains digits
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name with digits "Josh"
    And enter last name "Williams123"
    And enter email "josh1.williams@gmail.com"
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I see error message under last name field

  @CreateUser
  Scenario: Create user with first name that contains symbols
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name with digits "Josh£@$"
    And enter last name "Williams"
    And enter email "josh1.williams@gmail.com"
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I see error message under first name field

  @CreateUser
  Scenario: Create user with last name that contains symbols
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name with digits "Josh"
    And enter last name "Williams£@$"
    And enter email "josh1.williams@gmail.com"
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I see error message under last name field

  @CreateUser
  Scenario: Create user with invalid email address
    Given I lunch browser
    And I go to Registration page
    When I select Mr.
    And enter first name with digits "John"
    And enter last name "Williams"
    And enter email "dan.williams.com"
    And enter password "123456a"
    And enter birthdate "05/12/2000"
    And tick all checkboxes
    And press on Save button
    Then I remain on Registration page


