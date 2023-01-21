package ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SetGeoLocationTest {

    @Test
    public void setGeoLocationTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 40);
        coordinates.put("longitude",3);
        coordinates.put("accuracy", 1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
        driver.findElements(By.cssSelector(".LC20lb")).get(0).click();

        String title = driver.findElement(By.cssSelector(".our-story-card-title")).getText();
        System.out.println(title);
    }
}
