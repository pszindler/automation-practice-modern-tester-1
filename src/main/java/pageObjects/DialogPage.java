package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DialogPage extends BasePage {

    public DialogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#create-user")
    private WebElement createUserButton;
    @FindBy(css = "input#name")
    private WebElement inputName;
    @FindBy(css = "input#email")
    private WebElement inputMail;
    @FindBy(css = "input#password")
    private WebElement inputPassword;
    @FindBy(css = ".ui-dialog-buttonset button:nth-of-type(1)")
    private WebElement createAnAccountButton;
    @FindBy(css = "tr:nth-of-type(2) > td:nth-of-type(1)")
    private WebElement existingName;
    @FindBy(css = "tr:nth-of-type(2) > td:nth-of-type(2)")
    private WebElement existingEmail;
    @FindBy(css = "tr:nth-of-type(2) > td:nth-of-type(3)")
    private WebElement existingPassword;

    public DialogPage createUserClick() {
        createUserButton.click();
        return this;
    }

    public DialogPage fillUserForm(String userName, String email, String password) {
        inputName.sendKeys(userName);
        inputMail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }

    public DialogPage clearForm() {
        inputName.clear();
        inputPassword.clear();
        inputMail.clear();
        return this;
    }

    public DialogPage acceptForm() {
        createAnAccountButton.click();
        return this;
    }

    public String getName() {
        return existingName.getText();
    }

    public String getEmail() {
        return existingEmail.getText();
    }

    public Integer getPassword() {
        return existingPassword.getText().length();
    }


}
