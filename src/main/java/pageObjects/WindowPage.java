package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowPage extends BasePage {
    @FindBy(css = "button#newBrowserWindow")
    private WebElement newBrowserWindowButton;
    @FindBy(css = "button#newMessageWindow")
    private WebElement newMessageWindowButton;
    @FindBy(css = "button#newBrowserTab")
    private WebElement newBrowserTabButton;
    @FindBy(css = "body")
    private WebElement bodyText;

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    public WindowPage newBrowserWindow() {
        newBrowserWindowButton.click();
        return this;
    }

    public WindowPage newMessageWindow() {
        newMessageWindowButton.click();
        return this;
    }

    public WindowPage newBrowserTab() {
        newBrowserTabButton.click();
        return this;
    }

    public String getBodyText() {
        return bodyText.getText();
    }

    public WindowPage closeWindow() {
        driver.close();
        return this;
    }

    public WindowPage backToOriginalWindow(String originalWindow) {
        driver.switchTo().window(originalWindow);
        return this;
    }

    public String getOriginalWindow() {
        return driver.getWindowHandle();
    }

    public WindowPage switchToNewWindow() {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!getOriginalWindow().contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

}
