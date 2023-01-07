package Weeks.week_03.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class registerUser {
    WebDriver driver;

    @BeforeSuite
    public void setUpSuit() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        File file = new File("C:\\Users\\fkara\\Downloads\\CRX-Extractor-Downloader.crx");
        options.addExtensions(file);
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
    public void clickSignUpLoginButton() {
        driver.findElement(By.cssSelector("a[href='/login']")).click();
    }

    @Test(priority = 3)
    public void verifyNewUserSignupIsVisible() {
        List<WebElement> messages = driver.findElements(By.xpath("//div/h2"));
        boolean isVisible = messages.stream().anyMatch(m -> m.getText().equals("New User Signup!"));
        Assert.assertTrue(isVisible);
    }

    @Test(priority = 4)
    public void enterNameEmailAndClickSignUp() {
        driver.findElement(By.name("name")).sendKeys("Fatih Kara");
        driver.findElement(By.xpath("//div[3]/div/form/input[3]")).sendKeys("fkara67@gmail.com");
        driver.findElement(By.xpath("//div[3]/div/form/button")).click();
    }

    @Test(priority = 5)
    public void verifyENTERACCOUNTINFORMATIONIsVisible() {
        String message = driver.findElement(By.xpath("//div[1]/h2/b")).getText();
        Assert.assertEquals(message, "ENTER ACCOUNT INFORMATION");
    }

    @Test(priority = 6)
    public void fillDetails() {
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("123456");
        Select select = new Select(driver.findElement(By.id("days")));
        select.selectByVisibleText("18");
        Select select1 = new Select(driver.findElement(By.id("months")));
        select1.selectByVisibleText("August");
        Select select2 = new Select(driver.findElement(By.id("years")));
        select2.selectByVisibleText("1995");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)");
        driver.findElement(By.xpath("//div[1]/form/div[6]")).click();
        driver.findElement(By.xpath("//div[1]/form/div[7]")).click();
        driver.findElement(By.id("first_name")).sendKeys("Fatih");
        driver.findElement(By.id("last_name")).sendKeys("Kara");
        driver.findElement(By.id("company")).sendKeys("Inar");
        driver.findElement(By.id("address1")).sendKeys("cukur");
        Select select3 = new Select(driver.findElement(By.id("country")));
        select3.selectByVisibleText("Canada");
        driver.findElement(By.id("state")).sendKeys("Vancouver");
        driver.findElement(By.id("city")).sendKeys("tefen");
        driver.findElement(By.id("zipcode")).sendKeys("6767");
        driver.findElement(By.id("mobile_number")).sendKeys("0546");
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.cssSelector("[data-qa='create-account']")).click();
    }

    @Test(priority = 7)
    public void verifyACCOUNTCREATEDIsVisible() {
        String confirmMessage = driver.findElement(By.xpath("//b")).getText();
        Assert.assertEquals(confirmMessage, "ACCOUNT CREATED!");
    }

    @Test(priority = 8)
    public void clickContinueButton() {
        driver.findElement(By.cssSelector("[class='btn btn-primary']")).click();
    }

    @Test(priority = 9)
    public void verifyLoggedInAsUsernameIsVisible() {
        String accountText = driver.findElement(By.xpath("//div[2]/div/ul/li[10]/a")).getText();
        Assert.assertEquals(accountText, "Logged in as Fatih Kara");
    }

    @Test(priority = 10)
    public void clickDeleteAccountButton() {
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
    }

    @Test(priority = 11)
    public void  verifyACCOUNTDELETEDIsVisibleAndClickContinueButton() {
        String deleteMessage = driver.findElement(By.xpath("//b")).getText();
        Assert.assertEquals(deleteMessage, "ACCOUNT DELETED!");
        driver.findElement(By.cssSelector("[data-qa='continue-button']")).click();
    }

    @AfterSuite
    public void afterTest() {
        driver.quit();
    }
}
