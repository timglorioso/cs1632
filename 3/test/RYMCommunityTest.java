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
 | I would like to interact with other users in the community
 | so that I can discuss music with people from around the world
*/
public class RYMCommunityTest {

    static WebDriver driver = new HtmlUnitDriver();

    @BeforeClass
    public static void setUpOnce() {

        // only GET once since all tests use non-destructive inspection
        driver.get("https://rateyourmusic.com/community");

        // turn off annoying warnings
        Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
    }

    /* Given that I am on the community page
     | when I view the Forums section
     | then I see a board to talk about music
    */
    @Test
    public void testHasMusicBoard() {
        try {
            WebElement forums = getSection("Forums");
            WebElement table = driver.findElement(By.className("mbgen"));
            List<WebElement> boards = table.findElements(By.tagName("td"));
            assertTrue(boards.get(0).getText().contains("Music"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the community page
     | when I view the Forums section
     | then I see a board to discuss the Rate Your Music site itself
    */
    @Test
    public void testHasMetaBoard() {
        try {
            WebElement forums = getSection("Forums");
            WebElement table = driver.findElement(By.className("mbgen"));
            assertTrue(table.getText().contains("Rate Your Music"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the community page
     | when I view the Forums section
     | then I see a board for off-topic discussions
    */
    @Test
    public void testHasOffTopicBoard() {
        try {
            WebElement forums = getSection("Forums");
            WebElement table = driver.findElement(By.className("mbgen"));
            assertTrue(table.getText().contains("Off-Topic"));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the community page
     | when I view the Members Online section
     | then I can see members' locations, usernames, and listening-to status
    */
    @Test
    public void testShowsOnlineMembersInfo() {
        try {
            WebElement online = getSection("Members online");
            WebElement table = driver.findElement(By.id("membersOnline"));
            WebElement headers = table.findElements(By.tagName("tr")).get(0);
            assertThat(headers.getText(), allOf(containsString("Loc"), containsString("Username"), containsString("Listening to")));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the community page
     | when I view the Member Directory section
     | then I see a search bar discover users via their profile information
    */
    @Test
    public void testShowsSearchBarForMemberDirectory() {
        try {
            WebElement directory = getSection("Member directory");
            WebElement form = driver.findElement(By.id("tempform"));
            WebElement textField = form.findElement(By.name("searchterm"));
            WebElement categories = form.findElement(By.name("subcategory"));
            assertThat(categories.getText(), allOf(containsString("Username"), containsString("Name"), containsString("Location"), containsString("Profile Description")));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    /* Given that I am on the community page
     | when I view the Newest Members section
     | then I see a list of new members with some of their profile information
    */
    @Test
    public void testShowsNewMembersWithInfo() {
        try {
            WebElement newMembers = getSection("Newest Members");
            WebElement table = driver.findElement(By.id("newestUsers"));
            WebElement headers = table.findElements(By.tagName("tr")).get(0);
            assertThat(headers.getText(), allOf(containsString("Username"), containsString("Name"), containsString("Age/Sex"), containsString("Country")));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    // helper method to find a section by its name (the inner text)
    private WebElement getSection(String name) {
        By bySectionTag = By.tagName("h4");
        for (WebElement section : driver.findElements(bySectionTag)) {
            if (section.getText().contains(name)) {
                return section;
            }
        }
        return null;
    }
}
