import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FormTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstNameInput = driver.findElement(By.id("inputFirstName3"));
        firstNameInput.sendKeys("Jan");

        driver.findElement(By.id("inputAge3")).sendKeys("30");

        List<WebElement> genders = driver.findElements(By.name("gridRadiosSex"));
        genders.get(0).click();

        // tutaj uzupelniamy pozostale pola form





        //
        driver.findElement(By.className("btn-primary")).click();

        String validationMsg = driver.findElement(By.id("validator-message")).getText();
        Assert.assertEquals(validationMsg, "Form send with success");
    }
}
