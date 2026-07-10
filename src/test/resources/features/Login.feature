Feature: Login

  Scenario Outline: Verify successful login as User with different roles
    When the user provides userName and password
    And select the "User" login type
    Then confirmation message should be displayed
    And user accept the confirm message
    And select the "<Role>" role
    And signIn with accepting the Terms and Conditions
    Then user should be redirected to the ProtoCommerce Shop Page

    Examples:
    | Role       |
    | Consultant |
    | Teacher    |
    | Student    |


  Scenario: Verify successful login as Admin
    When the user provides userName and password
    And select the "Admin" login type
    And signIn with accepting the Terms and Conditions
    Then user should be redirected to the ProtoCommerce Shop Page


  Scenario Outline: Verify Login error with incorrect credential
    When the user provides incorrect "<userName>" and "<password>"
    And signIn with accepting the Terms and Conditions
    Then "<errorMessage>" should be displayed

    Examples:
    | userName           | password          |  errorMessage |
    | rahulshettyacademy |                   | Empty username/password. |
    |                    | Learning@830$3mK2 | Empty username/password. |
    |                    |                   | Empty username/password. |
    | invalidUserName    | invalidPassword   | Incorrect username/password. |
    | rahulshettyacademy | invalidPassword   | Incorrect username/password. |
    | invalidUserName    | Learning@830$3mK2 | Incorrect username/password. |


  Scenario: Verify Admin option is selected when user cancels limited functionality confirmation
    When the user provides userName and password
    And select the "User" login type
    Then confirmation message should be displayed
    When the user decline the confirm message
    Then the Admin option should be selected by default.

  Scenario: Verify login is restricted when user does not accept Terms and Conditions
    When the user provides userName and password
    And user signs in without accepting Terms and Conditions
    Then user should not be redirected to ProtoCommerce Shop Page
