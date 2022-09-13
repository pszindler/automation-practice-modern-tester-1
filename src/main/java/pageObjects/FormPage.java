package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.util.List;

public class FormPage extends BasePage {

    @FindBy(css = "#inputFirstName3")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id='inputLastName3']")
    private WebElement lastName;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexOptions;

    @FindBy(id = "selectContinents")
    private WebElement continent;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;

    @FindBy(id = "inputEmail3")
    private WebElement email;

    @FindBy(id = "inputAge3")
    private WebElement age;

    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experienceOptions;

    @FindBy(id = "gridCheckManulTester")
    private WebElement manualTesterProfession;

    @FindBy(id = "gridCheckAutomationTester")
    private WebElement automationTesterProfession;

    @FindBy(id = "gridCheckOther")
    private WebElement otherProfession;

    @FindBy(id = "chooseFile")
    private WebElement fileUpload;

    @FindBy(className = "btn-primary")
    private WebElement sendFormBtn;

    @FindBy(id = "validator-message")
    private WebElement validatorMessage;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public FormPage sendForm() {
        sendFormBtn.click();
        return this;
    }

    public String getValidatorMessage() {
        return validatorMessage.getText();
    }

    public FormPage uploadFile(File file) {
        fileUpload.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage selectAutomationTesterProfession() {
        automationTesterProfession.click();
        return this;
    }

    public FormPage selectRandomYearsOfExperience() {
        int value = generateRandomValue(experienceOptions);
        experienceOptions.get(value).click();
        return this;
    }

    public FormPage setFirstName(String name) {
        firstName.sendKeys(name);
        return this;
    }

    public FormPage setEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    public FormPage setAge(String age) {
        this.age.sendKeys(age);
        return this;
    }


    public FormPage setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
        return this;
    }

    public FormPage selectRandomGender() {
        int value = generateRandomValue(sexOptions);
        sexOptions.get(value).click();
        return this;
    }

    public FormPage selectRandomContinent() {
        List<WebElement> op = new Select(continent).getOptions();
        int rnd = generateRandomValue(op);
        if (rnd > 0) {
            new Select(continent).selectByIndex(rnd);
        } else {
            new Select(continent).selectByIndex(rnd + 1);
        }
        return this;
    }

    public FormPage selectCommands(String value) {
        new Select(seleniumCommands).selectByValue(value);
        return this;
    }


}