package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TooltipPage extends BasePage {
    public TooltipPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".tooltips [title]")
    private List<WebElement> tooltipContent;

    public void getTextFromTooltip() {
        tooltipContent.forEach(e -> System.out.println(e.getAttribute("title")));
    }


}
