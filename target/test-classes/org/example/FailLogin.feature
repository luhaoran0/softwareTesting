Feature: Test login page

  Background:
    Given the adminpage is open

  Scenario Outline:
    Given the Email is filled with '<email>' and Password with '<password>'
    When When the Login button is clicked
    Then '<msg>' shown
    Examples:
      | email                     | password          | msg |
      | asd@asd.com               | asdf              |  Invalid Login Credentials |
      | admin@phptravels.com      | asdwwwd           | Invalid Login Credentials |
      | user@ptrels.com           | demouser          | Invalid Login Credentials |
      |                           |asfdasdf           | The Email field is required. |
      |dasda@asdf.com             |                   | The Password field is required. |
  #Yanlış kimlik bilgileri. Tekrar deneyin!
  #Wrong credentials. try again!