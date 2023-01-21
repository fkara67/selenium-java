package ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CdpCommandsTest {

    @Test
    public void cdpCommandTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width",600);
        deviceMetrics.put("height", 1000);
        deviceMetrics.put("deviceScaleFactor", 50);
        deviceMetrics.put("mobile", true);

        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Library")).click();

    }
}
