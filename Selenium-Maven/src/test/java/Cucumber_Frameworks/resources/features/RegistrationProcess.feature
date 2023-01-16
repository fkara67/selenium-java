@smoke @registration
Feature: Register User

  As a user,
  we would like to be able to register successfully with non-existing email
  we do not expect to be able to register with already existing email

  RULES :
  - The user must have a non-existing email to register
  - User will get a generic error message following register attempt with already existing email

 Scenario Outline: Register with non-existing email
  This scenario tests that a user is able to successfully register when they enter valid credentials.

    Given the user is on the home page
    When the user clicks on Signup Login button
    Then the user verifies 'New User Signup!' is visible
    Given the user enters name"<name>" and email address"<email>"
    When clicks Signup button
    Then Verify that 'ENTER ACCOUNT INFORMATION' is visible
    Given select gender"<gender>" and select all checkboxes
    And the user fills all details p"<password>" fN"<firstName>" lN"<lastName>" cmpny"<company>" a"<address>" cntry"<country>" s"<state>" cty"<city>" zC"<zipcode>" mN"<mobileNumber>"
    When clicks Create Account button
    Then verifies that 'ACCOUNT CREATED!' is visible
    When the user clicks Continue button
    Then verifies that Logged in as "<name>" is visible
    When the user clicks Delete Account button
    Then verifies that 'ACCOUNT DELETED!' is visible and click Continue button
   Examples:
     | name | email        |password| firstName | lastName | company | address | country | state | city  | zipcode | mobileNumber |gender|
     |Fatih |kara@gmail.com|123456  | Fatih     | Kara     | inar    |cukur 67 | India   | Tefen | cukur | 67670   |61764116450   |Mr.|
     |Ceren |crn@gmail.com |3579246 |Ceren      |Karaca    | inar    |gokcebey | Canada  |Vncover| boston| 67675   |05418656213   |Mrs.|



