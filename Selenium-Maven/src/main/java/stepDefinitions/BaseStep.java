package stepDefinitions;

import org.openqa.selenium.WebDriver;
import utilities.Driver;
import utilities.Pages;

public class BaseStep {
    protected Pages pages = new Pages();
    WebDriver driver = Driver.getDriver();
}
