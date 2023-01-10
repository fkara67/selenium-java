package TestNG_Frameworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends BasePage {
    @FindBy(xpath = "//b")
    private WebElement accountDeletedMessageWebElement;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueButton;



    public String getAccountDeletedMessage() {
        return accountDeletedMessageWebElement.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
