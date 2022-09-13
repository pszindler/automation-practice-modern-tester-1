package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.AccordionPage;

public class AccordionPageTest extends BaseTest {

    @Test
    public void test() {
        AccordionPage accordionPage = new AccordionPage(driver);
        accordionPage.clickOnSection();
    }
}
