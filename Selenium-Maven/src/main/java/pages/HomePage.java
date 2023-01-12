package pages;

import utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;

    @FindBy(xpath = "//li[10]/a")
    private WebElement loggedInAsUserName_WebElement;

    @FindBy(css = "[href='/delete_account']")
    private WebElement deleteAccountButton;




    public void clickSignupLoginButton() {
        signupLoginButton.click();
    }

    public void clickProductsButton() {
        BrowserUtils.verifyElementDisplayed(productsButton);
        productsButton.click();
    }

    public String getLoggedInAsUserName_Text() {
        return loggedInAsUserName_WebElement.getText();
    }

    public void clickDeleteAccountButton() {
        deleteAccountButton.click();
    }
}
