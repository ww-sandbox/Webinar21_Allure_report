package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement waitForElementToBeClickable(WebElement element){
        wait = new WebDriverWait(driver, 5);

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeVisible(WebElement element){
        wait = new WebDriverWait(driver, 5);

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean waitForElementToBeInvisible(WebElement element){
        wait = new WebDriverWait(driver, 5);

        return wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
