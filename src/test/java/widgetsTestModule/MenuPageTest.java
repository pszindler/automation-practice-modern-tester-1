package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.MenuPage;

public class MenuPageTest extends BaseTest {

    @Test
    void selectModerJazzMusicTest() {
        MenuPage menuPage = new MenuPage(driver);
        driver.get("https://seleniumui.moderntester.pl/menu-item.php");
        menuPage.clickModernJazzMusicFromMenu();
    }
}
