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

        formPage.setFirstName("Jan")
                .setLastName("Kowalski")
                .setEmail("j.k@w.pl")
                .setAge(30)
                .selectRandomProfession()
                .selectRandomExperience()
                .selectGender(Gender.MALE)
                .selectContinent("europe")
                .selectSeleniumCommand("browser-commands")
                .uploadFile(file)
                .submitForm();

        Assert.assertEquals(formPage.getValidationMsg(), "Form send with success");

    }

}
