import org.testng.annotations.Test;

public class OpenModernTesterWebsite extends TestBase{

    @Test
    public void shouldOpenModernTesterWebsite(){
        driver.get("https://seleniumui.moderntester.pl/");
    }
}
