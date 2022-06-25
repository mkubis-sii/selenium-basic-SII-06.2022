import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoadingBarTests extends TestBase {
    WebDriverWait wait;

    @BeforeMethod
    public void testSetup() {
        driver.get("https://seleniumui.moderntester.pl/progressbar.php");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void shouldWaitForLoadingBar() {
        // ponizsza implementacja waita powinna sie znalezc w TestBase
        // ale wrzucamy ja tutaj aby nie ingerowała w pozostałe testy dziedzicznące po testbase
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.className("ui-progressbar-complete"));
    }

    @Test
    public void shouldWaitForLoadingBarText() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("progress-label"), "Complete!"));
    }

    @Test
    public void shouldWaitForLoadingBarText2() {
        WebElement progressBarLbl = driver.findElement(By.className("progress-label"));
        wait.until(ExpectedConditions.textToBePresentInElement(progressBarLbl, "Complete!"));
    }

    @Test
    public void shouldWaitForLoadingBarAttribute() {
        wait.until(ExpectedConditions.attributeContains(By.className("ui-progressbar-value"),
                "class", "ui-progressbar-complete"));
    }

    @Test
    public void shouldWaitForLoadingBarAttribute2() {
        WebElement progressBar = driver.findElement(By.className("ui-progressbar-value"));
        wait.until(ExpectedConditions.attributeContains(progressBar,
                "class", "ui-progressbar-complete"));
    }
}
