package Week_02.ProductsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;

import static java.util.Collections.sort;

public class LowToHighButtonTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        ArrayList<Double> prices = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            //get unordered prices form page
            String price = driver.findElement(By.xpath
                    ("//*[@id=\"inventory_container\"]/div/div["+ i +"]/div[2]/div[2]/div")).getText();
            //trim $ sign from string
            String priceNum = price.substring(1);
            //assign these prices in ArrayList
            prices.add(Double.parseDouble(priceNum));
        }

        //sort list
        sort(prices);

        //select dropdown low to high price
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
        dropdown.selectByIndex(2);

        //check them, sorted or not
        for (int i = 1; i <= 6; i++) {
            //get sorted prices from page
            String actualPrice = driver.findElement(By.xpath
                    ("//*[@id=\"inventory_container\"]/div/div["+ i +"]/div[2]/div[2]/div")).getText();
            Assert.assertEquals(actualPrice, "$" + prices.get(i - 1));
        }
        driver.quit();
    }
}
