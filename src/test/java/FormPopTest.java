import enums.Gender;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

import java.io.File;

public class FormPopTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");
        File file = new File("src/main/resources/file.txt");

        FormPage formPage = new FormPage(driver);

        formPage.setFirstName("Jan");
        formPage.setLastName("Kowalski");
        formPage.setEmail("j.k@w.pl");
        formPage.setAge(30);
        formPage.selectRandomProfession();
        formPage.selectRandomExperience();
        formPage.selectGender(Gender.MALE);
        formPage.selectContinent("europe");
        formPage.selectSeleniumCommand("browser-commands");
        formPage.uploadFile(file);
        formPage.submitForm();

        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");

    }

}
