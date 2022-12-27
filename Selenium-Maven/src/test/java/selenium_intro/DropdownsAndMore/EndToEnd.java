package selenium_intro.DropdownsAndMore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EndToEnd {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();

        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        // //div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
        // //div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("Style").contains("0.5"));
        // 24 and 26 to 32 are the same
        if (driver.findElement(By.id("Div1")).getAttribute("Style").contains("0.5")) {
            System.out.println("It's disabled");
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }

        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
        //driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }
}
