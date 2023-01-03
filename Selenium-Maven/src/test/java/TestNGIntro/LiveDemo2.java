package TestNGIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LiveDemo2 {
    WebDriver driver;

    @BeforeSuite
    public void setUpSuit() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @BeforeTest
    public void setUpTest() {
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    }

    @Test
    public void sortProductsWithNameTest() {
        // click weg/fruit name button to sort
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all webelements into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

        // capture texts of all webelements into new list(original)
        List<String> originalList = elementList.stream().map(WebElement::getText).collect(Collectors.toList());

        // sort on the original list --> sortedList
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        // compare original and sorted list
        Assert.assertEquals(originalList, sortedList);
    }

    @Test
    public void getProductPrice() {
        // // scan the name column with getText ->Rice->print the price of the Rice

        List<String> price = new ArrayList<>();

        while (price.size() == 0) {
            //capture all webelements into list
            List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

            // capture price of 'Rice' among these webelements
            price = elementList.stream().filter(s -> s.getText().contains("Rice")).
                    map(s -> getPrice(s)).collect(Collectors.toList());

            // print price
            price.forEach(System.out::println);
            if (price.size() == 0) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }
    }

    private String getPrice(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

    @Test
    public void filterBoxTest() {
        driver.findElement(By.id("search-field")).sendKeys("Rice");
        List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
        List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());
        Assert.assertEquals(veggies.size(), filteredList.size());
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        driver.quit();
    }
}
