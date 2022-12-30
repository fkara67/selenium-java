package selenium_intro.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class A_08AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String wantedCountry = "Turkey";
        driver.findElement(By.id("autocomplete")).sendKeys("tu");

        Thread.sleep(3000);

        WebElement optionTable = driver.findElement(By.id("ui-id-1"));
        List<WebElement> options = optionTable.findElements(By.cssSelector("li[class='ui-menu-item']"));

        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(wantedCountry)) {
                Actions act = new Actions(driver);
                act.moveToElement(option).click().build().perform();
            }
        }
    }
}
