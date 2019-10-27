package homepagetests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class SignOutTest extends HomePage {
    @Test(enabled = false)
    public void validateSignOut(){
        login();
        validateEmailField();
        typeOnEmailField("Kanij@gmail.com");
        clickOnContinue();
        validatePasswordField("abc1234");
        clickOnSignInButton();
        signOut();
    }
}
