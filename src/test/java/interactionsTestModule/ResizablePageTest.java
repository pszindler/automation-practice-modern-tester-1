package interactionsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.ResizablePage;

public class ResizablePageTest extends BaseTest {

    @Test
    public void resizableSquare() {
        ResizablePage resizablePage = new ResizablePage(driver);
        driver.get("https://seleniumui.moderntester.pl/resizable.php");
        // use variables with minus if you wanna stretch square in different direction (-120, -10, etc.).
        resizablePage.resizeSquareFromRight(10)
                     .resizeSquareFromBottom(10);
    }
}