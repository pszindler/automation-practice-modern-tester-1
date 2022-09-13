package basicTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.TablePage;

public class TablePageTest extends BaseTest {

    @Test
    public void printPeak() {
        TablePage tablePage = new TablePage(driver);
        driver.get("https://seleniumui.moderntester.pl/table.php");
        tablePage.printOutTheData();
    }
}
