package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Random random = new Random();

     BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIMEOUT);
        actions = new Actions(driver);
    }

    public int generateRandomValue(List<WebElement> elements) {
        int maxBound = elements.size();
        return random.nextInt(maxBound);
    }



}
