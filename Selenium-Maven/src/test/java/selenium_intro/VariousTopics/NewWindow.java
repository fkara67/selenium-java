package selenium_intro.VariousTopics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class NewWindow {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // driver.switchTo().newWindow(WindowType.TAB);
        // switching window
        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");
        //String courseName = driver.findElement(By.xpath("//div[1]/div/div[2]/div[1]/h2/a")).getText();
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).
                get(1).getText();

        driver.switchTo().window(parentWindowId);
        WebElement name = driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(courseName);

        // Screenshot
        File file = name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));

        // Get Height & Width
        System.out.println("Height of name box: " + name.getRect().getDimension().getHeight());
        System.out.println("Width of name box: " + name.getRect().getDimension().getWidth());

        driver.quit();
    }
}
