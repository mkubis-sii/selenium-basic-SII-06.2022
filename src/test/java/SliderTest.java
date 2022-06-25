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

        moveSliderTo(50);


        Assert.assertEquals(handle.getText(), "51");
    }


    public void moveSliderTo(int expectedValue) {
        for (int i = 0; i < expectedValue; i++) {
            driver.findElement(By.id("custom-handle")).sendKeys(Keys.ARROW_RIGHT);
        }
    }

}
