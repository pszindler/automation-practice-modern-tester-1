package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResizablePage extends BasePage {

    @FindBy(css = "#resizable")
    private WebElement resizable;

    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public ResizablePage resizeSquareFromRight(int stretch) {
        int width = resizable.getSize().width;
        int height = resizable.getSize().height;
        actions.moveToElement(resizable, (width / 2) - 1 , -(height / 2) + 1 )
                .clickAndHold().moveByOffset(stretch,-1).release().build().perform();
        return this;
    }

    public ResizablePage resizeSquareFromBottom(int stretch) {
        int width = resizable.getSize().width;
        int height = resizable.getSize().height;
        actions.moveToElement(resizable, 1 , (height / 2) +1)
                .clickAndHold().moveByOffset(-1,-stretch).release().build().perform();
        return this;
    }
}