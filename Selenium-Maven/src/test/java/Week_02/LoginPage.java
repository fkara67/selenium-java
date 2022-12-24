package Week_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get("https://www.saucedemo.com/");
        String[][] loginCombinations = {{"standard_user", "secret_sauce"}, {"fatih","kara"}};

        for (int i = 0; i < 2; i++) {
            driver.get("https://www.saucedemo.com/");
        }
    }
}
