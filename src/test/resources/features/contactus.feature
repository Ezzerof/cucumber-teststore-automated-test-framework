Feature: User sends a request through contact us

  @ContactUs
  Scenario: User goes to Contact us page
    Given lunch the browser
    When I go to Contact us page
    Then I am on the Contact us page

  @ContactUs
  Scenario: User sends a request to Customer service
    Given I am on Contact us page
    And I select as a subject customer service
    And I enter an email "dan.williams@gmail.com"
    And I enter a message "Test"
    And I tick the checkbox
    When I press on Send button
    Then I should see the message "Your message has been successfully sent to our team."

  @ContactUs
  Scenario: User sends a request to Webmaster
    Given I am on Contact us page
    And I select as a subject webmaster
    And I enter an email "dan.williams@gmail.com"
    And I enter a message "Test"
    And I tick the checkbox
    When I press on Send button
    Then I should see the message "Your message has been successfully sent to our team."

  @ContactUs
  Scenario: User sends a request to Customer service without email
    Given I am on Contact us page
    And I select as a subject customer service
    And I enter a message "Test"
    And I tick the checkbox
    When I press on Send button
    Then I should remain on the Contact us page and see the message "Invalid email address."

  @ContactUs
  Scenario: User sends a request to Webmaster without email
    Given I am on Contact us page
    And I select as a subject webmaster
    And I enter a message "Test"
    And I tick the checkbox
    When I press on Send button
    Then I should remain on the Contact us page and see the message "Invalid email address."

  @ContactUs
  Scenario: User sends a request to Customer service without message
    Given I am on Contact us page
    And I select as a subject customer service
    And I enter an email "dan.williams@gmail.com"
    And I tick the checkbox
    When I press on Send button
    Then I should remain on the Contact us page and see the message "The message cannot be blank."

  @ContactUs
  Scenario: User sends a request to Webmaster without message
    Given I am on Contact us page
    And I select as a subject webmaster
    And I enter an email "dan.williams@gmail.com"
    And I tick the checkbox
    When I press on Send button
    Then I should remain on the Contact us page and see the message "The message cannot be blank."

  @ContactUs
  Scenario: User sends a request to Customer service without selecting the checkbox
    Given I am on Contact us page
    And I select as a subject customer service
    And I enter an email "dan.williams@gmail.com"
    And I enter a message "Test"
    Then The Send button should not be clickable

  @ContactUs
  Scenario: User sends a request to Webmaster with a invalid email
    Given I am on Contact us page
    And I select as a subject webmaster
    And I enter an email "dan.williams.com"
    And I enter a message "Test"
    And I tick the checkbox
    When I press on Send button
    Then I should remain on the Contact us page