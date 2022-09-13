package basicTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.TablePage;
import pageObjects.WindowPage;

public class WindowPageTest extends BaseTest {

    @Test
    public void windowsChange() {
        WindowPage windowPage = new WindowPage(driver);
        TablePage tablePage = new TablePage(driver);
        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");
        String baseWindow = windowPage.getOriginalWindow();
        windowPage.newBrowserWindow()
                .switchToNewWindow();
        tablePage.printOutTheData();
        windowPage.closeWindow()
                .backToOriginalWindow(baseWindow)
                .newMessageWindow()
                .switchToNewWindow();
        System.out.println(windowPage.getBodyText());
        windowPage.closeWindow()
                .backToOriginalWindow(baseWindow)
                .newBrowserTab()
                .switchToNewWindow();
        tablePage.printOutTheData();
        windowPage.closeWindow();
    }
}
