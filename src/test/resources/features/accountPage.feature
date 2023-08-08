Feature: Account

  Background: User is on the My Account Page
    Given User is on the app
    Given User is already logged in.
    Given User click "UserMenu" button
    Given User click "MyProfile" button

  Scenario: User should be able to see numbers of sections
    When User clicks "My Favorite Universities" section
    Then User should see same amount of My Favorite Universities card
    And User click "UserMenu" button
    And User click "Compare Departments" button
    Then User should see same amount of My Compare List card

  Scenario: User should be able to save the given informations
    When User should fill out the mandatory areas
    Then User click Save button
    Then Profil updates check from API

  Scenario: User should be able to change the password
    When User click "Change Password" button
    When User enters "Current Password" into box from the excel sheet
    Then User enters "New Password" into box from the excel sheet
    Then User enters "ReNew Password" into box from the excel sheet
   # Then User click "Save" button
   # When User enters "New Password" into box from the excel sheet
   # Then User enters "Current Password" into box from the excel sheet
   # Then User enters "Current Password" into box from the excel sheet
   # Then User click "Save" button
   # Then Password updates check from API


