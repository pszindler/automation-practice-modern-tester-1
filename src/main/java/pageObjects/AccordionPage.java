package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AccordionPage extends BasePage {

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='accordion']/h3")
    private List<WebElement> sections;


    public AccordionPage clickOnSection() {
        driver.get("https://seleniumui.moderntester.pl/accordion.php");
        int divElement = 0;
        for (WebElement element: sections) {
            divElement++;
                if (element.getAttribute("aria-selected").equals("false")) {
                    element.click();
                    WebElement ariaSectionText = driver.findElement(By.xpath("//div[@id='accordion']/div["+divElement+"]"));
                    wait.until(ExpectedConditions.visibilityOf(ariaSectionText));
                    System.out.println(ariaSectionText.getAttribute("textContent").trim());

                } else {
                    System.out.println(driver.findElement(By.xpath("//div[@id='accordion']/div["+divElement+"]")).getText());
                }
            }
        return this;
    }
}
