Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a simple scenario

 Scenario Outline: add a new person
    Given I am on peoples page
    Then I press add person button
    Then I enter person name: "<name>" using PO
    Then I enter surname: "<surname>" using PO
    Then I enter job: "<job>" using PO
    Then I enter dob: "<dob>" using PO
    Then I select languages: "<language>" using PO
    Then I select gender: "<gender>"
    And I press add button
   Examples:
     | name | surname | job | dob | language | gender |
     | Siva | Sundar | Developer | 22-05-1996 | spanish | male  |
     | Suji | Kumar | Test Eng | 28-03-1996 | french | female |

   Scenario: edit a person
     When I am on peoples page
     Then I click edit button
     Then I edit name: "Sivakarthi"
     And press edit button


  Scenario: remove a person
    When I am on peoples page
    Then I click delete button


  Scenario: reset page
    When I am on peoples page
    Then I reset the page

  Scenario: check that clear button on adding a user works correctly
    When I am on peoples page
    Then I press add person button
    Then I enter person name: "Siva" using PO
    Then I enter surname: "Karthi" using PO
    Then I enter job: "Developer" using PO
    Then I enter dob: "22051996" using PO
    Then I select languages: "french" using PO
    Then I select gender: "male"
    And press clear button
    Then check all inputs are clears
