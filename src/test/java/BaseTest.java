import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.DriverProvider;
import utils.ScreenshotUtil;

import java.io.IOException;

public class BaseTest {
    WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @BeforeClass
    public void setUp(){
        driver = DriverProvider.getDriver();
    }

    @AfterClass
    public void tearDown(){
        DriverProvider.quitDriver();
    }

    @BeforeMethod
    public void methodSetup(ITestResult result){
        LOGGER.info("Rozpoczęcie testu " + result.getMethod().getMethodName());

    }

    @AfterMethod
    public void methodTearDown(ITestResult result) throws IOException {
        LOGGER.info("Zakończenie testu " + result.getMethod().getMethodName());
        if(result.getStatus() != ITestResult.SUCCESS){
            String screenshotName = "screenshots/" + result.getName() + result.getEndMillis() + ".png";
            ScreenshotUtil.takeScreenshot(driver, screenshotName);
        }
    }
}
