Feature: PlaceOrder Validation
  Background:
    Given user is on ProtoCommerce shop page
    When user adds products to the cart
      | iphone X        |
      | Samsung Note 8  |
    And user proceeds to checkout
    And user proceed on place Order



  Scenario: Verify checkout product count is same as cart product count
    Then selected products count should be maintained in place order checkout cart


  Scenario: Verify user successfully place the order
    When user enter the country "India"
    And user place the order with accepting the Terms and conditions
    Then order placed success should display

  @Debug
  Scenario: Verify place order is restricted when user does not accept Terms and Conditions
    When user enter the country "India"
    And user place order without accepting Terms and Conditions
    Then order should be unsuccessful



