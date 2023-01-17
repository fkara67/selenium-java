package TestNG_Frameworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[href='/login']")
    public WebElement signupLoginButton;

    @FindBy(css = "a[href='/products']")
    public WebElement productsButton;

    @FindBy(xpath = "//li[10]/a")
    protected WebElement loggedInAsUserName_WebElement;

    @FindBy(css = "[href='/delete_account']")
    public WebElement deleteAccountButton;

    @FindBy(css = "[href='/logout']")
    public WebElement logoutButton;


    public String getLoggedInAsUserName_Text() {
        return loggedInAsUserName_WebElement.getText();
    }

}
