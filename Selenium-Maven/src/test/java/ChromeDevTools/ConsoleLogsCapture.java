package ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import java.util.List;

public class ConsoleLogsCapture {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();

        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");

        // get LogEntries Objects
        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);

        // LogEntriesObjects - getAll() method returns all logs in list
        List<LogEntry> logs =  entries.getAll();

        // iterating through list and printing each log message
        for (LogEntry e: logs) {
            System.out.println(e.getMessage());
        }
    }
}
