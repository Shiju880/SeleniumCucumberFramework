package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class LoginPage {

     WebDriver driver;
     WaitUtils waitUtils;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".text-center.text-white")
    WebElement loginText;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameBox;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordBox;

    @FindBy(xpath = "//div[@class='modal-body']/p")
    WebElement confirmationMessage;

    @FindBy(css = "#okayBtn")
    WebElement messageAccepted;

    @FindBy(css = "#cancelBtn")
    WebElement messageDeclined;

    @FindBy(xpath = "//select[@class = 'form-control']")
    WebElement selectRole;

    @FindBy(css = "#terms")
    WebElement termsAndConditionCheckBox;

    @FindBy(css = "#signInBtn")
    WebElement signInBtn;

    @FindBy(xpath = "//input[@value = 'admin']")
    WebElement adminRadioBtn;

    @FindBy(css = ".alert-danger")
    WebElement errorMessage;

    public String extractUserName(){
        String userName = loginText.getText().split("username is ")[1].split(" and")[0].trim();
        return userName;
    }

    public String extractPassword(){
        String password = loginText.getText().split("Password is ")[1].trim().replace(")","");
        return password;
    }

    public void enterUserNameAndPassword(String userName, String password){
        userNameBox.clear();
        userNameBox.sendKeys(userName);

        passwordBox.clear();
        passwordBox.sendKeys(password);
    }

    public void optionSelection(String loginType){
        driver.findElement(By.xpath("//input[@value='"+loginType.toLowerCase()+"']")).click();
    }

    public String confirmationMessage(){
        WebElement element = waitUtils.waitForElementVisible(confirmationMessage);
        String confirmationMessage = element.getText();
        return confirmationMessage;
    }

    public void decliningMessage(){
        WebElement element =  waitUtils.waitForElementClickable(messageDeclined);
        element.click();
    }

    public void confirmingMessage(){
        WebElement element =  waitUtils.waitForElementClickable(messageAccepted);
        element.click();
    }

    public void roleSelection(String role){
        WebElement element = waitUtils.waitForElementVisible(selectRole);
        Select select = new Select(element);
        select.selectByVisibleText(role);
    }

    public void acceptTermsAndConditions(){
        termsAndConditionCheckBox.click();
    }

    public void signInClick(){
        signInBtn.click();
    }

    public boolean activeRadioBtn(){
        return adminRadioBtn.isSelected();
    }

    public String getErrorMessage(){
         WebElement element = waitUtils.waitForElementVisible(errorMessage);
         String errorMessage = element.getText().trim();
         return errorMessage;
    }
}
