package Week_02.SaucedemoWebPage.ProductsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;


import static java.util.Collections.sort;


public class StandardUserZToAButtonTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        ArrayList<String> products = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            //get unordered products names from page
            String name = driver.findElement(By.xpath
                  ("/html/body/div/div/div/div[2]/div/div/div/div[" + i + "]/div[2]/div[1]/a")).getText();

            //assign these products in ArrayList
            products.add(name);
        }
        // sort A to Z
        sort(products);

        // sort Z to A
        for (int i = 0, j = products.size() - 1; i < j; i++, j--) {
            String temp = products.get(i);
            products.set(i, products.get(j));
            products.set(j, temp);
        }

        //select dropdown Z to A
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
        dropdown.selectByIndex(1);

        //check them, sorted or not(Z to A)
        for (int i = 1; i < products.size(); i++) {
            String actualName = driver.findElement(By.xpath
                   ("/html/body/div/div/div/div[2]/div/div/div/div[" + i + "]/div[2]/div[1]/a")).getText();
            Assert.assertEquals(actualName,products.get(i - 1));
        }
        driver.quit();
    }
}