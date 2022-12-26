package Week_02.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class WrongLoginCombinations {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        String[][] loginCombinations = {{"standard","secret_sauce"},{"frkn","ali"},{"locked_out_user","secret_sauce"}};

        for (String[] loginCombination : loginCombinations) {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys(loginCombination[0]);
            driver.findElement(By.id("password")).sendKeys(loginCombination[1]);
            driver.findElement(By.id("login-button")).click();
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        }
        driver.quit();
    }
}
