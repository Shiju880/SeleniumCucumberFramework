package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

import java.util.List;

public class ShopStepDefinition {
    TestContextSetup testContextSetup;

    public ShopStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("user is on ProtoCommerce shop page")
    public void user_is_on_proto_commerce_shop_page() {
        String userName = testContextSetup.loginPage.extractUserName();
        String password = testContextSetup.loginPage.extractPassword();

        testContextSetup.loginPage.enterUserNameAndPassword(userName, password);
        testContextSetup.loginPage.signInClick();
        testContextSetup.softAssert.assertTrue(testContextSetup.shopPage.getShopURL());
    }

    @When("user adds products to the cart")
    public void user_adds_products_to_the_cart(List<String> productName) {
        testContextSetup.shopPage.addProducts(productName);
    }

    @Then("shop page checkout count should match the selected products count")
    public void shop_page_checkout_count_should_match_the_selected_products_count() {
        testContextSetup.productCount = testContextSetup.shopPage.addedProductList();
        int checkOutCount = Integer.parseInt(testContextSetup.shopPage.checkOutBtnCount());

        testContextSetup.softAssert.assertEquals(testContextSetup.productCount,checkOutCount);
    }

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        testContextSetup.shopPage.checkOutBtnClick();
    }

}
