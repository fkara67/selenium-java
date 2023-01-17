package TestNG_Frameworks.org.inar.automationexercise;



import TestNG_Frameworks.pages.HomePage;
import TestNG_Frameworks.pages.LoginPage;
import TestNG_Frameworks.pages.SignupPage;
import TestNG_Frameworks.utilities.BrowserUtils;
import TestNG_Frameworks.utilities.ConfigurationReader;
import TestNG_Frameworks.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static TestNG_Frameworks.utilities.BrowserUtils.click;

public class RegistrationTests extends BaseTest   {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();

    // We should use soft assertion because in this test case we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setUpSuit() {
        // code that is executed before the entire test suite
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");
        //Launch browser and Navigate to url 'http://automationexercise.com'
        driver.get(URL);
        System.out.println("   :::::::::: Test Information ::::::::::\n\tURL :" + URL + "\n\tBrowser :"
                + browser + "\n\tEnvironment :" + environment);
        System.out.println("   ::::::::::::::::::::::::::::::::::::::");
        BrowserUtils.implicitlyWait(5);
    }

    @Test
    public void TestCase_1_Register_User() {

        String userName = "Ceren";
        // Verify that home page is visible successfully
        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise",
                "Test Case 1 - Verify that home page is visible successfully");

        // Click on 'Signup / Login' button
        click(homePage.signupLoginButton);

        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();
        // Verify 'New User Signup!' is visible
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!",
                "Test Case 1 - Verify 'New User Signup!' is visible");

        // Enter name and email address - Click 'Signup' button
        pages.getLoginPage().setSignupNewUserName(userName);
        pages.getLoginPage().setSignupNewUserEmail("ceren67@gmail.com");
        click(loginPage.signupButton);

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualEnterAccountInformationTitle = pages.getSignupPage().getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle,"ENTER ACCOUNT INFORMATION",
                "Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible");

        // Fill details: Title, Name, Email, Password, Date of birth
        signupPage.selectTitleWomen();
        signupPage.setPassword("123456");
        signupPage.setDateOfBirt("23","April","1999");

        //  Select checkbox 'Sign up for our newsletter!'
        // Select checkbox 'Receive special offers from our partners!'
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,900)");
        signupPage.selectSignupForOurNewsletter_Checkbox();
        signupPage.selectReceiveSpecialOffers_Checkbox();

        //Fill details: First name,Last name,Company,Address,Address2,Country,State,City,Zipcode,Mobile Number
        signupPage.setFirstName("Ceren");
        signupPage.setLastName("Karaca");
        signupPage.setCompany("Inar");
        signupPage.setAddress("gokcebey cukur");
        signupPage.setCountry("New Zealand");
        signupPage.setState("Sydney");
        signupPage.setCity("Zonguldak");
        signupPage.setZipcode("67670");
        signupPage.setMobileNumber("61764116450");

        // Click 'Create Account button'
        click(signupPage.createAccountButton);

        // Verify that 'ACCOUNT CREATED!' is visible
        String actualAccountCreatedMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(actualAccountCreatedMessage,"ACCOUNT CREATED!",
                "Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible");

        // Click 'Continue' button
        pages.getAccountCreatedPage().clickContinueButton();

        // block ads
        BrowserUtils.navigateBackAndForwardToDismissAds();

        // Verify that 'Logged in as username' is visible
        String actualLoggedInAsUsername = pages.getHomePage().getLoggedInAsUserName_Text();
        softAssert.assertEquals(actualLoggedInAsUsername, "Logged in as " + userName,
                "Test Case 1 - Verify that 'Logged in as username' is visible");

        // Click 'Delete Account' button
        pages.getHomePage().clickDeleteAccountButton();

        //  Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String actualAccountDeletedMessage = pages.getAccountCreatedPage().getAccountCreatedMessage();
        softAssert.assertEquals(actualAccountDeletedMessage, "ACCOUNT DELETED!",
                "Test Case 1 - Verify that 'ACCOUNT DELETED!' is visible");

        BrowserUtils.wait(3);
        pages.getAccountCreatedPage().clickContinueButton();

    }

    @Test(priority = 1)
    public void TestCase_2_RegisterUserWithExistingEmail() {
        // Verify that home page is visible successfully
        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise",
                "Test Case 2 - Verify that home page is visible successfully");

        // Click on 'Signup / Login' button
        pages.getHomePage().clickSignupLoginButton();

        String newUserSignUpMessage = pages.getLoginPage().getNewUserSignupMessage();
        // Verify 'New User Signup!' is visible
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!",
                "Test Case 2 - Verify 'New User Signup!' is visible");

        // Enter name and email address - Click 'Signup' button
        pages.getLoginPage().setSignupNewUserName("Fatih");
        pages.getLoginPage().setSignupNewUserEmail("fkara1667@gmail.com");
        pages.getLoginPage().clickSignupButtton();

        // Verify error 'Email Address already exist!' is visible
        String actualEmailAlreadyExistMessage = pages.getSignupPage().getEmailAlreadyExistMessage();
        softAssert.assertEquals(actualEmailAlreadyExistMessage, "Email Address already exist!",
                "Test Case 2 - Verify error 'Email Address already exist!' is visible");

        softAssert.assertAll();
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        driver.quit();
    }
}
