package basicTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.IframePage;

public class IframePageTest extends BaseTest {

    @Test
    public void IFrameTest() {
        IframePage iframePage = new IframePage(driver);
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        iframePage.switchToLeftIFrame()
                .setFirstName("Darek")
                .setSurname("Kowalski")
                .defaultContent()
                .switchToRightIFrame()
                .setLogin("Login")
                .setPassword("passw04d")
                .selectContinents("asia")
                .selectYearsOfExp(5)
                .defaultContent()
                .selectButtonFromTopMenu();

    }
}
