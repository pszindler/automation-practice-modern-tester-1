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

        // current day
        datePickerPage.enterCalendar();
        datePickerPage.selectToday();
        assertThat(datePickerPage.getPickedDate())
                .isEqualTo(datePickerPage.currentDate());

        // 1st of next month
        datePickerPage.enterCalendar();
        datePickerPage.waitForElement();
        datePickerPage.pickTheNextMonth(1);
        datePickerPage.pickTheDay("1").click();

        // next year january
        datePickerPage.enterCalendar();
        datePickerPage.waitForElement();
        datePickerPage.pickTheNextYearMonth("January");
        datePickerPage.pickTheDay("31").click();

        // same day
        datePickerPage.enterCalendar();
        datePickerPage.pickTheDay("31").click();

        // random day prev month
        datePickerPage.enterCalendar();
        datePickerPage.waitForElement();
        datePickerPage.previousMonthRandomDay();

        // random day random month last year
        datePickerPage.enterCalendar();
        datePickerPage.waitForElement();
        datePickerPage.pickRandomDateLastYear();
        datePickerPage.pickRandomDay();
    }
}
