package TestNG_Frameworks.org.inar.automationexercise;

import TestNG_Frameworks.utilities.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.util.List;

import static TestNG_Frameworks.utilities.BrowserUtils.*;


public class ProductsTests extends BaseTest{

    // We should use soft assertion because in this test case we have multiple cases to test
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void productsBase() {
        //  Click on 'Products' button
        click(homePage.productsButton);

        // block ads
        navigateBackAndForwardToDismissAds();
    }

    @Test
    public void TestCase_8_Verify_All_Products_and_product_detail_page() {
        // Verify user is navigated to ALL PRODUCTS page successfully
        BrowserUtils.wait(5);
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, "Automation Exercise - All Products",
        "Test Case 8 - Verify user is navigated to ALL PRODUCTS page successfully");

        // The products list is visible
        List<WebElement> productList = productsPage.getProductList();
        softAssert.assertFalse(productList.size() == 0,
        "Test Case 8 - The products list is visible");

        // Click on 'View Product' of first product
        scrollBy(0,500);
        WebElement firstProduct = productList.get(1);
        click(firstProduct.findElement(productsPage.viewProductButtons));

        // User is landed to product detail page
        String actualPage = driver.getTitle();
        softAssert.assertEquals(actualPage, "Automation Exercise - Product Details",
        "Test 8 - User is landed to product detail page");

        // Verify that detail is visible: product name, category, price, availability, condition, brand
        List<WebElement> desiredDetails = productsPage.getDesiredProductDetails();
        softAssert.assertTrue(desiredDetails.size() == 6,
        "Test Case 8 - Verify that detail is visible:product name,category,price,availability,condition,brand");


    }

    @Test
    public void TestCase_9_Search_Product() {
        String desiredProduct = "Jeans";

        // Verify user is navigated to ALL PRODUCTS page successfully
        BrowserUtils.wait(5);
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, "Automation Exercise - All Products",
        "Test Case 9 - Verify user is navigated to ALL PRODUCTS page successfully");


        // Enter product name in search input and click search button
        productsPage.searchProduct(desiredProduct);
        click(productsPage.searchButton);

        // Verify 'SEARCHED PRODUCTS' is visible
        String actualSearchedProductsTitle = productsPage.getSearchedProductTitle();
        softAssert.assertEquals(actualSearchedProductsTitle, "SEARCHED PRODUCTS",
        "Test Case 9 - Verify 'SEARCHED PRODUCTS' is visible");

        // Verify all the products related to search are visible
        List<WebElement> searchedProducts = productsPage.getSearchedProducts();
        boolean match = searchedProducts.stream().allMatch(s -> s.getText().contains(desiredProduct));
        softAssert.assertTrue(match, "Test Case 9 - Verify all the products related to search are visible");

        softAssert.assertAll();
    }

}
