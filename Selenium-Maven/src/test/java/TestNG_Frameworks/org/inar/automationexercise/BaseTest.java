package TestNG_Frameworks.org.inar.automationexercise;

import TestNG_Frameworks.utilities.Driver;
import TestNG_Frameworks.utilities.Pages;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected Pages pages = new Pages();
    WebDriver driver = Driver.getDriver();
}
