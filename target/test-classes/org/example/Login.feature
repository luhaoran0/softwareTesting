Feature: Test login page

  Background:
    Given the homepage is open

  Scenario:
    Given the Username is filled with 'user@phptravels.com'
    And the Password is filled with 'demouser'
    And the Login button is clicked