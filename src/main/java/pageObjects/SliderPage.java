package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends BasePage {

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div#custom-handle")
    private WebElement slider;

    public WebElement getSlider() {
        return slider;
    }

    public String moveSlider(String value) {
        slider.click();
        while(!slider.getText().equals(value)) {
            if (Integer.parseInt(slider.getText()) < Integer.parseInt(value)) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.ARROW_LEFT);
            }
        }
        return slider.getText();
    }

}
