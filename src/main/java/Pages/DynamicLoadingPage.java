package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicLoadingPage extends BasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicLoadingPage.class);
    public DynamicLoadingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ("#start > button"))
    private WebElement startButton;

    @FindBy(id = "loading")
    private WebElement loadingBar;

    @FindBy(css = "#finish > h4")
    private WebElement finishTextHeader;

    public DynamicLoadingPage clickStartButton(){
        LOGGER.debug("Uruchomienie ładowania");
        startButton.click();

        return this;
    }

    public DynamicLoadingPage checkLoadingStarted(){
        LOGGER.debug("Pojawienie się loadera");
        waitForElementToBeVisible(loadingBar);

        return this;
    }

    public DynamicLoadingPage checkLoadingFinished(){
        LOGGER.debug("Zniknięcie loadera");
        waitForElementToBeInvisible(loadingBar);

        return this;
    }

    public String finishLoadingConfirmation(){
        LOGGER.debug("Pojawienie się tekstu końcowego");
        waitForElementToBeVisible(finishTextHeader);

        return finishTextHeader.getText();
    }

}
