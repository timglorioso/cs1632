import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/* As a user
 | I would like to see an overview of site content
 | so that I can stay up-to-date on music ratings, reviews, and releases
*/
public class RYMHomeTest {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
        // driver.get("https://rateyourmusic.com");
    }

    /* Given that I am on the home page
     | when I view the title
     | then I see it contains "Rate Your Music"
    */
    @Test
    public void testShowsCorrectTitle() {
        // assertTrue(driver.getTitle().contains("Rate Your Music"));
    }

    /* Given that I am on the home page
     | when I view the Reviews section
     | then I see at least one featured review
    */
    @Test
    public void testShowsFeaturedReviews() {
    }

    /* Given that I am on the home page
     | when I view the Ratings section
     | then I see at least one recent rating
    */
    @Test
    public void testShowsRecentRatings() {
    }

    /* Given that I am on the home page
     | when I view the Releases section
     | then I see new and upcoming music along with their release dates
    */
    @Test
    public void testShowsNewReleasesWithDates() {
    }

    /* Given that I am on the home page
     | when I view the page header
     | then I see a search bar for easy access to the entire database
    */
    @Test
    public void testShowsSearchBarInHeader() {
    }

    /* Given that I am on the home page
     | when I view the page header
     | then I see links to the site's other features (charts, lists, community)
    */
    @Test
    public void testShowsLinksToOtherFeaturesInHeader() {
    }
}
