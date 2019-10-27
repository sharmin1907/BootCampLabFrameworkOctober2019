package homepageTests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class SigninTest extends HomePage {
    @Test(enabled = false)
    public void validateSignin(){
        signOnDisplayed();
        userNameDisplayed();
        userNameClickable();
        userNameTypeAble();
        passwordDisplayed();
        passwordClickable();
        passwordTypeAble();
        signOnButtonWorks();

    }
}
