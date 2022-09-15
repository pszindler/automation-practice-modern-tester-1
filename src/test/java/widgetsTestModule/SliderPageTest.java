package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.SliderPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SliderPageTest extends BaseTest {

    @Test
    void testSlider() {
        SliderPage sliderPage = new SliderPage(driver);
        driver.get("https://seleniumui.moderntester.pl/slider.php");
        sliderPage.moveSlider("50");
        assertThat(sliderPage.getSlider().getText()).isEqualTo("50");
        sliderPage.moveSlider("80");
        assertThat(sliderPage.getSlider().getText()).isEqualTo("80");
        sliderPage.moveSlider("80");
        assertThat(sliderPage.getSlider().getText()).isEqualTo("80");
        sliderPage.moveSlider("20");
        assertThat(sliderPage.getSlider().getText()).isEqualTo("20");
        sliderPage.moveSlider("0");
        assertThat(sliderPage.getSlider().getText()).isEqualTo("0");
    }
}
