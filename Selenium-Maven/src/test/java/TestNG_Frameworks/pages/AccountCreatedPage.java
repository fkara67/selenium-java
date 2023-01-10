package TestNG_Frameworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    @FindBy(xpath = "//*[@id='form']/div/div/div/h2/b")
    private WebElement accountCreatedOrDeletedMessageWebElement;

    @FindBy(xpath = "//*[@id='form']/div/div/div/div/a")
    private WebElement continueButton;



    public String getAccountCreatedMessage() {
        return accountCreatedOrDeletedMessageWebElement.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
