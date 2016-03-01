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
 | I would like to see various lists made by users
 | so that I can find hand-crafted selections with a particular theme
*/
public class RYMListsTest {

    static WebDriver driver = new HtmlUnitDriver();

    @BeforeClass
    public static void setUpOnce() {

        // only GET once since all tests use non-destructive inspection
        driver.get("https://rateyourmusic.com/lists");

        // turn off annoying warnings
        Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
    }

    /* Given that I am on the lists page
     | when I view the page
     | then I see a search bar to find lists based on text matching 
    */
    @Test
    public void testShowsListSearchBar() {
        try {
            WebElement search = driver.findElement(By.className("findsearchform"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the lists page
     | when I view the Recently Updated section
     | then I can see lists with their titles, authors, and number of items
    */
    @Test
    public void testShowsRecentlyUpdatedListsWithDetails() {
        try {
            WebElement recUp = driver.findElement(By.className("mbgen"));
            WebElement list = recUp.findElements(By.tagName("tr")).get(0);
            WebElement title = list.findElement(By.className("list"));
            WebElement details = list.findElement(By.tagName("blockquote"));
            assertThat(details.getText(),
                       both(containsString("Author"))
                       .and(containsString("items")));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the lists page
     | when I view the Browse by Category section
     | then I can see the five top-level list categories
    */
    @Test
    public void testShowsTopLevelListCategories() {
        List<WebElement> topLevels = driver.findElements(By.className("topleveldiv"));
        assertEquals(5, topLevels.size());
    }
}
