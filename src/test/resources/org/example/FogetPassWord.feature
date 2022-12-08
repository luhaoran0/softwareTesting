Feature: Test login page

  Background:
    Given the adminpage is open

  Scenario Outline:
    Given press forget password
    And enter '<email>'
    When reset password
    Then password '<msg>' shown
    Examples:
      | email               | msg                                                            |
      |ll@l.com             |  Email Not Found                                               |
      |asd                  |Email Not Found                                                 |
      |qwe@                 |Email Not Found                                                 |
      | admin@phptravels.com|  New Password sent to admin@phptravels.com, Kindly check email.|

  Scenario:
    Given press forget password
    And enter ' '
    When reset password
    Then Alert shown 'Please Enter Email Address'