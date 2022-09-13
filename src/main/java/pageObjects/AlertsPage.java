package pageObjects;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {

    @FindBy(css = "#simple-alert")
    private WebElement buttonSimpleAlert;
    @FindBy(css = "#simple-alert-label")
    private WebElement simpleAlertLabel;
    @FindBy(css = "#prompt-alert")
    private WebElement buttonPromptAlert;
    @FindBy(css = "#prompt-label")
    private WebElement promptAlertLabel;
    @FindBy(css = "#delayed-alert")
    private WebElement buttonDelayedAlert;
    @FindBy(css = "#delayed-alert-label")
    private WebElement delayedAlertLabel;
    @FindBy(css = "#confirm-alert")
    private WebElement buttonConfirmAlert;
    @FindBy(css = "#confirm-label")
    private WebElement confirmAlertLabel;

    public String clickAndAcceptTheSimpleAlert() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        buttonSimpleAlert.click();
        driver.switchTo().alert().dismiss();
        return simpleAlertLabel.getText();
    }

    public String clickAndAcceptTheConfirmAlert(String text) {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        buttonPromptAlert.click();
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
        return promptAlertLabel.getText();
    }

    public String clickConfirmAlertBox(Boolean isAccepted) {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        buttonConfirmAlert.click();
        if (isAccepted) {
            driver.switchTo().alert().accept();
        } else {
            driver.switchTo().alert().dismiss();
        }
        return confirmAlertLabel.getText();
    }

    public String clickDelayedAlert() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        buttonDelayedAlert.click();
        wait.ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return delayedAlertLabel.getText();
    }

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

}
