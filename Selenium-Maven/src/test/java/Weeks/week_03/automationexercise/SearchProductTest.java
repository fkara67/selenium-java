package Weeks.week_03.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchProductTest {
    WebDriver driver;

    @BeforeSuite
    public void setUpSuit() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void setUpTest() {
        driver.get("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void verifyHomePageVisible() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
    }

    @Test(priority = 2)
    public void verifyNavigatedToALLPRODUCTSPageSuccessfully() throws InterruptedException {
        driver.findElement(By.cssSelector("a[href='/products']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Automation Exercise - All Products");
    }

    @Test(priority = 3)
    public void verifySEARCHEDPRODUCTSisVisible() {
        driver.findElement(By.id("search_product")).sendKeys("jeans");
        driver.findElement(By.id("submit_search")).click();
        String searchedProductsTitle = driver.findElement(By.cssSelector("h2[class*='title']")).getText();
        Assert.assertEquals(searchedProductsTitle,"SEARCHED PRODUCTS");
    }

    @Test(priority = 3)
    public void verifyAllTheProductsRelatedToSearchAreVisible() {
        List<WebElement> searchedResults = driver.findElements(By.xpath("//div[2]/div/p"));
        boolean allMatched = searchedResults.stream().allMatch(s -> s.getText().contains("Jeans"));
        Assert.assertTrue(allMatched);
    }
}
