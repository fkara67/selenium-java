package SeleniumPractices;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    /*  Product, Address and Payment on the 'Orders' menu
    --------------------------------------------------------
    1- test whether enter or not order menu
    2- test whether it save the correct entries
    3- test whether the reset button work
    4- test whether calculation is correct
    5- test whether zip part accept non-numeric
    6- if the required fields don't fill in the form, what will happen?
    7- enter Quantity part as zero
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginTest(driver);
        listOfAllOrdersTest(driver);
        ordersMenuTest(driver);


    }
    public static void loginTest(WebDriver driver) throws InterruptedException {

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
    public static void listOfAllOrdersTest(WebDriver driver) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        // 1- check one order and delete it
        logIn(driver);
        String text1 = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_" +
                "orderGrid\"]/tbody/tr[2]")).getText();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
        driver.findElement(By.cssSelector("input#ctl00_MainContent_btnDelete")).click();
        String text2 = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_" +
                "orderGrid\"]/tbody/tr[2]")).getText();
        if (text1.equals(text2)) {
            System.out.println("In ListOfAllOrdersTest 1.Test Case Failed");
        }
        driver.findElement(By.id("ctl00_logout")).click();

        // 2- check two orders and delete them
        logIn(driver);
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl03_OrderSelector")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#ctl00_MainContent_btnDelete")).click();

        try {
            driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl08_OrderSelector")).isEnabled();
            System.out.println("In ListOfAllOrdersTest 2.Test Case Failed");
        } catch (NoSuchElementException e) {
            System.out.println("No problem");
        }
        driver.findElement(By.id("ctl00_logout")).click();

        // 3- check all and unchecked all
        logIn(driver);
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        for (int i = 2; i <= 8; i++) {
            if (!driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector")).isSelected()) {
                System.out.println("Check all test case failed!");
            }
        }
        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        for (int i = 2; i <= 8; i++) {
            if (driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector")).isSelected()) {
                System.out.println("Uncheck all test case failed!");
            }
        }
        driver.findElement(By.id("ctl00_logout")).click();

        // 4- check all delete all
        logIn(driver);
        deleteAllOrders(driver);
        if (!driver.findElement(By.id("ctl00_MainContent_orderMessage")).isEnabled()) {
            System.out.println("In ListOfAllOrdersTest 4. Test Case Failed");
        }
        driver.findElement(By.id("ctl00_logout")).click();

        // 5- Use order link if it exists
        logIn(driver);
        deleteAllOrders(driver);
        driver.findElement(By.id("ctl00_MainContent_orderLInk")).click();
        if (!driver.getCurrentUrl().equals
                ("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx")) {
            System.out.println("In ListOfAllOrdersTest 5. Test Case Failed");
        }
        driver.findElement(By.id("ctl00_logout")).click();
    }

    public static void ordersMenuTest(WebDriver driver) {
        // 1- test whether enter or not order menu
        enterOrdersMenu(driver);
        if (!driver.getCurrentUrl().equals
                ("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx")) {
            System.out.println("In Orders Menu Test 1.Test Case Failed!");
        }
        driver.findElement(By.id("ctl00_logout")).click();

       // 2- test whether it save the correct entries
        enterOrdersMenu(driver);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("10");
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("Ali Guru");
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']")).
                sendKeys("Cukur");
        driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Tefen");
        driver.findElement(By.cssSelector("input[name='ctl00$MainContent$fmwOrder$TextBox4']")).
                sendKeys("Zonguldak");
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("67670");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys("13572468");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("11/27");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        String entries = "Ali Guru MyMoney 10 12/24/2022 Cukur Tefen Zonguldak 67670 Visa 13572468 11/27";
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[1]/a")).click();
        if (!entries.equals(driver.findElement
                (By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]")).getText())) {
            System.out.println("In Orders Menu Test 2.Test Case Failed!");
        }
    }
    public static void logIn(WebDriver driver) {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/" +
                "Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }
    public static void deleteAllOrders(WebDriver driver) {
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
    }
    public static void enterOrdersMenu(WebDriver driver) {
        logIn(driver);
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
    }
}
