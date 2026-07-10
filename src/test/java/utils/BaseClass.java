package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        /// Setting up Global Properties
        // It will run on any system. No code changes are required, just update the Global property file.
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);

        ///Browser Logic
        String Browser = prop.getProperty("Browser");
        if (Browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }
        else if (Browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        /// URL Logic
        String Environment = prop.getProperty("Environment");
        String url = null;
        if (Environment.equalsIgnoreCase("SIT")){
            url = prop.getProperty("SITUrl");
        }
        else if (Environment.equalsIgnoreCase("UAT")){
            url = prop.getProperty("UATUrl");
        }
        driver.get(url);

        return driver;
    }
}
