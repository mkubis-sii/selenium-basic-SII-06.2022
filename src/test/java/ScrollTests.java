import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollTests extends TestBase {

    @Test
    public void shouldScrollToBtn() {
        driver.get("https://seleniumui.moderntester.pl/high-site.php");

        scrollUntilVisible(By.id("scroll-button"));
    }

    public void scrollUntilVisible(By by) {
        while (!isDisplayed(by)) {
            new Actions(driver).scrollByAmount(0, 100).perform();
            //tutaj by sie przydalo
            // sprawdzenie czy nie zjechalismy
            // do konca strony
        }

    }

    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
