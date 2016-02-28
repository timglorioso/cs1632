import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/* As a user
 | I would like to interact with other users in the community
 | so that I can discuss music with people from around the world
*/
public class RYMCommunityTest {

    static WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setUp() throws Exception {
        // driver.get("https://rateyourmusic.com/community");
    }

    /* Given that I am on the community page
     | when I view the Forums section
     | then I see a board to talk about music
    */
    @Test
    public void testHasMusicBoard() {
    }

    /* Given that I am on the community page
     | when I view the Forums section
     | then I see a board to discuss the Rate Your Music site itself
    */
    @Test
    public void testHasMetaBoard() {
    }

    /* Given that I am on the community page
     | when I view the Forums section
     | then I see a board for off-topic discussions
    */
    @Test
    public void testHasOffTopicBoard() {
    }

    /* Given that I am on the community page
     | when I view the Members Online section
     | then I can see members' locations, usernames, and listening-to status
    */
    @Test
    public void testShowsOnlineMembersInfo() {
    }

    /* Given that I am on the community page
     | when I view the Member Directory section
     | then I see a search bar discover users via their profile information
    */
    @Test
    public void testShowsSearchBarForMemberDirectory() {
    }

    /* Given that I am on the community page
     | when I view the Newest Members section
     | then I see a list of new members with some of their profile information
    */
    @Test
    public void testShowsNewMembersWithInfo() {
    }
}
