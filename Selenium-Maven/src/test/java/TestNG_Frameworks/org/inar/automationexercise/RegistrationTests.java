package TestNG_Frameworks.org.inar.automationexercise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static TestNG_Frameworks.utilities.BrowserUtils.*;

public class RegistrationTests extends BaseTest   {

    // We should use soft assertion because in this test case we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TestCase_1_Register_User() {

        String userName = "Ceren";

        // Click on 'Signup / Login' button
        click(homePage.signupLoginButton);

        String newUserSignUpMessage = loginPage.getSignupTitle();
        // Verify 'New User Signup!' is visible
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!",
                "Test Case 1 - Verify 'New User Signup!' is visible");

        // Enter name and email address - Click 'Signup' button
        loginPage.setSignupNewUserName(userName);
        loginPage.setSignupNewUserEmail("ceren67@gmail.com");
        click(loginPage.signupButton);

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String actualEnterAccountInformationTitle = signupPage.getEnterAccountInformationTitle();
        softAssert.assertEquals(actualEnterAccountInformationTitle,"ENTER ACCOUNT INFORMATION",
                "Test Case 1 - Verify that 'ENTER ACCOUNT INFORMATION' is visible");

        // Fill details: Title, Name, Email, Password, Date of birth
        click(signupPage.genderMen);
        signupPage.setPassword("123456");
        signupPage.setDateOfBirt("23","April","1999");

        //  Select checkbox 'Sign up for our newsletter!'
        // Select checkbox 'Receive special offers from our partners!'
        scrollBy(0,900);

        click(signupPage.signupForOurNewsletter_Checkbox);
        click(signupPage.receiveSpecialOffers_Checkbox);


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
        String actualAccountCreatedMessage = transitionPage.getInfoMessage();
        softAssert.assertEquals(actualAccountCreatedMessage,"ACCOUNT CREATED!",
                "Test Case 1 - Verify that 'ACCOUNT CREATED!' is visible");

        // Click 'Continue' button
        click(transitionPage.continueButton);

        // block ads
        navigateBackAndForwardToDismissAds();

        // Verify that 'Logged in as username' is visible
        String actualLoggedInAsUsername = homePage.getLoggedInAsUserName_Text();
        softAssert.assertEquals(actualLoggedInAsUsername, "Logged in as " + userName,
                "Test Case 1 - Verify that 'Logged in as username' is visible");

        // Click 'Delete Account' button
        click(homePage.deleteAccountButton);

        //  Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String actualAccountDeletedMessage = transitionPage.getInfoMessage();
        softAssert.assertEquals(actualAccountDeletedMessage, "ACCOUNT DELETED!",
                "Test Case 1 - Verify that 'ACCOUNT DELETED!' is visible");

        click(transitionPage.continueButton);
    }

    @Test(priority = 1)
    public void TestCase_5_RegisterUserWithExistingEmail() {

        // Click on 'Signup / Login' button
        click(homePage.signupLoginButton);

        String newUserSignUpMessage = loginPage.getSignupTitle();
        // Verify 'New User Signup!' is visible
        softAssert.assertEquals(newUserSignUpMessage, "New User Signup!",
                "Test Case 2 - Verify 'New User Signup!' is visible");

        // Enter name and email address - Click 'Signup' button
        loginPage.setSignupNewUserName("Fatih");
        loginPage.setSignupNewUserEmail("fkara1667@gmail.com");
        click(loginPage.signupButton);

        // Verify error 'Email Address already exist!' is visible
        String actualEmailAlreadyExistMessage = signupPage.getEmailAlreadyExistMessage();
        softAssert.assertEquals(actualEmailAlreadyExistMessage, "Email Address already exist!",
                "Test Case 5 - Verify error 'Email Address already exist!' is visible");

        softAssert.assertAll();
    }

}
