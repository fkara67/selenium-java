package TestNGIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo {
    WebDriver driver;

    @BeforeSuite
    public void setUpSuit() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @BeforeTest
    public void setUpTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void sortAToZButtonTest() {
        //select dropdown A to Z
        Select dropdown = new Select(driver.findElement(By.xpath("//select")));
        dropdown.selectByIndex(0);

        //capture all webelements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//div/div/a/div"));

        // capture texts of all webelements into new list(original)
        List<String> originalList = elementList.stream().map(e -> e.getText()).collect(Collectors.toList());

        // sort on the original list --> sortedList
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // compare original and sorted list
        Assert.assertEquals(originalList, sortedList);
    }

    @Test
    public void GetProductPrice() {
        List<WebElement> elementList = driver.findElements(By.xpath("//div/div/a/div"));
        List<String> price = elementList.stream().filter(s -> s.getText().contains("Sauce Labs Onesie")).
                map(s -> getPriceProduct(s)).collect(Collectors.toList());
        price.forEach(a -> System.out.println(a));
    }

    private String getPriceProduct(WebElement s) {
        //  //div/div/a/div
        //  //div/div/a/div/parent::a/parent::div/parent::div/div[2]/div/text()[2]
        String priceValue = s.findElement(By.xpath
                ("parent::a/parent::div/parent::div/div[2]/div")).getText().split("$")[0];
        return priceValue;
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        driver.quit();
    }
}
