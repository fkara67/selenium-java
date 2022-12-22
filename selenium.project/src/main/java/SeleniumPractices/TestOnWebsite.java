package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class TestOnWebsite {
    /* Login Page
    -------------------
    1- wrong userName and wrong password
    2- correct userName and no password
    3- no userName and correct password
     */
    /* 'List of All Orders' on the 'Vıew all orders' menu
    --------------------------------------------------------
    1- check one order and delete it
    2- check two orders and delete them
    3- check all and unchecked all
    4- check all delete checked ones
    5- Use order link if it exists
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/" +
                "Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        String[] userAndPasswords = {"fatih,klm", "Tester, ", " ,test"};

    }
}
