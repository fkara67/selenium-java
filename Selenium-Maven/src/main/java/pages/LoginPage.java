package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    //div[3]/div/h2
    @FindBy(xpath = "//div[3]/div/h2")
    private WebElement newUserSignupMessageWebElement;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement signupNewUserNameBox;

    @FindBy(css = "[data-qa='signup-email']")
    private WebElement signupNewUserEmailBox;

    @FindBy(css = "[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(css = "[data-qa='login-email']")
    private WebElement loginEmailAddressBox;

    @FindBy(css = "[data-qa='login-password']")
    private WebElement loginPasswordBox;

    @FindBy(css = "[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//div/div/div[1]/div/h2")
    private WebElement loginToYourAccountMessageElement;



    public String getNewUserSignupMessage() {
        return newUserSignupMessageWebElement.getText();
    }

    public void setSignupNewUserName(String name) {
        signupNewUserNameBox.sendKeys(name);
    }

    public void setSignupNewUserEmail(String email) {
        signupNewUserEmailBox.sendKeys(email);
    }

    public void clickSignupButtton() {
        signupButton.click();
    }

    public void setLoginEmailAddress(String emailAddress) {
        loginEmailAddressBox.sendKeys(emailAddress);
    }

    public void setLoginPassword(String password) {
        loginPasswordBox.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getLoginToYourAccountMessage() {
        return loginToYourAccountMessageElement.getText();
    }

}
