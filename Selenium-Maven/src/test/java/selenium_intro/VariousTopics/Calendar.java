package selenium_intro.VariousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Calendar {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.path2usa.com/travel-companion/");
        JavascriptExecutor js = driver;
        js.executeScript("window.scrollBy(0,900)");

        Thread.sleep(2000);

        driver.findElement(By.id("form-field-travel_comp_date")).click();

        while (!driver.findElement(By.cssSelector("span[class='cur-month']")).getText().contains("April")) {
            driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click();
        }

        //driver.findElement(By.xpath("//span[20]")).click();
        Thread.sleep(2000);
        List<WebElement> days = driver.findElements(By.cssSelector("span[class='flatpickr-day ']"));

        for (WebElement day : days) {
            String text = day.getText();
            if (text.equals("19")) {
                day.click();
                break;
            }
        }
    }
}
