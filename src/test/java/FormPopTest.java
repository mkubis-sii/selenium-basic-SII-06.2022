import enums.Gender;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormPopTest extends TestBase {

    @Test
    public void shouldFillFormWithSuccess() {
        driver.get("https://seleniumui.moderntester.pl/form.php");

        FormPage formPage = new FormPage(driver);

        formPage.setLastName("Kowalski");
        formPage.selectGender(Gender.MALE);
        formPage.selectContinent("europe");

    }
}
