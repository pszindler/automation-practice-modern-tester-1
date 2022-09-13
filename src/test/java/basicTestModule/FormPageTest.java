package basicTestModule;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageObjects.FormPage;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class FormPageTest extends BaseTest {
    Faker faker = new Faker();
    private final File file = new File("C:\\Development\\SzkolenieTesterskie\\SeleniumModernTester\\automation-practice-modern-tester\\src\\main\\files\\test-file-to-upload.xlsx");

    @ParameterizedTest
    @ValueSource(strings = {"Form send with success"})
    @DisplayName("Form test - positive case")
    @Tag("form")
    @Tag("basic")
    void fillTheFormWithSuccess(String label) {
        FormPage formPage = new FormPage(driver);
        driver.get("https://seleniumui.moderntester.pl/form.php");
        formPage.setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setAge("55")
                .selectRandomGender()
                .selectRandomYearsOfExperience()
                .selectAutomationTesterProfession()
                .selectRandomContinent()
                .selectCommands("switch-commands")
                .selectCommands("wait-commands")
                .uploadFile(file)
                .sendForm();

        assertThat(formPage.getValidatorMessage()).isEqualTo(label);

    }




}
