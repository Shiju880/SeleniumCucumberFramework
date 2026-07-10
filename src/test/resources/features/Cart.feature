Feature: Cart Validation
  Background:
    Given user is on ProtoCommerce shop page
    When user adds products to the cart
      | iphone X        |
      | Samsung Note 8  |
    And user proceeds to checkout


  Scenario: Verify user able to increase the quantity of the product.
    And the user provide the product quantity "3"
    Then product total price should update
    And cart grand total should match the total price of all products
    And user proceed on place Order


  Scenario: Verify user able to remove the product
    Then user should able to remove the product
    And cart grand total should match the total price of all products


  Scenario: Verify user able to increase the quantity of the product.
    And the user provide the product quantity "-10"
    Then product total price should not update


  Scenario: Verify added product should retain after continue shopping
    When user proceed on continue shopping
    Then selected products count should be maintained in shop page checkout cart