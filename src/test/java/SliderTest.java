import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {

    @Test
    public void shouldMoveSlider() {
        driver.get("https://seleniumui.moderntester.pl/slider.php");

        WebElement handle = driver.findElement(By.id("custom-handle"));

        handle.sendKeys(Keys.ARROW_RIGHT);

        Assert.assertEquals(handle.getText(), "1");
    }

}
