Feature: Browse topics

  Scenario Outline: User clicks topic title <Topic> at the main Support page and navigates to the topic <Topic> page
    Given user at the main Support page
    When user clicks topic "<Topic>"
    Then list of questions is displayed
    And  heading with topics is displayed
    And "<Topic>" is active
    Examples:
      | Topic  |
      | Pro    |
      | Basics |

  Scenario Outline: User can search with keyword <keyword>
    Given user at the main Support page
    When user enters keyword "<keyword>" to the Search field
    And user Clicks Search button
    Then user can see a list of answers relevant to keyword "<keyword>"
    Examples:
      | keyword  |
      | username |


      Scenario Outline: User opens answer to the question from the list of topic "<Topic>"
        Given user at the main Support page
        When user clicks topic "<Topic>"
        And user clicks the question number 1 in the list
        Then user can see the answer to the question clicked
        Examples:
          | Topic  |
          | Pro    |
          | Basics |