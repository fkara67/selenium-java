package selenium_intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Parent -> Child to child traverse
        //header/div/button[1]/following-sibling::button[1]
        System.out.println(driver.findElement(By.xpath
                ("//header/div/button[1]/following-sibling::button[1]")).getText());

        // Parent -> Child to parent traverse
        //header/div/button[1]/parent::div/button[2]
        System.out.println(driver.findElement(By.xpath
                ("//header/div/button[1]/parent::div/button[2]")).getText());

    }
}
