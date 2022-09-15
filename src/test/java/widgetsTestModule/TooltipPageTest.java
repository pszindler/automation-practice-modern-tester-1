package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.TooltipPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TooltipPageTest extends BaseTest {

    @Test
    void tooltipTest() {
        driver.get("https://seleniumui.moderntester.pl/tooltip.php");
        TooltipPage tooltipPage = new TooltipPage(driver);
        tooltipPage.getTextFromTooltip();
    }
}
