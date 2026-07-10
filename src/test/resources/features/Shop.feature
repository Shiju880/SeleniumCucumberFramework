Feature: Shop Products
  @Smoke @Regression
  Scenario: Verify user able to add products in cart
    Given user is on ProtoCommerce shop page
    When user adds products to the cart
    | iphone X        |
    | Samsung Note 8  |
    | Nokia Edge      |
    | Blackberry      |
    Then shop page checkout count should match the selected products count
    When user proceeds to checkout
    Then selected products should be displayed in the cart