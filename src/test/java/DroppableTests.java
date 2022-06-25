import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DroppableTests extends TestBase {

    @Test
    public void shouldDragAndDrop() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement toDrag = driver.findElement(By.id("draggable"));
        WebElement toDrop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(toDrag)
                .moveToElement(toDrop)
                .release()
                .perform();

        Assert.assertEquals(toDrop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDrop2() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement toDrag = driver.findElement(By.id("draggable"));
        WebElement toDrop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(toDrag)
                .release(toDrop)
                .perform();

        Assert.assertEquals(toDrop.getText(), "Dropped!");
    }

    @Test
    public void shouldDragAndDrop3() {
        driver.get("https://seleniumui.moderntester.pl/droppable.php");
        WebElement toDrag = driver.findElement(By.id("draggable"));
        WebElement toDrop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(toDrag, toDrop)
                .perform();

        Assert.assertEquals(toDrop.getText(), "Dropped!");
    }
}
