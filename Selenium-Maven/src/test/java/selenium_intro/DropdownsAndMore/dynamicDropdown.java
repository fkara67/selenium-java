package selenium_intro.DropdownsAndMore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dynamicDropdown {
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
        driver.quit();
    }
}
