package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortablePage extends BasePage {

    @FindBy(css = "#sortable li")
    private List<WebElement> items;

    public List<WebElement> getItems() {
        return items;
    }

    List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    private void shuffleTable() {
        Collections.shuffle(nums);
    }

    public void shuffleList() {
        shuffleTable();
        System.out.println(nums);
        for (int i = 0; i < 7; i++) {
            int position = nums.get(i);
            WebElement drag = driver.findElement(By.xpath("//li[contains(text(), 'Item " + position + "')]"));
            WebElement drop = getItems().get(i);
            actions.dragAndDrop(drag, drop).perform();
        }
    }



}
