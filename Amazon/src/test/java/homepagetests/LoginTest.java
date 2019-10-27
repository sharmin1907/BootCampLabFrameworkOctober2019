package homepagetests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class LoginTest extends HomePage {
    @Test(enabled = false)
    public void validateLoginWorks(){
        login();
        validateEmailField();
        typeOnEmailField("Kanij@gmail.com");
        clickOnContinue();
        validatePasswordField("abc1234");
        clickOnSignInButton();
    }
}
