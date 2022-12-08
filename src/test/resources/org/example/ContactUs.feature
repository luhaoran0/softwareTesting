Feature: Test contact us page
  Background:
    Given Contact us page is open

  Scenario:Success
    Given the First name is filled with 'LU' and Last name with 'Haoran' and Email with 'lll@ldfjk.com' and Message with 'messagee'
    When send message
    Then Show Thanks for contacting us

  Scenario Outline:Fail
    Given the First name is filled with '<firstname>' and Last name with '<lastname>' and Email with '<email>' and Message with '<msg>'
    When send message
    Then error shown with '<emsg>'
    Examples:
      | firstname | lastname | email|msg|emsg|
      |Lu         |          |      |   | Make sure you fill in all required fields.   |
    |           |  Haoran    |      |   |  Make sure you fill in all required fields.  |
    |           |            |ll@l.com|   |  Make sure you fill in all required fields. |
    |           |            |        |message|Make sure you fill in all required fields.|
    |Lu         |Haoran      |        |       |Make sure you fill in all required fields.|
    |Lu         |            |ll@l.com|       |Make sure you fill in all required fields.|
