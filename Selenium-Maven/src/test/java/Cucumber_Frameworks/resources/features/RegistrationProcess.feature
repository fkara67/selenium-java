@smoke @registration
Feature: Registration Processes

  As a user,
  we would like to be able to register successfully with non-existing email
  we do not expect to be able to register with already existing email

  RULES :
  - The user must have a non-existing email to register
  - User will get a generic error message following register attempt with already existing email

  Scenario: The user successfully register with valid credentials.
  This scenario tests that a user is able to successfully register when they enter valid credentials.

    Given the user is on the home page
    When the user clicks on 'Signup / Login' button and verifies 'New User Signup!' is visible
    And the user enters name and email address,clicks 'Signup' button and Verify that 'ENTER ACCOUNT INFORMATION' is visible
    And the user fills all details and selects all checkboxes and clicks 'Create Account button' and verifies that 'ACCOUNT CREATED!' is visible
    And the user clicks 'Continue' button and verifies that 'Logged in as username' is visible
    And the user clicks 'Delete Account' button and verifies that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    Then the user should be logged in
    Then the user arrives at the home page and welcome text containing the username "Tester"
