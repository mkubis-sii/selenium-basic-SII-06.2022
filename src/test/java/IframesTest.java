import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IframesTest extends TestBase {

    @Test
    public void shouldSwitchToIframe() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/iframes.php");


        driver.findElement(By.id("inputLogin")).click();
    }
}
