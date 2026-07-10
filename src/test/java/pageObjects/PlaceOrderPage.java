package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

public class PlaceOrderPage {
    WebDriver driver;
    WaitUtils waitUtils;

    public PlaceOrderPage(WebDriver driver){
        this.driver=driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkOutBtn;

    @FindBy(css = "#country")
    WebElement countryBox;

    @FindBy(xpath = "//div[@class='suggestions']")
    WebElement countrySuggestion;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement purchaseBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    WebElement successMessage;

    @FindBy(css = "input#checkbox2")
    WebElement termsAndConditionCheckBox;

    public int checkOutBtnCount(){
        waitUtils.waitForElementVisible(checkOutBtn);
        String checkOutText = checkOutBtn.getText();
        return Integer.parseInt(checkOutText.replaceAll("[^0-9]",""));
    }

    public void enterCountry(String country){
        countryBox.sendKeys(country);
        waitUtils.waitForElementClickable(countrySuggestion);
        countrySuggestion.click();
    }

    public void purchaseBtnClick(){
        purchaseBtn.click();
    }

    public String placeOrderSuccess(){
       String message = waitUtils.waitForElementVisible(successMessage).getText();
       return message.substring(message.indexOf("Success!")).trim();

    }

    public void acceptTermsAndConditions(){
        termsAndConditionCheckBox.click();
    }

    public boolean successOrderIsDisplayed(){
        return waitUtils.waitForElementVisible(successMessage).isDisplayed();
    }


}
