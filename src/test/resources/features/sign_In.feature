Feature: Sign In

  Background: User is log on the home page

    Given User is on the app
    Given User click "Sign In" button

  Scenario: Verify that the user can go to Sign Up page click the Sıgn Up
    When User can switch to Sign Up page
    Then User should go to "Sign Up" page

  Scenario Outline: Verify that the user can see Sign In messages

    When User should see the input entity is "<status>" on "<field>"
    And User click "Sign UpIn button" button
    Then User should see the "<message>" message on "<field>"
    Examples:
      | field    | status              |  | message                                 |
      | email    | empty               |  | email girişi zorunludur                 |
      | email    | lack                |  | email must be a valid email             |
      | email    | ok                  |  |                                         |
      | password | empty               |  | password zorunludur                     |
      | password | less 8 chars        |  | password en az 8 karakter olmalıdır     |
      | password | lack a number       |  | Password bir sayı içermelidir           |
      | password | lack a lower case   |  | Password bir küçük harf içermelidir     |
      | password | lack a upper case   |  | Password bir büyük harf içermelidir     |
      | password | lack a special char |  | Password bir özel karakter içermelidir  |
      | password | more 20 chars       |  | password en fazla 20 karakter olmalıdır |

  Scenario: Verify that the user can Log In
    When User should see the input entity is "ok" on "password"
    And User click "Sign UpIn button" button
    Then User should Sign Up or Sign In
    Then Status should be 200