package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[6]/div[@role='menuitem']")
    private WebElement music;

    @FindBy(xpath = "//li[6]/ul[@role='menu']/li[2]/div[@role='menuitem']")
    private WebElement jazz;

    @FindBy(xpath = "//li[2]/ul[@role='menu']/li[3]/div[@role='menuitem']")
    private WebElement modern;

    public void clickModernJazzMusicFromMenu() {
        actions.moveToElement(music).perform();
        wait.until(ExpectedConditions.visibilityOf(jazz));
        actions.moveToElement(jazz).perform();
        wait.until(ExpectedConditions.visibilityOf(modern));
        actions.moveToElement(modern).click().perform();
    }
}
