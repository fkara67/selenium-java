package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RegistrationSteps extends BaseStep {
    SoftAssert softAssert = new SoftAssert();

    @Given("the user is on the home page")
    public void theUser_is_on_home_page() {
        String URL = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        System.out.println("Open ::" + URL);
        BrowserUtils.implicitlyWait(5);
    }

    @When("the user clicks on Signup Login button")
    public void the_user_clicks_on_Signup_Login_button() {
        pages.getHomePage().clickSignupLoginButton();
    }

    @Then("the user verifies {string} is visible")
    public void the_user_verifies_is_visible(String string) {
        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();
        softAssert.assertEquals(newUserSignUpMessage, string, "Test Case 1 - Verify 'New User Signup!' is visible");
    }

    @Given("the user enters name{string} and email address{string}")
    public void theUserEntersNameAndEmailAddress(String name, String email) {
        pages.getLoginPage().setSignupNewUserName(name);
        pages.getLoginPage().setSignupNewUserEmail(email);
    }

    @When("clicks Signup button")
    public void clicks_signup_button() {
        pages.getLoginPage().clickSignupButtton();
    }

    @Then("Verify that {string} is visible")
    public void verifyENTER_ACCOUNT_INFORMATION_is_visible(String expectedTitle) {
        String actualTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualTitle, expectedTitle,
                "Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }
    // select gender"<gender>" and select all checkboxes
    @Given("select gender{string} and select all checkboxes")
    public void select_gender_select_all_checkboxes(String gender) {
        if ((gender.equals("Mr."))) {
            pages.getSignupPage().selectTitleMen();
        } else {
            pages.getSignupPage().selectTitleWomen();
        }
        pages.getSignupPage().selectTitleWomen();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,900)");
        pages.getSignupPage().selectSignupForOurNewsletter_Checkbox();
        pages.getSignupPage().selectReceiveSpecialOffers_Checkbox();
    }

// password"<password>" "<firstName>" "<lastName>" "<company> "<address>" "<country>" "<state>" "<city>" "<zipcode>" "<mobileNumber>"

    @Given("the user fills all details p{string} fN{string} lN{string} cmpny{string} a{string} cntry{string} s{string} cty{string} zC{string} mN{string}")
    public void the_user_fills_all_detailsPFNLNCmpnyCntrySCtyZCMN(String password,
                                                                  String firstName, String lastName, String company, String address,
                                                                  String country, String state, String city, String zipcode, String mobileNumber) {
        pages.getSignupPage().setPassword(password);
        pages.getSignupPage().setDateOfBirt("23", "April", "1999");
        pages.getSignupPage().setFirstName(firstName);
        pages.getSignupPage().setLastName(lastName);
        pages.getSignupPage().setCompany(company);
        pages.getSignupPage().setAddress(address);
        pages.getSignupPage().setCountry(country);
        pages.getSignupPage().setState(state);
        pages.getSignupPage().setCity(city);
        pages.getSignupPage().setZipcode(zipcode);
        pages.getSignupPage().setMobileNumber(mobileNumber);
        /*pages.getSignupPage().the_user_fills_all_detailsPFNLNCmpnyCntrySCtyZCMN(String password,
                String firstName, String lastName, String company, String address,
                String country, String state, String city, String zipcode, String mobileNumber);*/
    }


    @When("clicks Create Account button")
    public void clicksCreateAccountButton() {
        pages.getSignupPage().clickCreateAccountButton();
    }

    @Then("verifies that {string} is visible")
    public void verifies_ACCOUNT_CREATED_is_visible(String expectedMessage) {
        String actualMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(actualMessage, expectedMessage,
                "Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible");
    }

    @When("the user clicks Continue button")
    public void the_user_clicks_Continue_button() {
        pages.getAccountCreatedPage().clickContinueButton();
        BrowserUtils.navigateBackAndForwardToDismissAds();
    }

    // Then verifies that 'Logged in as "<name>"' is visible
    @Then("verifies that Logged in as {string} is visible")
    public void verifies_that_LoggedInAsUserName_is_visible(String userName) {
        String actualLoggedInInfo = pages.getHomePage().getLoggedInAsUserName_Text();
        softAssert.assertTrue(actualLoggedInInfo.contains(userName),
                "Test Case 1 - Verify that 'Logged in as username' is visible");
    }

    @When("the user clicks Delete Account button")
    public void the_user_clicks_Delete_Account_button()  {
        pages.getHomePage().clickDeleteAccountButton();
    }

    @Then("verifies that {string} is visible and click Continue button")
    public void verifies_that_ACCOUNT_DELETED_is_visible_and_click_Continue_button(String expectedDeleteMessage) {
        String actualDeleteMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(actualDeleteMessage, expectedDeleteMessage,
                "Test Case 1 - Verify that 'ACCOUNT DELETED!' is visible");
        pages.getAccountCreatedPage().clickContinueButton();
    }
}
