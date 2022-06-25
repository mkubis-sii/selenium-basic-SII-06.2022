import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void shouldAcceptAlert() {


        driver.findElement(By.id("simple-alert")).click();

        driver.switchTo().alert().accept();

        String alertMsg = driver.findElement(By.id("simple-alert-label")).getText();
        Assert.assertEquals(alertMsg, "OK button pressed");
    }


    @Test
    public void shouldFillPromptAlert() {
        driver.findElement(By.id("prompt-alert")).click();

        driver.switchTo().alert().sendKeys("Lord Vader");
        driver.switchTo().alert().accept();

        String alertMsg = driver.findElement(By.id("prompt-label")).getText();
        Assert.assertEquals(alertMsg, "Hello Lord Vader! How are you today?");
    }


    @Test
    public void shouldDismissAlert() {
        driver.findElement(By.id("confirm-alert")).click();

        driver.switchTo().alert().dismiss();

        String alertMsg = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(alertMsg, "You pressed Cancel!");
    }

    @Test
    public void shouldWaitForDelayedAlert() {
        driver.findElement(By.id("delayed-alert")).click();

        // w tym miejscu zaimplementuj czekanie az sie pojawi alert

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();

        String alertMsg = driver.findElement(By.id("delayed-alert-label")).getText();

        Assert.assertEquals(alertMsg, "OK button pressed");
    }
}
