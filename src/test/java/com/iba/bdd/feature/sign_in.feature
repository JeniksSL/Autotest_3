Feature: Sign in on www.wiggle.com
  As a user
  I want to sign in on www.wiggle.com
  Scenario: 01. Open log in to Wiggle page
    Given a web browser is on www.wiggle.com page
    And a cookie agreement window is displayed
    When the accept cookies button is pressed
    And the sign in button is pressed
    Then the log in to Wiggle page is shown
  Scenario: 02. Sign in on www.wiggle.com
    Given a web browser is on log in to Wiggle page
    And email address is entered
    And password is entered
    When the continue button is pressed
    Then the main Wiggle page is shown
    And account link is displayed