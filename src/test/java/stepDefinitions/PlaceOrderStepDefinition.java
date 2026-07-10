package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.TestContextSetup;

public class PlaceOrderStepDefinition {
    TestContextSetup testContextSetup;

    public PlaceOrderStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        SoftAssert softAssert = new SoftAssert();
    }

    @Then("selected products count should be maintained in place order checkout cart")
    public void selected_products_count_should_be_maintained_in_place_order_checkout_cart() {
        Assert.assertEquals(testContextSetup.placeOrderPage.checkOutBtnCount(), testContextSetup.cartSize);
    }

    @When("user enter the country {string}")
    public void user_enter_the_country(String country) {
        testContextSetup.placeOrderPage.enterCountry(country);
    }
    @And("user place the order with accepting the Terms and conditions")
    public void user_place_the_order() {
        testContextSetup.placeOrderPage.acceptTermsAndConditions();
        testContextSetup.placeOrderPage.purchaseBtnClick();
    }

    @And("user place order without accepting Terms and Conditions")
    public void user_place_the_order_without_TnC() {
        testContextSetup.placeOrderPage.purchaseBtnClick();
    }

    @Then("order placed success should display")
    public void order_placed_success_should_display() {
        String expected = "Success! Thank you! Your order will be delivered in next few weeks :-).";
        Assert.assertEquals(testContextSetup.placeOrderPage.placeOrderSuccess(),expected);
    }

    @Then("order should be unsuccessful")
    public void order_should_be_unsuccessful() {
        Assert.assertFalse(testContextSetup.placeOrderPage.successOrderIsDisplayed());
    }



}
