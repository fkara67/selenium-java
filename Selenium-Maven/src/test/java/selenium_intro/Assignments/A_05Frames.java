package selenium_intro.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A_05Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();

        // go to frame perspective
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[1]")));

        //go to nested frame
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[2]")));

        String message = driver.findElement(By.id("content")).getText();
        System.out.println(message);
    }
}
