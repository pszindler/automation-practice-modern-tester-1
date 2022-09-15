package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.AutocompletePage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class AutocompletePageTest extends BaseTest {

    @Test
    void autocompleteTest() {
        AutocompletePage autocompletePage = new AutocompletePage(driver);
        driver.get("https://seleniumui.moderntester.pl/autocomplete.php");
        autocompletePage.sendKeys("a")
                .printAutoSuggest()
                .selectRandomOption();

        assertThat(autocompletePage.getSelectedRandomOption().getText())
                .isEqualTo(autocompletePage.getInputSearchValue());
    }
}
