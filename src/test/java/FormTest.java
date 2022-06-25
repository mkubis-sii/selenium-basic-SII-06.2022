import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormTest extends TestBase{

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
        experience.get(3).click();

        driver.findElement(By.id("gridCheckManulTester")).click();

        // tutaj uzupelniamy pozostale pola form


        Select selectContinents = new Select(driver.findElement(By.id("selectContinents")));
        selectContinents.selectByValue("europe");

        // tutaj dodac obs selekcta 'selenium commands



        //
        driver.findElement(By.className("btn-primary")).click();

        String validationMsg = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(validationMsg, "Form send with success");
    }
}
