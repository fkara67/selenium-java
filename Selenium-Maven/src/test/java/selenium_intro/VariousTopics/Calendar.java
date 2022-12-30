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

        Thread.sleep(3000);

        // August 18
        driver.findElement(By.id("form-field-travel_comp_date")).click();

        while (!driver.findElement(By.cssSelector("span[title='Scroll to increment']")).getText().contains("July")) {
            driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click();
        }

        driver.findElement(By.xpath("//div[10]/div[2]/div/div[2]/div/span[20]")).click();

        List<WebElement> days = driver.findElements(By.className("flatpickr-day."));
        /*
        for (WebElement day : days) {
            String text = day.getText();
            if (text.equals("18")) {
                day.click();
                break;
            }
        }

         */
    }
}
