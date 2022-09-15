package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AutocompletePage extends BasePage {

    public AutocompletePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#search")
    private WebElement inputSearch;

    @FindBy(xpath = "//body/ul/li[@class='ui-menu-item']")
    private List<WebElement> autoSuggest;
    private WebElement selectedRandomOption;

    public AutocompletePage sendKeys(String text) {
        inputSearch.sendKeys(text);
        return this;
    }

    public AutocompletePage printAutoSuggest() {
        autoSuggest.forEach(suggest -> System.out.println(suggest.getText()));
        return this;
    }

    public AutocompletePage selectRandomOption() {
        selectedRandomOption = autoSuggest.get(generateRandomValue(autoSuggest));
        selectedRandomOption.click();
        return this;
    }

    public String getInputSearchValue() {
        return inputSearch.getText();
    }

    public WebElement getSelectedRandomOption() {
        return selectedRandomOption;
    }
}
