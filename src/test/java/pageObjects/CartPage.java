package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.util.List;

public class CartPage {
    WebDriver driver;
    WaitUtils waitUtils;

    public CartPage(WebDriver driver){
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4/a")
    List <WebElement> cartLists;

    @FindBy(css = "#exampleInputEmail1")
    List <WebElement> productsQuantityBoxes;

    @FindBy(xpath = "//table/tbody/tr/td[3]")
    List <WebElement> productPrices;

    @FindBy(xpath = "//table/tbody/tr/td[4]")
    List <WebElement> productTotalPrices;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Remove'])[1]")
    WebElement removeList;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Continue Shopping'])[1]")
    WebElement continueClick;

    @FindBy(xpath = "//h3/strong")
    WebElement grandTotalPrice;

    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Checkout'])[1]")
    WebElement mainCheckoutClick;


    public int cartListSize(){
        List <WebElement> elementList = waitUtils.waitForElementsVisibleByElement(cartLists);
        return elementList.size();
    }

    public void provideProductQuantity(String quantity){
        productsQuantityBoxes.get(0).clear();
        productsQuantityBoxes.get(0).sendKeys(quantity);
    }

    public int getQuantity(){
        String quantity = productsQuantityBoxes.get(0).getAttribute("value");
        return Integer.parseInt(quantity);
    }

    public int extractProductPrice(){
        String price = productPrices.get(0).getText().replaceAll("[^0-9]", "").trim();
        return Integer.parseInt(price);
    }

    public int CalculateAllProductPrice(){
        int sum = 0;
        for(WebElement productTotalPrice : productTotalPrices){
            String amount = productTotalPrice.getText().replaceAll("[^0-9]", "").trim();

            if(!amount.isEmpty()){
                sum = sum + Integer.parseInt(amount);
            }
        }
        return sum;
    }

    public int extractProductTotalPrice(){
        String totalPrice = productTotalPrices.get(0).getText().replaceAll("[^0-9]", "").trim();
        return Integer.parseInt(totalPrice);
    }

    public int extractGrandTotal(){
        String grandTotal = grandTotalPrice.getText().replaceAll("[^0-9]","").trim();
        return Integer.parseInt(grandTotal);
    }

    public void removeProduct(){
        waitUtils.waitForElementClickable(removeList).click();
    }

    public void continueShopping(){
        waitUtils.waitForElementClickable(continueClick).click();
    }

    public void mainCheckOutBtn(){
        waitUtils.waitForElementClickable(mainCheckoutClick).click();
    }

}
