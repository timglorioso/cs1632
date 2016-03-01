import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/* As a user
 | I would like to see a variety of charts based on different criteria
 | so that I can discover highly-rated music
*/
public class RYMChartsTest {

    static WebDriver driver = new HtmlUnitDriver();

    @BeforeClass
    public static void setUpOnce() {

        // only GET once since all tests use non-destructive inspection
        driver.get("https://rateyourmusic.com/customchart");

        // turn off annoying warnings
        Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
    }

    /* Given that I am on the charts page
     | when I view the default chart
     | then I see the top-rated albums from all-time
    */
    @Test
    public void testShowsDefaultChart() {
        WebElement chartType = driver.findElement(By.name("chart_type"));
        WebElement type = driver.findElement(By.name("type"));
        WebElement year = driver.findElement(By.name("year"));
        boolean top = getOption(chartType, "Top").isSelected();
        boolean albums = getOption(type, "albums").isSelected();
        boolean allTime = getOption(year, "all-time").isSelected();
        assertTrue(top && albums && allTime);
    }

    // helper method to find an option by its name (the inner text)
    private WebElement getOption(WebElement parent, String name) {
        By byOptionTag = By.tagName("option");
        for (WebElement option : parent.findElements(byOptionTag)) {
            if (option.getText().contains(name)) {
                return option;
            }
        }
        return null;
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can specify which genres appear
    */
    @Test
    public void testCanShowReleasesSpecifiedGenre() {
        try {
            WebElement dropDown = driver.findElement(By.name("genre_include"));
            WebElement textField = driver.findElement(By.id("genres"));
            WebElement checkbox = driver.findElement(By.id("include_child_genres_chk"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can control if archival and live releases are shown
    */
    @Test
    public void testCanShowArchivalAndLiveReleases() {
        try {
            WebElement dropDown = driver.findElement(By.id("include"));
            WebElement cb1 = driver.findElement(By.id("include_archival"));
            WebElement cb2 = driver.findElement(By.id("include_live"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can specify the artist's native or current country
    */
    @Test
    public void testCanShowReleasesFromSpecifiedCountry() {
        try {
            WebElement textField = driver.findElement(By.id("origin_countries"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can specify releases only rated by my friends
    */
    @Test
    public void testCanShowReleasesRatedByFriends() {
        try {
            WebElement radio = driver.findElement(By.id("limit_friends"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }
}
