package ChromeDevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.ConnectionType;
import org.testng.annotations.Test;

import java.util.Optional;

public class NetworkSpeed {
    @Test
    public void networkSpeedTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),
                Optional.empty()));

        devTools.send(Network.emulateNetworkConditions(false,3000,20000,
                100000, Optional.of(ConnectionType.ETHERNET)));

        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
            System.out.println(loadingFailed.getErrorText());
            System.out.println(loadingFailed.getTimestamp());
        });

        long start = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();

        long end = System.currentTimeMillis();

        System.out.println(end - start);

        driver.close();
    }
}
