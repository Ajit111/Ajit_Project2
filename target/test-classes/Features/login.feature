Feature: Launch browser

  @login
  Scenario: Open Chrome browser
   # Given I Open the Chrome Browser
    Given Enter Username
    Then Enter Password
    Then click on login button
    # Then click on Remove button
    Then Homepage should display
    Then Scroll Down
    Then Scroll Up
    # Then page should be scroll down
    # Then page should be scroll down
    Then click on add to cart button
    Then click on add to cart button then 1 count will be visible
    Then click on cart button
    Then click on Checkout button
    Then Enter First Name
    Then Enter Last Name
    Then Enter Postal Code
    Then Click on Continue Button
    Then Click on Finish Button