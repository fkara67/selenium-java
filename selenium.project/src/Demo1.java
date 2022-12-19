import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
    public static void main(String[] args) {
        // this line is optional since Selenium version 4.6.0
        //System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver drive = new ChromeDriver();
        drive.get("https://github.com/fkara67");
        String str = drive.getCurrentUrl();
        System.out.println("Test 1: " + (str));
        // String pageSource = drive.getPageSource();
        //System.out.println(pageSource);
    }
}

