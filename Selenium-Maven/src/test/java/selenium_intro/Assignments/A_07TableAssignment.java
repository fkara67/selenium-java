package selenium_intro.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class A_07TableAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // number of rows
        List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
        int numberOfRows = rows.size();
        System.out.println(numberOfRows);

        // number of columns
        int numberOfCols = driver.findElements(By.cssSelector(".table-display th")).size();
        System.out.println(numberOfCols);

        // display second index text in rows
        System.out.println(rows.get(2).getText());
    }
}
