package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.SelectMenuPage;

public class SelectMenuPageTest extends BaseTest {

    @Test
    void selectMenu() {
        SelectMenuPage selectMenuPage = new SelectMenuPage(driver);
        driver.get("https://seleniumui.moderntester.pl/selectmenu.php");
        selectMenuPage.selectRandomSpeed()
                .selectRandomTitle()
                .selectFile("ui.jQuery.js")
                .selectNumber(10);
    }
}
