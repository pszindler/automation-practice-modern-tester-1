package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SelectMenuPage extends BasePage {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span#speed-button")
    public WebElement selectSpeedDropDown;
    @FindBy(css = "ul#speed-menu li")
    public List<WebElement> speedList;
    @FindBy(css = "span#files-button")
    public WebElement selectFileDropDown;
    @FindBy(css = "ul#files-menu li.ui-menu-item")
    public List<WebElement> fileList;
    @FindBy(css = "span#number-button")
    public WebElement selectNumberDropDown;
    @FindBy(css = "span#salutation-button")
    public WebElement selectTitleDropDown;
    @FindBy(css = " ul#salutation-menu li.ui-menu-item")
    private List<WebElement> titleList;
    @FindBy(css = "ul#number-menu > li")
    private List<WebElement> numbersList;

    public SelectMenuPage selectRandomSpeed() {
        selectSpeedDropDown.click();
        speedList.get(generateRandomValue(speedList)).click();
        return this;
    }

    public SelectMenuPage selectFile(String text) {
        selectFileDropDown.click();
        WebElement el = fileList.stream()
                .filter(webElement -> Objects.equals(webElement.getText(), text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No WebElement found containing text: " + text));
        el.click();
        return this;
    }

    public SelectMenuPage selectNumber(int number) {
        selectNumberDropDown.click();
        numbersList.get(number - 1).click();
        return this;
    }

    public SelectMenuPage selectRandomTitle() {
        selectTitleDropDown.click();
        int value = generateRandomValue(titleList);
        titleList.get(value == 0 ? value + 1 : value).click();
        return this;
    }
}
