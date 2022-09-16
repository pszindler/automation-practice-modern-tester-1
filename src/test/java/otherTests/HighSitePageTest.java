package otherTests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.HighSitePage;

public class HighSitePageTest extends BaseTest {


    @Test
    void scrollTest() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");
        HighSitePage highSitePage = new HighSitePage(driver);

        highSitePage.scrolling();
    }
}
