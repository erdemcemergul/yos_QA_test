Feature: Universities

  Background: user is on the Universities Module
    Given User is on the app
    Given User is already logged in.
    Given User click "Universities" button

  Scenario: User can be able to see correct adress information from API for tr
   # When User select the Turkish language
    When User see the logo information
    When User click "Continue" button
    And User see the phone information
    And User see the name information
    And User see the adress information
    And User see the department information
    Then Information should be same with API from documentation for Turkish

  #Scenario: User can be able to see correct adress information from API for en
    #When User see the adress information
   # When User select the English language
    #When User see the phone information
    #And User see the name information
    #When User see the city information
    #And User see the department information
    #Then Information should be same with API from documentation for English





