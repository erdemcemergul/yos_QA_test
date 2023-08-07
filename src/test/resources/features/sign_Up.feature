Feature: Sign Up

  Background: User is not Sign Up

    Given User is on the app
    Given User click "Sign Up" button


  Scenario:Verify that the user can go to Sign In page click the Sıgn In
    When User can switch to Sign In page
    Then User should go to "Sign In" page

  Scenario: Creating test data
    Given Sign Up datas are created random

  Scenario Outline: Verify that the user can see SignUp messages
    When User should see the input entity is "<status>" on "<field>"
    And User click "Sign UpIn button" button
    Then User should see the "<message>" message on "<field>"
    Examples:
      | field      | status              |  | message                                    |
      | Name       | empty               |  | username girişi zorunludur                 |
      | Name       | more 10 chars       |  | Kullanıcı adı 10 karakterden az olmalıdır. |
      | Name       | ok                  |  |                                            |
      | email      | empty               |  | email girişi zorunludur                    |
      | email      | lack                |  | email must be a valid email                |
      | email      | ok                  |  |                                            |
      | password   | empty               |  | password zorunludur                        |
      | password   | less 8 chars        |  | password en az 8 karakter olmalıdır        |
      | password   | lack a number       |  | Password bir sayı içermelidir              |
      | password   | lack a lower case   |  | Password bir küçük harf içermelidir        |
      | password   | lack a upper case   |  | Password bir büyük harf içermelidir        |
      | password   | lack a special char |  | Password bir özel karakter içermelidir     |
      | password   | more 20 chars       |  | password en fazla 20 karakter olmalıdır    |
      | password   | ok                  |  |                                            |
      | repassword | empty               |  | password zorunludur                        |
      | repassword | less 8 chars        |  | password en az 8 karakter olmalıdır        |
      | repassword | lack a number       |  | Password bir sayı içermelidir              |
      | repassword | lack a lower case   |  | Password bir küçük harf içermelidir        |
      | repassword | lack a upper case   |  | Password bir büyük harf içermelidir        |
      | repassword | lack a special char |  | Password bir özel karakter içermelidir     |
      | repassword | more 20 chars       |  | password en fazla 20 karakter olmalıdır    |
    #  | repassword | different           |  | repassword password ile aynı olmalıdır     |

  Scenario: Verify that the user can SignUp
    When User should see the input entity is "ok" on "repassword"
    And User click "Sign UpIn button" button
    Then User should Sign Up or Sign In

















