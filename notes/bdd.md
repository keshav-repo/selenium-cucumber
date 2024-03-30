how is integrated 

### 1. what is bdd framework ?
1. BDD stands for Behavior-Driven Development
2. It is a software development methodology that aims to bridge the gap between technical and non-technical stakeholders by focusing on the behavior of a system rather than just its implementation details.
3. BDD encourages collaboration among developers, testers, and business stakeholders throughout the development process
4. A BDD framework, therefore, is a tool or a set of tools that facilitates the implementation of BDD practices. These frameworks typically provide a structured approach for defining, automating, and verifying the behavior of software systems.
5. Popular BDD frameworks include
    - Cucumber
    - SpecFlow
    - JBehave
    - Behat
6. natural language syntax
    - Gherkin
    - Markdown
    - yaml 


### 2. Example of bdd framework 
- Requirement is to add items to their shopping cart. we will write 
- Feature File (Written in Gherkin syntax):
```gherkin
Feature: Shopping Cart
    As a user
    I want to add items to my shopping cart
    So that I can purchase them later

Scenario: Add item to shopping cart
    Given I am on the product page
    When I click on the "Add to Cart" button for a product
    Then the product should be added to my shopping cart
    And the shopping cart should display the correct total price
```
- step defination
```java
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class ShoppingCartSteps {

    @Given("I am on the product page")
    public void goToProductPage() {
        // Code to navigate to the product page
    }

    @When("I click on the \"Add to Cart\" button for a product")
    public void clickAddToCartButton() {
        // Code to locate and click the "Add to Cart" button
    }

    @Then("the product should be added to my shopping cart")
    public void verifyProductAddedToCart() {
        // Code to verify that the product is added to the cart
    }

    @Then("the shopping cart should display the correct total price")
    public void verifyTotalPriceDisplayed() {
        // Code to verify that the correct total price is displayed in the shopping cart
    }
}

```
- test runner
```java
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions")
public class TestRunner {
    // This class just serves as a test runner to execute the Cucumber tests
}
```







