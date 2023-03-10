package TestNG_Frameworks.automationexercise;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static TestNG_Frameworks.utilities.BrowserUtils.*;

public class LoginTests extends BaseTest {

    @BeforeMethod()
    public void loginBase() {
        //  Click on 'Signup / Login' button
        click(homePage.signupLoginButton);
    }

    @Test(priority = 1)
    public void TestCase_2_LoginWithCorrectInput() {
        SoftAssert softAssert = new SoftAssert();

        // Verify 'Login to your account' is visible
        String actualTitle = loginPage.getLoginTitle();
        softAssert.assertEquals(actualTitle,"Login to your account",
                "Test Case 2 - Verify 'Login to your account' is visible");

        // Enter correct email address and password
        loginPage.setLoginEmail("fkara1667@gmail.com");
        loginPage.setLoginPassword("123456");

        // Click 'login' button
        click(loginPage.loginButton);

        // Verify that 'Logged in as username' is visible
        String actualLoggedInfo = homePage.getLoggedInAsUserName_Text();
        softAssert.assertEquals(actualLoggedInfo, "Logged in as Fatih",
                "Test Case 2 - Verify that 'Logged in as username' is visible");

        click(homePage.logoutButton);
        softAssert.assertAll();

    }


    @Test(priority = 2)
    public void TestCase_3_LoginWithIncorrectInput() {

        // Enter incorrect email address and password
        loginPage.setLoginEmail("abcd@gmail.com");
        loginPage.setLoginPassword("1236598");

        // Click 'login' button
        click(loginPage.loginButton);

        // Verify error 'Your email or password is incorrect!' is visible
        String actualMessage = loginPage.getLoginIncorrectMessage();
        Assert.assertEquals(actualMessage,"Your email or password is incorrect!",
       "Test Case 3 - Verify error 'Your email or password is incorrect!' is visible");

    }

    @Test(priority = 3)
    public void TestCase_4_LogoutUser() {
        SoftAssert softAssert = new SoftAssert();

        // Enter correct email address and password
        loginPage.setLoginEmail("fkara1667@gmail.com");
        loginPage.setLoginPassword("123456");

        // Click 'login' button
        click(loginPage.loginButton);

        // Verify that 'Logged in as username' is visible
        String actualLoggedInfo = homePage.getLoggedInAsUserName_Text();
        softAssert.assertEquals(actualLoggedInfo, "Logged in as Fatih",
        "Test Case 4 - Verify that 'Logged in as username' is visible");

        // Click 'Logout' button
        click(homePage.logoutButton);

        // Verify that user is navigated to login page
        String actualCurrentUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualCurrentUrl,"https://automationexercise.com/login",
        "Test Case 4 - Verify that user is navigated to login page");

        softAssert.assertAll();
    }
}
