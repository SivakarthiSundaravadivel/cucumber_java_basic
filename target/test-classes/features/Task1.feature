Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  Scenario: Correct Number
    When I am on the enter a number page
    Then I should enter correct number
    And I should click submit button
    And I should see the alert box with square root

    Scenario Outline: Wrong Number
      When I am on the enter_a_number page
      Then I should enter wrong number : <number>
      And I should click submit_button
      And I should see the error message : "<message>"
      Examples:
        | number  |  message                 |
        | 40      |  Number is too small     |
        | 110     |  Number is too big       |
        | abc     |  Please enter a number   |
