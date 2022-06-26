import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RowPage;
import pages.TablePage;

import java.util.List;

public class TableTest extends TestBase {

    @Test
    public void shouldPrintPeaksOver4000m() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));

        Assert.assertTrue(rows.size() > 0);

        for (WebElement row : rows) {
            String peak = row.findElements(By.cssSelector("td")).get(0).getText();

            // "5" -> 5
            int height = Integer.parseInt(row.findElement(By.xpath("td[4]")).getText());

            // 5 -> "5"
            //String numberAsText = String.valueOf(5);
            System.out.println(peak + height);
        }

    }

    @Test
    public void shouldPrintPeaksOver4000m2() {
        driver.get("https://seleniumui.moderntester.pl/table.php");

        List<RowPage> allMountains = new TablePage(driver).getAllMountains();

        Assert.assertTrue(allMountains.size() > 0);

        for (RowPage rowPage : allMountains) {
            System.out.println(rowPage.getPeak() + rowPage.getHeight());
        }

    }
}
