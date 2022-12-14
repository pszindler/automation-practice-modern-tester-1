package basicTestModule;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageObjects.AlertsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AlertsPageTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"OK button pressed"})
    @DisplayName("Check simple alert pop up")
    @Tag("alert")
    @Tag("basic")
    void checkSimpleAlertPopUp(String label) {
        AlertsPage alertsPage = new AlertsPage(driver);
        String result = alertsPage.clickAndAcceptTheSimpleAlert();
        assertThat(result).isEqualTo(label);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Lord Vader"})
    @DisplayName("Check prompt alert box")
    @Tag("alert")
    @Tag("basic")
    void checkPromptAlertBox(String text) {
        AlertsPage alertsPage = new AlertsPage(driver);
        String result = alertsPage.clickAndAcceptTheConfirmAlert(text);
        assertThat(result).isEqualTo("Hello %s! How are you today?".formatted(text));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("Check confirm alert box")
    @Tag("alert")
    @Tag("basic")
    void checkConfirmAlertBox(Boolean isAccept) {
        AlertsPage alertsPage = new AlertsPage(driver);
        String result = alertsPage.clickConfirmAlertBox(isAccept);
        if (isAccept) {
            assertThat(result).isEqualTo("You pressed OK!");
        } else {
            assertThat(result).isEqualTo("You pressed Cancel!");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"OK button pressed"})
    @DisplayName("Check delayed alert")
    @Tag("alert")
    @Tag("basic")
    void checkDelayedAlert(String label) {
        AlertsPage alertsPage = new AlertsPage(driver);
        String result = alertsPage.clickDelayedAlert();
        assertThat(result).isEqualTo(label);
    }


}
