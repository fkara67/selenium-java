package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    @FindBy(xpath = "//b")
    private WebElement accountCreatedOrDeletedMessageWebElement;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueButton;



    public String getAccountCreatedMessage() {
        return accountCreatedOrDeletedMessageWebElement.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
