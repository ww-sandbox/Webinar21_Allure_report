import Pages.DynamicLoadingPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicLoadingPageTests extends BaseTest {
    DynamicLoadingPage dynamicLoadingPage;
    static final String EXPECTED_CONFIRMATION_TEXT = "Hello World!";

    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Test
    public void startButtonIsDisplayed(){
        dynamicLoadingPage.clickStartButton()
                .checkLoadingStarted()
                .checkLoadingFinished();
        String actualConfirmationText = dynamicLoadingPage.finishLoadingConfirmation();

        Assert.assertEquals(actualConfirmationText, EXPECTED_CONFIRMATION_TEXT);
    }
}
