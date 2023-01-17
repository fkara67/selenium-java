package TestNG_Frameworks.org.inar.automationexercise;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import static TestNG_Frameworks.utilities.BrowserUtils.*;

public class LoginTests extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void loginBase() {
        //  Click on 'Signup / Login' button
        click(homePage.signupLoginButton);

        // Verify 'Login to your account' is visible
        String actualTitle = loginPage.getLoginTitle();
        softAssert.assertEquals(actualTitle,"Login to your account",
                "Test Case 1 - Verify 'Login to your account' is visible");
    }

    @Test(priority = 1)
    public void TestCase_1_LoginWithIncorrectInput() {

        // Enter incorrect email address and password
        loginPage.setLoginEmail("abcd@gmail.com");
        loginPage.setLoginPassword("1236598");

        // Click 'login' button
        click(loginPage.loginButton);

        // Verify error 'Your email or password is incorrect!' is visible
        String actualMessage = loginPage.getLoginIncorrectMessage();
        softAssert.assertEquals(actualMessage,"Your email or password is incorrect!",
                "Test Case 1 - Verify error 'Your email or password is incorrect!' is visible");
    }

    @Test(priority = 2)
    public void TestCase_2_LoginWithCorrectInput() {

        // Enter correct email address and password
        loginPage.setLoginEmail("fkara1667@gmail.com");
        loginPage.setLoginPassword("123456");

        // Click 'login' button
        click(loginPage.loginButton);

        // Verify that 'Logged in as username' is visible
        String actualLoggedInfo = homePage.getLoggedInAsUserName_Text();
        softAssert.assertEquals(actualLoggedInfo, "Logged in as Fatih",
        "Test Case 2 - Verify that 'Logged in as username' is visible");
    }

}
