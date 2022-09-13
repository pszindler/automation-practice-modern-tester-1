package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    @FindBy(css = "#draggable")
    private WebElement drag;
    @FindBy(css = "#droppable")
    private WebElement drop;
    @FindBy(css = "#droppable p")
    private WebElement messageAfterDrop;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop() {
        actions.dragAndDrop(drag, drop).perform();
    }

    public String validateMessage() {
        return messageAfterDrop.getText();
    }
}