package selenium_intro.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class A_06 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php/");

        // select the Options2
        driver.findElement(By.id("checkBoxOption2")).click();

        //grab the label of the selected checkBox and put it into a variable
        String label = driver.findElement(By.cssSelector("label[for='benz']")).getText();

        // select an option in dropdown using grabbed label
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select d = new Select(dropdown);
        d.selectByVisibleText(label);

        // enter grabbed label into editbox
        driver.findElement(By.id("name")).sendKeys(label);

        // click the Alert
        driver.findElement(By.id("alertbtn")).click();

        // verify if text grabbed from step2 is present in the popup message
        String popupMessage = driver.switchTo().alert().getText();
        Assert.assertTrue(popupMessage.contains(label));
    }
}
