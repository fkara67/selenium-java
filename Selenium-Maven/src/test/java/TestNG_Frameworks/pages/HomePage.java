package TestNG_Frameworks.pages;

import TestNG_Frameworks.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    @FindBy(css = "a[href='/products']")
    protected WebElement productsButton;

    @FindBy(xpath = "//li[10]/a")
    protected WebElement loggedInAsUserName_WebElement;

    @FindBy(css = "[href='/delete_account']")
    protected WebElement deleteAccountButton;



    public void click(WebElement element) {
        element.click();
    }

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
