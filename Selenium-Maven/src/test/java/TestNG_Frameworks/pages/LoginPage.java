package TestNG_Frameworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[3]/div/h2")
    private WebElement signupTitle;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupNewUserNameBox;

    @FindBy(css = "[data-qa='signup-email']")
    private WebElement signupNewUserEmailBox;

    @FindBy(css = "[data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy(xpath = "//div/div/div[1]/div/h2")
    private WebElement LoginTitle;

    @FindBy(css = "[data-qa='login-email']")
    private WebElement loginEmailAddressBox;

    @FindBy(css = "[data-qa='login-password']")
    private WebElement loginPasswordBox;

    @FindBy(css = "[data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[1]/div/form/p")
    private WebElement loginIncorrectMessage;


    public String getSignupTitle() {
        return signupTitle.getText();
    }

    public void setSignupNewUserName(String name) {
        signupNewUserNameBox.sendKeys(name);
    }

    public void setSignupNewUserEmail(String email) {
        signupNewUserEmailBox.sendKeys(email);
    }

    public void setLoginEmail(String emailAddress) {
        loginEmailAddressBox.sendKeys(emailAddress);
    }

    public void setLoginPassword(String password) {
        loginPasswordBox.sendKeys(password);
    }

    public String getLoginTitle() {
        return LoginTitle.getText();
    }

    public String getLoginIncorrectMessage() {
        return loginIncorrectMessage.getText();
    }
}
