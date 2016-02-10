Feature: New Item
  I can create and manage new jobs

  Scenario: Create a new job
  New job must be successfully created with the correct details
    When I initiate a New Item addition with the following values:
      | Name     | Type         |
      | RANDOM_5 | External Job |
    And I specify new "External Job" details with the following values:
      | Description | Discard Old Builds |
      | RANDOM_10   | false              |
    And I save job details
    Then I should see the following created New Item:
      | Type         | Name          | Description          |
      | External Job | DATA_itemName | DATA_itemDescription |
