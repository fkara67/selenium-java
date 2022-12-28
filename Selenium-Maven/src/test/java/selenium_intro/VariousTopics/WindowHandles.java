package selenium_intro.VariousTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");

        driver.findElement(By.cssSelector(".blinkingText")).click();

        // [parentId, childId]
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".im-para.red")));

        // emailId1 and emailId2 are the same.
        String emailId1 = driver.findElement(By.cssSelector(".im-para.red")).
                getText().split("at ")[1].split(" ")[0];
        String emailId2 = driver.findElement(By.xpath("//strong/a")).getText();
        System.out.println(emailId1);
        System.out.println(emailId2);

        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(emailId2);

    }
}
