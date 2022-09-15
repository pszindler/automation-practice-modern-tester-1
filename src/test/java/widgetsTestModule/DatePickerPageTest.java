package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.DatePickerPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DatePickerPageTest extends BaseTest {

    @Test
    void todayTest() {
        driver.get("https://seleniumui.moderntester.pl/datepicker.php");
        DatePickerPage datePickerPage = new DatePickerPage(driver);
        datePickerPage.enterCalendar();
        datePickerPage.selectToday();
        assertThat(datePickerPage.getPickedDate())
                .isEqualTo(datePickerPage.currentDate());

        //
        datePickerPage.enterCalendar();
        datePickerPage.pickTheNextMonth(1);
        datePickerPage.pickTheDay("1");
    }
}
