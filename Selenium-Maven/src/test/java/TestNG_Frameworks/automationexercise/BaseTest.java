package TestNG_Frameworks.automationexercise;

import TestNG_Frameworks.pages.*;
import TestNG_Frameworks.utilities.ConfigurationReader;
import TestNG_Frameworks.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static TestNG_Frameworks.utilities.BrowserUtils.*;

public class BaseTest {

    WebDriver driver = Driver.getDriver();

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    TransitionPage transitionPage = new TransitionPage();
    ProductsPage productsPage = new ProductsPage();

    String URL = ConfigurationReader.getProperty("url");
    String browser = ConfigurationReader.getProperty("browser");
    String environment = ConfigurationReader.getProperty("environment");

    @BeforeSuite
    public void setUpSuit() {
        // code that is executed before the entire test suite

        //Launch browser and Navigate to url 'http://automationexercise.com'
        System.out.println("   :::::::::: Test Information ::::::::::\n\tURL :" + URL + "\n\tBrowser :"
                + browser + "\n\tEnvironment :" + environment);
        System.out.println("   ::::::::::::::::::::::::::::::::::::::");

        implicitlyWait(5);
    }

    @BeforeMethod
    public void beforeTestCases() {
        driver.get(URL);
    }

    @AfterSuite
    public void afterSuit() {
        // Perform cleanup tasks or generate test reports here
        driver.quit();
    }
}
