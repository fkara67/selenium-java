package TestNG_Frameworks.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransitionPage extends BasePage {

    @FindBy(xpath = "//*[@id='form']/div/div/div/h2/b")
    private WebElement infoMessage;

    @FindBy(xpath = "//*[@id='form']/div/div/div/div/a")
    public WebElement continueButton;



    public String getInfoMessage() {
        return infoMessage.getText();
    }

}
