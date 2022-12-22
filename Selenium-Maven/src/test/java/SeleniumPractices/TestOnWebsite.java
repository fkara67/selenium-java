package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestOnWebsite {
    /* Login Page
    -------------------
    1- wrong userName and wrong password
    2- correct userName and wrong password
    3- wrong userName and correct password
     */
    /* 'List of All Orders' on the 'Vıew all orders' menu
    --------------------------------------------------------
    1- check one order and delete it
    2- check two orders and delete them
    3- check all and unchecked all
    4- check all delete checked ones
    5- Use order link if it exists
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        LoginTest(driver);
        ListOfAllOrdersTest(driver);


    }
    public static void LoginTest(WebDriver driver) throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/" +
                "Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        //enter wrong combinations
        String[] userAndPasswords = {"fatih,klm","Tester,t123","Tester123,test"};
        for (int i = 0; i < userAndPasswords.length; i++) {
            String userName = userAndPasswords[i].split(",")[0];
            String password = userAndPasswords[i].split(",")[1];
            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/" +
                    "Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
            driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
            driver.findElement(By.name("ctl00$MainContent$password")).sendKeys(password);
            driver.findElement(By.cssSelector("input[type='submit']")).click();
            Thread.sleep(2000);
            if (driver.getCurrentUrl().equals
                    ("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/")) {
                System.out.println("In Login Test " + (i + 1) + ". Test Case failed");
            }
        }
    }
    public static void ListOfAllOrdersTest(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // 1- check one order and delete it
        LogIn(driver);
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();

        driver.findElement(By.cssSelector("input#ctl00_MainContent_btnDelete")).click();
        if (driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl09_OrderSelector")).
                isEnabled()) {
            System.out.println("In ListOfAllOrdersTest 1.Test Case Failed");
        }
        driver.findElement(By.id("ctl00_logout")).click();

        // 2- check two orders and delete them
        LogIn(driver);
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#ctl00_MainContent_btnDelete")).click();

        if (driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl08_OrderSelector")).isEnabled()) {
            System.out.println("In ListOfAllOrdersTest 2. Test Case Failed");
        }
        driver.findElement(By.id("ctl00_logout")).click();

        // 3- check all and unchecked all
        LogIn(driver);
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        if (!driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl09_OrderSelector")).isEnabled()) {
            System.out.println("In ListOfAllOrdersTest 3. Test Case Failed");
        }
        driver.findElement(By.id("ctl00_logout")).click();

        // 4- check all delete all
        LogIn(driver);
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        if (!driver.findElement(By.id("ctl00_MainContent_orderMessage")).isEnabled()) {
            System.out.println("In ListOfAllOrdersTest 4. Test Case Failed");
        }
        // 5- Use order link if it exists
        else {
            Thread.sleep(2000);
            driver.findElement(By.id("ctl00_MainContent_orderLInk")).click();
            if (!driver.getCurrentUrl().equals
                    ("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx")) {
                System.out.println("In ListOfAllOrdersTest 5. Test Case Failed");
            }
        }
        driver.findElement(By.id("ctl00_logout")).click();


    }
    public static void LogIn(WebDriver driver) {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/" +
                "Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }
}
