package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    WebDriver driver;
    WebDriverWait wait;

    public WaitUtils(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForElementVisible(WebElement element ){
       return  wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element){
       return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForURLContains(String urlText){
        return wait.until(ExpectedConditions.urlContains(urlText));
    }

    public List<WebElement> waitForElementsVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> waitForElementsVisibleByElement(List <WebElement> elements){
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}
