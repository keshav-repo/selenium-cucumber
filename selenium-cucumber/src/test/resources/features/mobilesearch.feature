Feature: Search feature of the web page

  @chrome
  Scenario: Search based on laptops
    Given I am at the home page
    When I click on the "Mobile" search filter
    Then I should be at the "Mobile" search page with "24" items
    And The title should be "Mobile- Buy Products Online at Best Price in India - All Categories | Flipkart.com" search page

    