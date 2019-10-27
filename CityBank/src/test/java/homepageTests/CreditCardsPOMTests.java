package homepageTests;

import base.CommonAPI;
import homepage.CreditCardsPOM;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreditCardsPOMTests extends CommonAPI {
    CreditCardsPOM creditCardsPOM;
   // HomePage homePage;
    @BeforeMethod
    public void setCreditCardsPOM(){
        creditCardsPOM= PageFactory.initElements(driver,CreditCardsPOM.class);
    }
    @Test(enabled = false)
    public void TestCreditCards(){
        clickOnElementByXpath("//a[@id='creditcards']");
        creditCardsPOM.validateViewAllCreditCardsDisplayed();
        creditCardsPOM.validateViewAllCreditCardsClickable();
        scrollIntoView("Contact Us");


    }
}
