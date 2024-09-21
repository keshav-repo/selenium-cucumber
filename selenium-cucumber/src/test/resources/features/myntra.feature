Feature: Search lehenga in myntra

  @chrome
  Scenario: Search based on lehenga
    Given I am at the myntra home page
    When I entered "Jeans Women" in search text field
    Then Clicked to first search product