import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends TestBase {

    @Test
    public void shouldPrintPeaksOver4000m() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        Assert.assertTrue(rows.size() > 0);

        for (WebElement row : rows) {
            String heightV1 = row.findElement(By.xpath("td[4]")).getText();
            String heightV2 = row.findElements(By.cssSelector("td")).get(3).getText();

            // "3405" -> 3405
            int height = Integer.parseInt(heightV1);

            //wypisac wszystkie dane o gorach, ale tych wyzszych niz 4000m
        }

    }
}
