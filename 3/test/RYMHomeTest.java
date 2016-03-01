import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/* As a user
 | I would like to see an overview of site content
 | so that I can stay up-to-date on music ratings, reviews, and releases
*/
public class RYMHomeTest {

    static WebDriver driver = new HtmlUnitDriver();

    @BeforeClass
    public static void setUpOnce() {

        // only GET once since all tests use non-destructive inspection
        driver.get("https://rateyourmusic.com");

        // turn off annoying warnings
        Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
    }

    /* Given that I am on the home page
     | when I view the title
     | then I see it contains "Rate Your Music"
    */
    @Test
    public void testShowsCorrectTitle() {
        assertTrue(driver.getTitle().contains("Rate Your Music"));
    }

    /* When I am on the home page
     | then I see the Reviews section
    */
    @Test
    public void testShowsFeaturedReviews() {
        WebElement reviews = getSection("Reviews");
        assertNotNull(reviews);
    }

    /* When I am on the home page
     | then I see the Latest Ratings section
    */
    @Test
    public void testShowsRecentRatings() {
        WebElement ratings = getSection("Latest Ratings");
        assertNotNull(ratings);
    }

    /* When I am on the home page
     | then I see the New Releases section
    */
    @Test
    public void testShowsNewReleasesWithDates() {
        WebElement releases = getSection("New Releases");
        assertNotNull(releases);
    }

    // helper method to find a section by its name (the inner text)
    private WebElement getSection(String name) {
        By bySectionClass = By.className("bubble_header");
        for (WebElement section : driver.findElements(bySectionClass)) {
            if (section.getText().contains(name)) {
                return section;
            }
        }
        return null;
    }

    /* Given that I am on the home page
     | when I view the page header
     | then I see a search bar for easy access to the entire database
    */
    @Test
    public void testShowsSearchBarInHeader() {
        WebElement header = driver.findElement(By.id("navtop"));
        WebElement searchBar = header.findElement(By.id("mainsearch"));
        assertNotNull(searchBar);
    }

    /* Given that I am on the home page
     | when I view the page header
     | then I see links to the site's other features (charts, lists, community)
    */
    @Test
    public void testShowsLinksToOtherFeaturesInHeader() {
        WebElement header = driver.findElement(By.id("navtop"));
        try {
            header.findElement(By.linkText("charts"));
            header.findElement(By.linkText("lists"));
            header.findElement(By.linkText("community"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }
}
