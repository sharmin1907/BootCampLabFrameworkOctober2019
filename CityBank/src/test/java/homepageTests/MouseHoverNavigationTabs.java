package homepageTests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class MouseHoverNavigationTabs extends HomePage {
    @Test(enabled = false)
    public void MouseHoverNavigationTabTest() {
        mouseHoverCreditCards();
        mouseHoverBanking();
        mouseHoverLending();
        mouseHoverInvesting();
        mouseHoverCitygold();
    }
}
