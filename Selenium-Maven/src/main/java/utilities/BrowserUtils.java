package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class BrowserUtils {
    static SoftAssert softAssert = new SoftAssert();

    /**
     * Verifies whether the element is displayed on page
     * fails if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isDisplayed());
        }catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + element);
        }
    }
    /**
     * Performs double click action on an element
     */
    public void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Performs click action on an element
     */
    public static void click(WebElement element) {
        new Actions(Driver.getDriver()).moveToElement(element).click();
    }

    /**
     * Performs thread sleep for the desired seconds
     */
    public static void wait(int secs) {
        try {
            Thread.sleep(1000L * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  Navigates to the target window
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Waits for visibility of an element
     * @return WebElement
     * By WebElement
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for visibility of an element
     * By Locator
     * @return WebElement
     *
     */
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for clickablity of an element
     * By element
     * @return WebElement
     */
    public static WebElement waitForClickability(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for clickablility of an element
     * By locator
     * @return WebElement
     */
    public static WebElement waitForClickability(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void navigateBackAndForwardToDismissAds(){
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
    }

    public static void assertion(WebElement actual,String expected) {
        waitForVisibility(actual,2);
        Assert.assertEquals(actual.getText(),expected);
        System.out.println("My Message: " + actual.getText());
    }

    public static void softAssertion(WebElement actual,String expected, String message) {
        waitForVisibility(actual,2);
        softAssert.assertEquals(actual.getText(),expected, message);
        System.out.println("My Message: " + actual.getText());
    }

}
