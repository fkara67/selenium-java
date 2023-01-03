package selenium_intro.Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement nameEditBox = driver.findElement(By.name("name"));
        String textAboveNameEditBox = driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText();
        System.out.println(textAboveNameEditBox);

        WebElement dateOfBirthText = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirthText)).click();

        WebElement iceCreamText = driver.findElement(By.xpath("//div[4]/label"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamText)).click();

        WebElement employmentStatusText = driver.findElement(By.cssSelector("label[for='exampleFormControlRadio1']"));
        driver.findElement(with(By.tagName("input")).toRightOf(employmentStatusText)).click();
    }
}
