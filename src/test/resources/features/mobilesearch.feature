Feature: Search feature of the web page

  Scenario: Search based on laptops
    Given I am at the home page
    When I click on the "Laptops" search filter
    Then I should be at the "Laptops" search page with "24" items
    And The title should be "Laptops- Buy Products Online at Best Price in India - All Categories | Flipkart.com" search page
