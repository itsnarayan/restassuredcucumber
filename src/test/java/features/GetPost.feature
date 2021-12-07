Feature:
  Verify different operations using REST-assured Basics

  Scenario: Verify one author of post
    Given I perform GET operation for number "1"
    Then I should see author name as "Narayan"

  Scenario: performContainsCollection
    Given I perform GET operation to check contains for number "1"
    Then I should see author name as "Narayan"

  Scenario: Verify pathParameter
    Given I perform GET operation for post number "1"
    Then I should see author name as "Narayan"

  Scenario: Verify QueryParameter
    Given I perform query parameter to GET operation for post number "1"
    Then I should see author name as "Narayan"

  Scenario: Perform PostOperation
    Given I perform post with body parameter for "/posts"