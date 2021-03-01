import Pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    HomePage homePage;

    @BeforeClass
    public void setUp(){
        super.setUp();
        driver.get("http://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void checkMainHeaderText(){
        homePage.checkWelcomeMessage();
    }

    @Test
    public void checkDescriptionHeaderText(){
        homePage.checkSecondPageDescriptionHeader();
    }
}
