package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HighSitePage extends BasePage {

    public HighSitePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#scroll-button")
    private WebElement submitButton;

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void scrolling() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        while (true) {
            js.executeScript("window.scrollBy(0,350)", "");
            try {
                clickSubmitButton();
                break;
            } catch (NoSuchElementException e) {}
        }

    }


}
