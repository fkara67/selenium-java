package selenium_intro.VariousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scopes {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php/");

        // 1- give me the count of links on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        // 2- count of links on footer section
           //  Limiting webdriver scope
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        // 3- count of links on first column on footer section
            // Limiting footerdriver scope
        WebElement firstColDriver = footerDriver.findElement(By.xpath("//td[1]/ul"));
        System.out.println(firstColDriver.findElements(By.tagName("a")).size());

        List<WebElement> firstColLinks = firstColDriver.findElements(By.tagName("a"));

        for (int i = 1; i < firstColLinks.size(); i++) {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColLinks.get(i).sendKeys(clickOnLinkTab);
        }

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (it.hasNext()) {
            System.out.println(driver.switchTo().window(it.next()).getTitle());
        }

        // this is the same with while above
        /*

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            System.out.println(driver.switchTo().window(window).getTitle());
        }

         */
    }
}
