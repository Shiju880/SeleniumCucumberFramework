package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

public class CartStepDefinition {
    TestContextSetup testContextSetup;

    public CartStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("selected products should be displayed in the cart")
    public void selected_products_should_be_displayed_in_the_cart() {
        int cartProductList = testContextSetup.cartPage.cartListSize();

        Assert.assertEquals(testContextSetup.productCount, cartProductList);
    }

    int beforeTotal;
    int afterTotal;
    @When("the user provide the product quantity {string}")
    public void the_user_provide_the_product(String quantity) {
        beforeTotal = testContextSetup.cartPage.extractProductTotalPrice();
        testContextSetup.cartPage.provideProductQuantity(quantity);
        afterTotal = testContextSetup.cartPage.extractProductTotalPrice();
    }

    @Then("product total price should update")
    public void product_total_price_should_update() {
        testContextSetup.softAssert.assertEquals(testContextSetup.cartPage.extractProductTotalPrice(),
                (testContextSetup.cartPage.extractProductPrice()*testContextSetup.cartPage.getQuantity()));
    }

    @And("cart grand total should match the total price of all products")
    public
    void cartGrandTotalShouldMatchTheTotalPriceOfAllProducts(){
        Assert.assertEquals(testContextSetup.cartPage.CalculateAllProductPrice(), testContextSetup.cartPage.extractGrandTotal());
    }

    @Then("user should able to remove the product")
    public void userShouldAbleToRemoveTheProduct(){
        int beforeRemove = testContextSetup.cartPage.cartListSize();
        testContextSetup.cartPage.removeProduct();
        int afterRemove = testContextSetup.cartPage.cartListSize();
        testContextSetup.softAssert.assertEquals(afterRemove, beforeRemove-1);
    }

    @Then("product total price should not update")                      /// beforeTotal and afterTotal variable used for this validation.
    public void thenProductTotalPriceShouldNotUpdate(){
        Assert.assertEquals(beforeTotal, afterTotal);
    }


    @When("user proceed on continue shopping")
    public void user_proceed_on_continue_shopping() {
        testContextSetup.cartSize = testContextSetup.cartPage.cartListSize();
        testContextSetup.cartPage.continueShopping();
    }

    @Then("selected products count should be maintained in shop page checkout cart")
    public void selected_products_count_should_be_maintained_in_shop_page_checkout_cart() {
        Assert.assertEquals(Integer.parseInt(testContextSetup.shopPage.checkOutBtnCount()), testContextSetup.cartSize) ;
    }

    @And ("user proceed on place Order")
    public void userProceedOnPlaceOrder(){
        testContextSetup.cartSize = testContextSetup.cartPage.cartListSize();
        testContextSetup.cartPage.mainCheckOutBtn();
    }

}
