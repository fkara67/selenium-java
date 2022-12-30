package selenium_intro.VariousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=200");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for (WebElement value : values) {
            sum += Integer.parseInt(value.getText());
        }

        int total = Integer.parseInt
                (driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

        System.out.println(total);
        System.out.println(sum);
        Assert.assertEquals(total, sum);
    }
}
