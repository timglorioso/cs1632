import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/* As a user
 | I would like to see various lists made by users
 | so that I can find hand-crafted selections with a particular theme
*/
public class RYMListsTest {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
        // driver.get("https://rateyourmusic.com/lists");
    }

    /* Given that I am on the lists page
     | when I view the page
     | then I see a search bar to find lists based on text matching 
    */
    @Test
    public void testShowsListSearchBar() {
    }

    /* Given that I am on the lists page
     | when I view the Recently Updated section
     | then I can see lists with their titles, authors, and number of items
    */
    @Test
    public void testShowsRecentlyUpdatedListsWithDetails() {
    }

    /* Given that I am on the lists page
     | when I view the Browse by Category section
     | then I can see the top-level list categories
    */
    @Test
    public void testShowsTopLevelListCategories() {
    }

    /* Given that I am on the lists page
     | when I click to expand a top-level list category
     | then I can see its sub-categories
    */
    @Test
    public void testShowsSubCategories() {
    }
}
