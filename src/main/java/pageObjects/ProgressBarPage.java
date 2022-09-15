package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProgressBarPage extends BasePage {

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".progress-label")
    private WebElement progressLabel;

    public String getLabelAfterComplete() {
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".progress-label"), "Complete!"));
        return progressLabel.getText();
    }

    public WebElement getProgressLabel() {
        return progressLabel;
    }
}
