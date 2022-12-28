package selenium_intro.VariousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        Actions a = new Actions(driver);

        WebElement move = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span/span"));
        a.moveToElement(move).build().perform();
        a.moveToElement(move).contextClick().perform();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("Hello").perform();
        a.moveToElement(searchBox).doubleClick().perform();
    }
}
