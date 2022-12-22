package selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.navigate().to("http://www.rahulshettyacademy.com");
        driver.navigate().back();
        driver.navigate().forward();
    }
}
