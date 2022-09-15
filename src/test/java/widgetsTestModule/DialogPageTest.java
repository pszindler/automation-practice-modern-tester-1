package widgetsTestModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.DialogPage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DialogPageTest extends BaseTest {

    @Test
    void addUserAndCheckIsPresent() {
        DialogPage dialogPage = new DialogPage(driver);
        driver.get("https://seleniumui.moderntester.pl/modal-dialog.php");
        dialogPage.createUserClick()
                .clearForm()
                .fillUserForm("Aneta Puszka","apuszka@gmail.com", "12345678")
                .acceptForm();
        assertThat(dialogPage.getName()).isEqualTo("Aneta Puszka");
        assertThat(dialogPage.getEmail()).isEqualTo("apuszka@gmail.com");
        assertThat(dialogPage.getPassword()).isEqualTo(8);
    }
}
