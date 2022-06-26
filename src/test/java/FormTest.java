import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() throws InterruptedException {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstNameInput = driver.findElement(By.id("inputFirstName3"));
        firstNameInput.sendKeys("Jan");

        driver.findElement(By.id("inputLastName3")).sendKeys("Kowalski");
        driver.findElement(By.id("inputAge3")).sendKeys("30");
        driver.findElement(By.id("inputEmail3")).sendKeys("j.k@wp.pl");

        driver.findElements(By.name("gridRadiosSex")).get(0).click();

        List<WebElement> experience = driver.findElements(By.name("gridRadiosExperience"));
        getRandomElement(experience).click();

        driver.findElement(By.id("gridCheckManulTester")).click();


        Select selectContinents = new Select(driver.findElement(By.id("selectContinents")));
        selectContinents.selectByValue("europe");

        Select selectSeleniumCommands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        selectSeleniumCommands.selectByIndex(2);


        File file = new File("src/main/resources/file.txt");
        driver.findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.className("btn-primary")).click();

        String validationMsg = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(validationMsg, "Form send with success");
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        Random rnd = new Random();
        return elements.get(rnd.nextInt(elements.size()));
    }
}
