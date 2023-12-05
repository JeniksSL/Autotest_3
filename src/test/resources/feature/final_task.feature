Feature: Pass the final testing test
  As a student
  I want pass final task in www.wiggle.com testing

    Scenario Outline: Open terms and conditions page and
    ask questions in conversation menu
      Given a web browser is on www.wiggle.com page
      And a cookie agreement button is pressed
      And main page is scrolled to footer
      When the accept terms and conditions link is pressed
      Then terms and conditions page is displayed
      And wiggle chat wrapper is shown
      When wiggle chat wrapper is clicked
      Then wiggle live chat is displayed
      When "<message>" is typed in typed area of wiggle live chat
      And enter key is pressed
      Then "<message>" is displayed in chat area


      Examples:
        |message  |
         |hello|
        |123123|
      |!@##$%#%|

