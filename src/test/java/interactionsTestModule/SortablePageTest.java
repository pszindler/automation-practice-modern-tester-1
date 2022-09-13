package interactionsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.SortablePage;

public class SortablePageTest extends BaseTest {

    @Test
    public void shuffleTest() {
        driver.get("https://seleniumui.moderntester.pl/sortable.php");
        SortablePage sortablePage = new SortablePage(driver);
        sortablePage.shuffleList();
    }
}
