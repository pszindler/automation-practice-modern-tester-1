package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import pageObjects.ProgressBarPage;

public class ProgressBarPageTest extends BaseTest {

    @Test
    void checkIfCompleted() {
        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        progressBarPage.getLabelAfterComplete();

        assertThat(progressBarPage.getProgressLabel().getText()).isEqualTo("Complete!");
    }
}
