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

    public void sendKeys(String text) {
        inputSearch.sendKeys(text);
    }

    public void printAutoSuggest() {
        for (WebElement suggest: autoSuggest) {
            System.out.println(suggest.getText());
        }
    }

    public void selectRandomOption() {

    }

    public String getInputSearchValue() {
        return inputSearch.getText();
    }

}
