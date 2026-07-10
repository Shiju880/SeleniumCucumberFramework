package utils;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.PlaceOrderPage;
import pageObjects.ShopPage;

import java.io.IOException;

public class TestContextSetup {
    //driver
    public WebDriver driver;

    //Page Objects
    public LoginPage loginPage;
    public ShopPage shopPage;
    public CartPage cartPage;
    public PlaceOrderPage placeOrderPage;

    //Test Data Sharing variables
    public int productCount;                    /// its interlinked with two pages, so created a variable to store result and validate with other pages
    public int cartSize;

    //Assertions
    public SoftAssert softAssert;

    public TestContextSetup() throws IOException {
        BaseClass base = new BaseClass();
        driver = base.initializeDriver();

        loginPage = new LoginPage(driver);
        shopPage = new ShopPage(driver);
        cartPage = new CartPage(driver);
        placeOrderPage = new PlaceOrderPage(driver);

        softAssert = new SoftAssert();
    }

}
