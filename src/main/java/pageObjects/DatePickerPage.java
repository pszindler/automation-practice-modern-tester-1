package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    Date date = new Date();

    public String currentDate() {
        return java.time.LocalDate.now().format(dtf);
    }

    public LocalDate calculateNextMonth(int month) {
        return LocalDate.now().plusMonths(month);
    }

    public void enterCalendar() {
        datePicker.click();
    }

    public String getPickedDate() {
        return datePicker.getAttribute("value");
    }

    public String getLastDayOfTheMonth(){
        return "sd";
    }

    public void selectToday() {
        today.click();
    }

    public void pickTheDay(String dayYouPick) {
        days.stream().filter(d -> !d.getAttribute("class")
                .contains("ui-datepicker-other-month") && (d.getText()
                        .equals(dayYouPick)))
                .findFirst().ifPresent(WebElement::click);
    }

    public void pickTheNextMonth(int month) {
        Month futureMonth = calculateNextMonth(month).getMonth();
        System.out.println(monthCSS.getText());
        System.out.println(futureMonth.name());
        while(!monthCSS.getText().toUpperCase().equals(futureMonth.name())) {
            nextMonth.click();
        }
    }


}
