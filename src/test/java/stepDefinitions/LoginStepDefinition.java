package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;

public class LoginStepDefinition {
    TestContextSetup testContextSetup;

    public LoginStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @When("the user provides userName and password")
    public void the_user_provides_user_name_and_password() {
        String userName = testContextSetup.loginPage.extractUserName();
        String password = testContextSetup.loginPage.extractPassword();

        testContextSetup.loginPage.enterUserNameAndPassword(userName, password);
    }

    @And("select the {string} login type")
    public void select_the_login_type(String loginType ) {
        testContextSetup.loginPage.optionSelection(loginType);
    }

    @Then("confirmation message should be displayed")
    public void confirmation_message_should_be_displayed() {
        String actualMessage = testContextSetup.loginPage.confirmationMessage();
        String expectedMessage = "You will be limited to only fewer functionalities of the app. Proceed?";
        testContextSetup.softAssert.assertEquals(actualMessage, expectedMessage);
    }

    @When("user accept the confirm message")
    public void user_accept_the_confirm_message() {
        testContextSetup.loginPage.confirmingMessage();
    }

    @And("select the {string} role")
    public void select_the_role(String role) {
        testContextSetup.loginPage.roleSelection(role);
    }

    @And("signIn with accepting the Terms and Conditions")
    public void sign_in_with_accepting_the_terms_and_conditions() {
        testContextSetup.loginPage.acceptTermsAndConditions();
        testContextSetup.loginPage.signInClick();
    }

    @Then("user should be redirected to the ProtoCommerce Shop Page")
    public void user_should_be_redirected_to_the_proto_commerce_home_page() {
        Assert.assertTrue(testContextSetup.shopPage.getShopURL());
    }

    @When("the user decline the confirm message")
    public void the_user_decline_the_confirm_message() {
        testContextSetup.loginPage.decliningMessage();
    }

    @Then("the Admin option should be selected by default.")
    public void the_admin_option_should_be_selected_by_default() {
       Assert.assertTrue( testContextSetup.loginPage.activeRadioBtn());
    }

    @When("the user provides incorrect {string} and {string}")
    public void the_user_provides_incorrect_and(String userName, String password) {
        testContextSetup.loginPage.enterUserNameAndPassword(userName, password);
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage = testContextSetup.loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }

    @And("user signs in without accepting Terms and Conditions")
    public void user_signs_in_without_accepting_terms_and_conditions() {
        testContextSetup.loginPage.signInClick();
    }

    @Then("user should not be redirected to ProtoCommerce Shop Page")
    public void user_should_not_be_redirected_to_proto_commerce_shop_page() {
        Assert.assertFalse(testContextSetup.shopPage.getShopURL());
    }
}