Feature: Log in into personal account

  @LogIn
  Scenario Outline: Log in with valid details
    Given I am on Log in page
    When I enter "<email>"
    And I enter "<password>"
    Then I will go to my account
    Examples:
      | email                       | password |
      | jo.williams@gmail.com       | 123456a |
      | j.williams@gmail.com        | 123456a |
      | danniel.williams@gmail.com  | 123456a |
      | dan.williams@gmail.com      | 1234567a |

  @LogIn
    Scenario Outline: Log in with invalid details
    Given I am on Log in page
    When I enter invalid "<email>"
    And I enter invalid "<password>"
    Then I will remain on Log in page
    Examples:
      | email                 | password |
      | chris.john@gmail.com  | 498325 |
      | melisa.com            | 1235898 |
      | !                     | £"$! |
      | admin                 | admin |

