package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    private static WebDriver driver = null;

    public static WebDriver getDriver(){
        if (driver == null) {
                 WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(setFirefoxOptions());
            }
        setUpDriver();
        return driver;
    }

    public static void setUpDriver(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static FirefoxOptions setFirefoxOptions(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");
        return options;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}
