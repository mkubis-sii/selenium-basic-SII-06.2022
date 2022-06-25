import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    }


    @Test
    public void shouldDismissAlert() {
    }
}
