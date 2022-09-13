package interactionsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.DraggablePage;

public class DraggablePageTest extends BaseTest {

    @Test
    public void moveTheElement() {
        DraggablePage draggablePage = new DraggablePage(driver);
        driver.get("https://seleniumui.moderntester.pl/draggable.php");
        draggablePage.moveToTheRightTop()
                     .moveToTheRightBottom()
                     .moveToTheCenter()
                     .moveToTheBottomLeft();
    }
}