package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    private static final String WELCOME_MESSAGE = "Welcome to the-internet";
    private static final String DESCRIPTION_HEADER = "Available Examples";

    @FindBy(tagName = "h1")
    private WebElement welcomeHeader;

    @FindBy(tagName = "h2")
    private WebElement descriptionHeader;

    public HomePage checkWelcomeMessage(){
        String welcomeText = welcomeHeader.getText();

        Assert.assertEquals(welcomeText, WELCOME_MESSAGE);
        return this;
    }

    public HomePage checkSecondPageDescriptionHeader(){
        String descriptionHeaderText = descriptionHeader.getText();

        Assert.assertEquals(descriptionHeaderText, DESCRIPTION_HEADER);
        return this;
    }
}
