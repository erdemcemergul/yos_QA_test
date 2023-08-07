Feature: Home Page Test Cases

  Background: User is on the Home Page
    Given User is on the app


  Scenario: User can enter "Universities" page
    When User click "Universities" button
    Then User should go to "Universities" page

  Scenario: User can enter "Departments" page
    When User click "Departments" button
    Then User should go to "Departments" page

  Scenario: User can enter index page.
    When User click "Home" button
    Then User should go to "Home" page


  Scenario: User can select the Departments
    When User click the "SelectCities" dropdown menu
    Then User should see available "city" list
    And User select "city(ies)"
    And User click the "SelectUniversities" dropdown menu
    Then User should see available "university" list
    And User select "university(ies)"
    And User click the "SelectDepartments" dropdown menu
    Then User should see available "department" list


  Scenario: User can see SignIn popup window by clicking "Sign In" button
    When User click "Sign In" button
    Then User should go to "Sign In" page

  Scenario: User can see SignUp popup window by clicking "Sign Up" button
    When User click "Sign Up" button
    Then User should go to "Sign Up" page


  Scenario: User can subscribe by clicking "Subscribe" button
    When User enter valid mail address
    Then User click Subscribe button
    #Then User should see "Successfully subscribed" alert
    Then User see warning of alert
    Then Email should come from API


  Scenario: User cannot navigate to pages without login
    When User click "myProfile" button
    Then User see warning of alert
    When User click "myFavourite" button
    Then User see warning of alert

 # Scenario: User can navigate to pages
#    When User click "About Us" button
#    Then User should go to "About Us" page
#    When User click "FAQs page" button
#    Then User should go to "FAQs page" page
#    When User click "Chekcout" button
#    Then User should go to "Chekcout" page
#    When User click "Contact" button
#    Then User should go to "Contact" page
#    When User click "Blog" button
#    Then User should go to "Blog" page


  Scenario: User can change the language

   # When User select the Turkish language
    #Then User should see Turkish webpage
   # When User select the English language
    #Then User should see English webpage

  Scenario: User cannot add favorite or compare without login
    When User click "Favourite" button
    Then User see warning of alert
    When User click "Compare" button
    Then User see warning of alert
