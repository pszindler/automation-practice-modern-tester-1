package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutocompletePage extends BasePage {

    AutocompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#search")
    private WebElement inputSearch;

    @FindBy(css = "")
    private WebElement autoSuggest;

    public void sendKeys(String text) {
        inputSearch.sendKeys(text);
    }

    public void printAutoSuggest() {

    }

    public void selectRandomOption() {

    }

    public String getInputSearchValue() {
        return inputSearch.getText();
    }

}
