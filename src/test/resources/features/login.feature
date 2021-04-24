@regression @login

Feature: Login page validation

  Background: I am on Login page


  Scenario: Verify that all text in the LoginPage are correct
    Then I verify that all texts of login page are correct

  Scenario: The Username input and Password input fields have the appropriate labels
    Then I verify that username input has the apporpriate label
    And I verify that pasword input has the apporpriate label

  Scenario: User fails to login whithout entering a username and password
    When I click on login button
    Then I verify that I am not able to login

  Scenario: Users that fail to login get an alert text with red background and white text color
    When I enter my password
    And I click on login button
    Then I verify that I am not able to login
    And I verify that the Alert background text is red
    And I verify that the Alert text is white

  Scenario: User enters a valid username and not entering password then fails to login
    When I enter my username
    And I click on login button
    Then I verify that I am not able to login without password


  Scenario: User enters a correct username and incorrect password then fails to login
    When I enter my username
    And I enter the incorrect password
    And I click on login button
    Then I verify that I am not able to login without password


  Scenario: User enters a correct password and incorrect username then fails to login
    When I enter the incorrect username
    And I enter my password
    And I click on login button
    Then I verify that I am not able to login

  Scenario: User enters a valid password and not entering username then fails to login
    When I enter my password
    And I click on login button
    Then I verify that I am not able to login



  Scenario: User type some text in the password field and the password is masked
    When I enter my password
    Then I verify that my password is maked


  Scenario Outline: User enters an not accepted characters in the username and password fields
    When I enter incorrect "<username and password>"
    And I click on login button
    Then I verify that I am not able to login
    Examples:
      | username and password |
      | 0                     |
      | 1                     |
      | 2                     |
      | 3                     |
      | 4                     |
      | 5                     |
      | 6                     |
      | 7                     |
      | 8                     |
      | 9                     |
      | 10                    |
      | 11                    |
      | 12                    |
      | 13                    |
      | 14                    |
      | 15                    |
      | 16                    |
      | 17                    |
      | 18                    |
      | 19                    |
      | 20                    |
      | 21                    |
      | 22                    |
      | 23                    |
      | 24                    |
      | 25                    |
      | 26                    |
      | 27                    |
      | 28                    |
      | 29                    |
      | 30                    |
      | 31                    |



  Scenario Outline: User enters a SQL injection
    When I enter "<sql injection>"
    And I click on login button
    Then I verify that I am not able to login
    Examples:
      | sql injection|
      | 1                     |
      | 2                     |
      | 3                     |
      | 4                     |
      | 5                     |
      | 6                     |
      | 7                     |
      | 8                     |
      | 9                     |
      | 10                    |
      | 11                    |
      | 12                    |
      | 13                    |
      | 14                    |
      | 15                    |
      | 16                    |
      | 17                    |
      | 18                    |
      | 19                    |
      | 20                    |
      | 21                    |
      | 22                    |
      | 23                    |
      | 24                    |
      | 25                    |
      | 26                    |
      | 27                    |
      | 28                    |
      | 29                    |
      | 30                    |
      | 31                    |
      | 32                    |
      | 33                    |
      | 34                    |
      | 35                    |
      | 36                    |
      | 37                    |
      | 38                    |
      | 39                    |
      | 40                    |
      | 41                    |


  Scenario: User enters a valid username and a valid password and is able to login
    When I enter my username
    And I enter my password
    And I click on login button
    Then I verify that I am able to login


  Scenario: Verify that all text in the Logout Page are correct
    When I enter my username
    And I enter my password
    And I click on login button
    Then I verify that I am able to login
    And I verify that all texts of secured page are correct


  Scenario: Users that are able to login get an alert text with green background and white text color
    When I enter my username
    And I enter my password
    And I click on login button
    Then I verify that I am able to login
    And I verify that the Alert background text is green
    And I verify that the Alert text is white.


  Scenario: A user is able to log out successfully
    Given I am in the Secure Area
    When I click on logout button
    Then I verify that I loged out successfully
    And the logout alert text is displayed
    And the logout alert text background color is green
