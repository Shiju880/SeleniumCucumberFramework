package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.List;

public class ShopPage {
     WebDriver driver;
     WaitUtils waitUtils;

    public ShopPage(WebDriver driver){
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//app-card-list[@class='row']/app-card")
    List <WebElement> productList;

    @FindBy(css = ".//button[contains(.,'Add')]")
    List <WebElement> addBtn;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkOutBtn;

    public boolean getShopURL(){
       return waitUtils.waitForURLContains("shop");
    }

    List<String> addedProducts = new ArrayList<>();
    public void addProducts(List <String> productNames){
        for (WebElement product : productList){
            String name = product.findElement(By.xpath(".//h4/a")).getText().trim();

            for (String productName : productNames){

                if (name.contains(productName)){
                    product.findElement(By.xpath(".//button[contains(.,'Add')]")).click();
                    addedProducts.add(productName);
                    break;
                }
            }
        }
    }

    public int addedProductList(){
        return addedProducts.size();
    }

    public String checkOutBtnCount(){
        waitUtils.waitForElementVisible(checkOutBtn);
        String checkOutText = checkOutBtn.getText();
        return checkOutText.replaceAll("[^0-9]","");
    }

    public void checkOutBtnClick(){
        checkOutBtn.click();
    }

}
