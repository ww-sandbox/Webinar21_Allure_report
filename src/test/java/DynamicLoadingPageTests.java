import Pages.DynamicLoadingPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicLoadingPageTests extends BaseTest {
    DynamicLoadingPage dynamicLoadingPage;
    static final String EXPECTED_CONFIRMATION_TEXT = "Hello World!";

    @Owner("John Tester")
    @Epic("EDU-11")
    @Story("EDU-121")
    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Severity(SeverityLevel.MINOR)
    @TmsLink("EDU-999")
    @Test
    public void startButtonIsDisplayed(){
        dynamicLoadingPage.clickStartButton()
                .checkLoadingStarted()
                .checkLoadingFinished();
        String actualConfirmationText = dynamicLoadingPage.finishLoadingConfirmation();

        Assert.assertEquals(actualConfirmationText, EXPECTED_CONFIRMATION_TEXT);
    }
}
