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



