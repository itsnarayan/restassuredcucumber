Feature:
  Verify different operations using REST-assured Extension util

  Scenario: Verify one author of post
    Given I perform GET operation for post "/posts"
    Then I should see author name has Item "Narayan"

  Scenario: Perform PostOperation using Extension util
    Given I perform post operation for "/posts"
    Then I should see response has author name "Taylor"

  Scenario: Verify post operation for profile
    Given I perform post operation for "/posts/{profileNo}/profile" with body
      | name | profile |
      | John | 1       |
    Then I should see body has name as "John"