package selenium_intro.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class A_04 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.cssSelector("a[href='/windows']")).click();

        driver.findElement(By.cssSelector("a[href='/windows/new']")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        String childMessage = driver.findElement(By.tagName("h3")).getText();
        System.out.println(childMessage);

        driver.switchTo().window(parentId);
        String parentMessage = driver.findElement(By.tagName("h3")).getText();
        System.out.println(parentMessage);

    }
}
