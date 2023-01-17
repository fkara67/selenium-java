package TestNG_Frameworks.org.inar.automationexercise;

import TestNG_Frameworks.pages.*;
import TestNG_Frameworks.utilities.ConfigurationReader;
import TestNG_Frameworks.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import static TestNG_Frameworks.utilities.BrowserUtils.implicitlyWait;

public class BaseTest {
    SoftAssert softAssert = new SoftAssert();
    WebDriver driver = Driver.getDriver();

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    TransitionPage transitionPage = new TransitionPage();
    ProductsPage productsPage = new ProductsPage();

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
        implicitlyWait(5);
    }
    @BeforeTest
    public void commonTest() {
        // Verify that home page is visible successfully
        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise",
                "Test Case 1 - Verify that home page is visible successfully");
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        driver.quit();
    }
}
