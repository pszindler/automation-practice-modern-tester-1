package interactionsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.SelectablePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectablePageTest extends BaseTest {

    @Test
    public void selectableTest() {
        SelectablePage selectablePage = new SelectablePage(driver);
        driver.get("https://seleniumui.moderntester.pl/selectable.php");
        selectablePage.selectItem();

        assertThat(selectablePage.textResult()).isEqualTo("You've selected:");
        assertThat(selectablePage.selectedItems()).isEqualTo("#1 #3 #4");

    }

}