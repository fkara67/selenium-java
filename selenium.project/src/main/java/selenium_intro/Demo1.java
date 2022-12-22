package selenium_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo1 {
    public static void main(String[] args) {
        // this line is optional since Selenium version 4.6.0
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver drive = new ChromeDriver();
        drive.get("https://github.com/fkara67");
        String str = drive.getCurrentUrl();
        System.out.println("Test 1: " + (str));
        String pageSource = drive.getPageSource();
        System.out.println(pageSource);

        //Edge
        System.setProperty("webdriver.edge.driver","C:\\Users\\fkara\\Downloads\\edgedriver\\msedgedriver.exe");
        WebDriver driver2 = new EdgeDriver();

        //Firefox
        System.setProperty("webdriver.gecko.driver","C:\\Users\\fkara\\Downloads\\geckodriver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();


    }
}

