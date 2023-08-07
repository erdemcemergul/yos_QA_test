Feature: Departments

  Background: user is on the Departments Module
    Given User is on the app
    Given User is already logged in.
    Given User click "Departments" button
    #Given User select the Turkish language




  Scenario: User can see the selected informations of cards
    When User click the "SelectCities" dropdown menu
    And User select city(ies)
    And User click the "SelectUniversities" dropdown menu
    And User select university(ies)
    And User click the "SelectDepartments" dropdown menu
    And User select department(s)
    Then Card of "department" name should come from API
    Then Card of "faculty" name should come from API
    Then Card of "university" name should come from API
    Then Card of "city" name should come from API
    When User click "Compare" button
    Then User should add to compare
    When User click "Favourite" button
    Then User should add to favourite
    When User click "UserMenu" button
    And  User click "Compare Departments" button
    And User click "Compared" button
    Then User should delete to compare
    When User click "UserMenu" button
    And  User click "Favourite Departments" button
    When User click "Favourite" button
    Then User should delete to Favourite


  Scenario: User can not compare and favourite the cards with logout.
    When User click "UserMenu" button
    When User click "Log Out" button
    When User click the "SelectCities" dropdown menu
    And User select city(ies)
    And User click the "SelectUniversities" dropdown menu
    And User select university(ies)
    And User click the "SelectDepartments" dropdown menu
    And User select department(s)
    When User click "Favourite" button
    Then User see that don't change of favourite button
    When User click "Compare" button
    Then User see that don't change of compare button


