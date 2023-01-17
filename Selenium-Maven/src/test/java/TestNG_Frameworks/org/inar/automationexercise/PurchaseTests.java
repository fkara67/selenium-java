package TestNG_Frameworks.org.inar.automationexercise;

import TestNG_Frameworks.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.List;

import static TestNG_Frameworks.utilities.BrowserUtils.*;


public class PurchaseTests extends BaseTest{

    // We should use soft assertion because in this test case we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void TestCase_1_Search_Product() {
        String desiredProduct = "Jeans";

        //  Click on 'Products' button
        click(homePage.productsButton);

        // block ads
        navigateBackAndForwardToDismissAds();

        // Verify user is navigated to ALL PRODUCTS page successfully
        BrowserUtils.wait(5);
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, "Automation Exercise - All Products",
                "Test Case 1 - Verify user is navigated to ALL PRODUCTS page successfully");


        // Enter product name in search input and click search button
        productsPage.searchProduct(desiredProduct);
        click(productsPage.searchButton);

        // Verify 'SEARCHED PRODUCTS' is visible
        String actualSearchedProductsTitle = productsPage.getSearchedProductTitle();
        softAssert.assertEquals(actualSearchedProductsTitle, "SEARCHED PRODUCTS",
                "Test Case 1 - Verify 'SEARCHED PRODUCTS' is visible");

        // Verify all the products related to search are visible
        List<WebElement> searchedProducts = productsPage.getSearchedProducts();
        boolean match = searchedProducts.stream().allMatch(s -> s.getText().contains(desiredProduct));
        softAssert.assertTrue(match, "Test Case 1 - Verify all the products related to search are visible");

        softAssert.assertAll();
    }

}
