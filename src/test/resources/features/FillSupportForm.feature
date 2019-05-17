Feature: Ask Support
  Scenario: User fills all required fields of ASK SUPPORT form and clicks Submit button
    Given user at the main Support page
    When user clicks ASK SUPPORT button
    And user selects "I have a Question/Feedback" as an issue type
    And user types "test@test.com" as an email address
    And user fills Subject by "testtestets"
    And user fills Descrition by "testtest"
    And select "browser" as a platform
    And select "opera" as a browser
    Then user can click Submit button


