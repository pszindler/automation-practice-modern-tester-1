package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class DatePickerPage extends BasePage {
    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-datepicker-today")
    private WebElement today;
    @FindBy(css = "tr td")
    private List<WebElement> days;
    @FindBy(css = "#datepicker")
    private WebElement datePicker;
    @FindBy(css = ".ui-datepicker-month")
    private WebElement monthCSS;
    @FindBy(css = ".ui-datepicker-year")
    private WebElement yearCSS;
    @FindBy(css = "[data-handler='next']")
    private WebElement nextMonth;
    @FindBy(css = "[data-handler='prev']")
    private WebElement prevMonth;
    Calendar cal = Calendar.getInstance();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public String currentDate() {
        return java.time.LocalDate.now().format(dtf);
    }

    public LocalDate calculateNextMonth(int months) {
        return LocalDate.now().plusMonths(months);
    }

    public LocalDate calculateNextYear(int years) {
        return LocalDate.now().plusYears(years);
    }

    public LocalDate calculatePrevYear(int years) {
        return LocalDate.now().minusYears(years);
    }

    public void enterCalendar() {
        datePicker.click();
    }

    public String getPickedDate() {
        return datePicker.getAttribute("value");
    }

    public void waitForElement() {
        wait.until(ExpectedConditions.visibilityOf(nextMonth));
    }

    public void selectToday() {
        today.click();
    }

    public WebElement pickTheDay(String dayYouPick) {
        return days.stream().filter(d -> !d.getAttribute("class")
                .contains("ui-datepicker-other-month") && (d.getText()
                        .equals(dayYouPick)))
                .findFirst().orElse(null);
    }

    public void pickTheNextMonth(int month) {
        Month futureMonth = calculateNextMonth(month).getMonth();
        while(!monthCSS.getText().toUpperCase().equals(futureMonth.name())) {
            nextMonth.click();
        }
    }

    public void pickTheNextYearMonth(String month) {
        int year = calculateNextYear(1).getYear();
        while(!monthCSS.getText().equals(month) && !yearCSS.getText().equals(String.valueOf(year))) {
            nextMonth.click();
        }
    }

    public void previousMonthRandomDay() {
        prevMonth.click();
        WebElement el = null;
        while(el == null){
            int day = generateRandomValue(days);
            el = pickTheDay(String.valueOf(day));
        }
        el.click();
    }

    public String randomMonth() {
        int monthNumber = new Random().nextInt(12);
        return Month.of(monthNumber).toString();
    }

    public String pickTheLastYear() {
        int year = calculatePrevYear(1).getYear();
        return String.valueOf(year);
    }

    public void pickRandomDateLastYear() {
        int year = calculatePrevYear(1).getYear();
        String month = randomMonth();
        while(!monthCSS.getText().toUpperCase().equals(month) && !yearCSS.getText().equals(String.valueOf(year))) {
            prevMonth.click();
        }
    }

    public void pickRandomDay() {
        int day = new Random().nextInt(28);
        WebElement el = pickTheDay(String.valueOf(day));
        el.click();
    }


}
