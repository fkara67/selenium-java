package TestNG_Frameworks.org.inar.automationexercise;

import TestNG_Frameworks.utilities.BrowserUtils;
import TestNG_Frameworks.utilities.ConfigurationReader;
import TestNG_Frameworks.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class PurchaseTests extends BaseTest{

    // We should use soft assertion because in this test case we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    @BeforeSuite
    public void setUpSuit() {
        // code that is executed before the entire test suite
        String URL = ConfigurationReader.getProperty("url");
        String browser = ConfigurationReader.getProperty("browser");
        String environment = ConfigurationReader.getProperty("environment");
        //Launch browser and Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(URL);
        System.out.println("   :::::::::: Test Information ::::::::::\n\tURL :" + URL + "\n\tBrowser :"
                + browser + "\n\tEnvironment :" + environment);
        System.out.println("   ::::::::::::::::::::::::::::::::::::::");
        BrowserUtils.wait(1);
    }

    @Test
    public void TestCase_1_Search_Product() {
        String desiredProduct = "Jeans";
        // Verify that home page is visible successfully
        softAssert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise",
                "Test Case 1 - Verify that home page is visible successfully");

        //  Click on 'Products' button
        pages.getHomePage().clickProductsButton();

        // block ads
        BrowserUtils.navigateBackAndForwardToDismissAds();

        // Verify user is navigated to ALL PRODUCTS page successfully
        BrowserUtils.wait(5);
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle, "Automation Exercise - All Products",
                "Test Case 1 - Verify user is navigated to ALL PRODUCTS page successfully");


        // Enter product name in search input and click search button
        pages.getProductsPage().searchProduct(desiredProduct);
        pages.getProductsPage().clickSearchButton();

        // Verify 'SEARCHED PRODUCTS' is visible
        String actualSearchedProductsTitle = pages.getProductsPage().getSearchedProductTitle();
        softAssert.assertEquals(actualSearchedProductsTitle, "SEARCHED PRODUCTS",
                "Test Case 1 - Verify 'SEARCHED PRODUCTS' is visible");

        // Verify all the products related to search are visible
        List<WebElement> searchedProducts = pages.getProductsPage().getSearchedProducts();
        boolean match = searchedProducts.stream().allMatch(s -> s.getText().contains(desiredProduct));
        softAssert.assertTrue(match, "Test Case 1 - Verify all the products related to search are visible");

        softAssert.assertAll();

    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        Driver.getDriver().quit();
    }
}
