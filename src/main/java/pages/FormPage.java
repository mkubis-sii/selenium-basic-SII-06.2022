package pages;

import enums.Gender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormPage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;

    @FindBy(name = "gridRadiosSex")
    private List<WebElement> genders;

    @FindBy(id = "selectContinents")
    private WebElement selectContinents;

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void selectMale() {
        genders.get(0).click();
    }

    public void selectGender(Gender gender) {
        switch (gender) {
            case MALE:
                genders.get(0).click();
                break;
            case FEMALE:
                genders.get(1).click();
                break;
            case OTHER:
                genders.get(2).click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gender);
        }
    }

    public void selectContinent(String continent) {
        new Select(selectContinents).selectByValue(continent);
    }


}
