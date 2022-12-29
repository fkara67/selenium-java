package selenium_intro.VariousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Calendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        System.setProperty("webdriver.edge.driver","C:\\Users\\fkara\\Downloads\\edgedriver\\msedgedriver.exe");
        WebDriver driver2 = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver2.get("https://www.path2usa.com/travel-companion/");

        // August 18
        driver2.findElement(By.xpath(".//*[@id='form-field-travel_comp_date']")).click();

        while (!driver.findElement(By.cssSelector("span[title='Scroll to increment']")).getText().contains("August")) {
            driver.findElement(By.cssSelector("[class='flatpickr-next-month']")).click();
        }
    }
}
