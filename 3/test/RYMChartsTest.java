import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/* As a user
 | I would like to see a variety of charts based on different criteria
 | so that I can discover highly-rated music
*/
public class RYMChartsTest {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
        // driver.get("https://rateyourmusic.com/customchart");
    }

    /* Given that I am on the charts page
     | when I view the default chart
     | then I see the top-rated albums from all-time
    */
    @Test
    public void testShowsDefaultChart() {
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can select the chart type, release type, and year
    */
    @Test
    public void testAcceptsBasicChartParameters() {
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can specify which genres appear
    */
    @Test
    public void testCanShowReleasesSpecifiedGenre() {
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can control if archival and live releases are shown
    */
    @Test
    public void testCanShowArchivalAndLiveReleases() {
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can specify the artist's native or current country
    */
    @Test
    public void testCanShowReleasesFromSpecifiedCountry() {
    }

    /* Given that I am on the charts page
     | when I view the chart control panel
     | then I can specify a subset of users who've rated the shown releases
    */
    @Test
    public void testCanShowReleasesRatedBySubsetOfUsers() {
    }
}
