Feature: Test login page

  Background:
    Given the homepage is open
    And the Username is filled with 'user@phptravels.com'
    And the Password is filled with 'demouser'
    And the Login button is clicked

  Scenario:
    Given Flights page is open
    And From enter 'LON - All Airports - London'
    And Destination enter 'BUD - Ferihegy - Budapest'
    And Date is enter '30-12-2022'
    And Search is clicked
#    And Account is clicked
    #
    And Dashboard is open
    Then Recent Searches is shown

