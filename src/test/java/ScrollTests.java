import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ScrollTests extends TestBase {

    @Test
    public void shouldScrollToBtn() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");

        // przy pomocy klasy action
        // zrobic scroll o X pikeli w dol, aby pokazal sie przycisk
        driver.findElement(By.id("scroll-button")).click();
    }
}
