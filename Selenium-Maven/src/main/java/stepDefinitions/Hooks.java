package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks extends BaseStep {
    @Before
    public void setup(Scenario scenario) {
        System.out.println(":::: Starting test automation ::::");
        System.out.println("Browser type :: " + ConfigurationReader.getProperty("browser"));
        System.out.println("Environment :: " + ConfigurationReader.getProperty("url"));
        System.out.println("Test scenario :: " + scenario.getName());
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }
}
