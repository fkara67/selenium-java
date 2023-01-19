package Weeks.week_03.automationexercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class registerUserWithExistingEmail {
    WebDriver driver;

    @BeforeClass
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
    public void verifyHomePageVisisble() {
        Assert.assertEquals(driver.getTitle(), "Automation Exercise");
    }


    @Test(priority = 2)
    public void verifyNewUserSignupIsVisible() {
        driver.findElement(By.cssSelector("a[href='/login']")).click();
        List<WebElement> messages = driver.findElements(By.xpath("//div/h2"));
        boolean isVisible = messages.stream().anyMatch(m -> m.getText().equals("New User Signup!"));
        Assert.assertTrue(isVisible);
    }

    @Test(priority = 3)
    public void verifyErrorEmailAddressAlreadyExistIsVisible() {
        driver.findElement(By.name("name")).sendKeys("Fatih Kara");
        driver.findElement(By.xpath("//div[3]/div/form/input[3]")).sendKeys("fkara1667@gmail.com");
        driver.findElement(By.xpath("//div[3]/div/form/button")).click();
        String existingEmailMessage = driver.findElement(By.xpath("//div[3]/div/form/p")).getText();
        Assert.assertEquals(existingEmailMessage, "Email Address already exist!");
    }

    @AfterSuite
    public void afterTest() {
        driver.quit();
    }
}
