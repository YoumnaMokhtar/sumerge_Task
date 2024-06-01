Feature: Login

  Scenario Outline: login with valid credntials
    Given I opened the website
    When I enter "<username>"
    And I entered "<password>"
    And I clicked Login
    Then I will be logged successfully
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: login with invalid credntials
    Given I opened the website
    When I enter "<username>"
    And I entered "<password>"
    And I clicked Login
    Then it will appear an error message for invalid credntials
    Examples:
      | username       | password     |
      | standard_userrrr | secret_sauce |

  Scenario Outline: login with empty username credntials
    Given I opened the website
    When I enter "<username>"
    And I entered "<password>"
    And I clicked Login
    Then it will appear an error message that username is required
    Examples:
      | username | password |
      |          |          |

  Scenario Outline: login with empty password credntials
    Given I opened the website
    When I enter "<username>"
    And I entered "<password>"
    And I clicked Login
    Then it will appear an error message that password is required
    Examples:
      | username | password |
      |   standard_user       |          |