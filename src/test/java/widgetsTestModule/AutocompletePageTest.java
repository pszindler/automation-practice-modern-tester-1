package widgetsTestModule;

import base.BaseTest;
import com.beust.ah.A;
import org.junit.jupiter.api.Test;
import pageObjects.AutocompletePage;

public class AutocompletePageTest extends BaseTest {

    @Test
    void test() {
        AutocompletePage autocompletePage = new AutocompletePage(driver);
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        autocompletePage.sendKeys("a");
        autocompletePage.printAutoSuggest();
    }
}
