package Weeks.week_03.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class VerifyProductQuantityInCart {
    WebDriver driver;
    String desiredQuantity = "4";

    @BeforeSuite
    public void setUpSuit() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\fkara\\Downloads\\CRX-Extractor-Downloader.crx"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void setUpTest() {
        driver.get("https://automationexercise.com/");
    }

    @Test(priority = 1)
    public void isHomePageVisisble() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
    }

    @Test(priority = 2)
    public void verifyProductDetailIsOpened() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Automation Exercise - Product Details");
    }

    @Test(priority = 3)
    public void verifyThatProductIsDisplayedInCartPageWithExactQuantity() {
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.id("product_id"))).doubleClick();
        a.moveToElement(driver.findElement(By.id("product_id"))).doubleClick();
        driver.findElement(By.id("quantity")).sendKeys("4");
        driver.findElement(By.cssSelector("[type='button']")).click();
        driver.findElement(By.xpath("//p[2]/a")).click();
        String quantity = driver.findElement(By.cssSelector("[class='disabled']")).getText();
        Assert.assertEquals(quantity, desiredQuantity);
    }
}
