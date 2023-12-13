

Feature: Sign in on www.wiggle.com
  As a user
  I want to sign in on www.wiggle.com
  Scenario: 01. Open log in to Wiggle page
    Given a web browser is on page "https://www.wiggle.co.uk/"
    And the accept cookies button is pressed
    When the sign in link is pressed
    Then the log in to Wiggle page is shown


  Scenario: 02. Sign in on Wiggle
    Given a web browser is on log in to Wiggle page
    And email address and password is entered
    When the continue button is pressed
    Then the main Wiggle page is shown
    And account link is displayed
