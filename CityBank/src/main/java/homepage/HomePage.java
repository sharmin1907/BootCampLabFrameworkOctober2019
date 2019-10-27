package homepage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import report.TestLogger;

public class HomePage extends CommonAPI {
    /*
     Test Cases:
●	Log In.
●	Click on navigation Tabs for different kind of banking.
●	Read all available features offering for the customers.
●	Browser through all the products it is offering and validates the links.
●	Search Items.
●	Sign Out.

     */

    //Log In.
    public void signOnDisplayed(){
        Assert.assertEquals(isElementDisplayed("//div[@class='editorial theme-light']//h4[contains(text(),'Sign On')]"),true);
        TestLogger.log("Sign on is displayed");
    }
    public void userNameDisplayed(){
        Assert.assertEquals(isElementDisplayed("//input[@id='username']"),true);
        TestLogger.log("Username is displayed");
    }
    public void userNameClickable(){
        clickOnElementByXpath("//input[@id='username']");
        TestLogger.log("Username is clickable");
    }
    public void userNameTypeAble(){
        typeOnElementByXpath("//input[@id='username']","logCity");
        TestLogger.log("Username is typeAble");
    }
    public void passwordDisplayed(){
        Assert.assertEquals(isElementDisplayed("//input[@id='password']"),true);
        TestLogger.log("Password is displayed");
    }
    public void passwordClickable(){
        clickOnElementByXpath("//input[@id='password']");
        TestLogger.log("Password is clickable");
    }
    public void passwordTypeAble(){
        typeOnElementByXpath("//input[@id='password']","abhf1267");
        TestLogger.log("Password is typeAble");
    }
    public void signOnButtonWorks(){
        clickOnElementByXpath("//input[@id='signInBtn']");
        TestLogger.log("Sign in button works");
    }

    //Click on navigation Tabs for different kind of banking.
   public void mouseHoverCreditCards(){
        MouseHover("Credit Cards");
        TestLogger.log("MouseHover Credit Cards");
   }
    public void mouseHoverBanking(){
        MouseHover("Banking");
        TestLogger.log("MouseHover Banking");
    }
    public void mouseHoverLending(){
        MouseHover("Lending");
        TestLogger.log("MouseHover Lending");
    }
    public void mouseHoverInvesting(){
        MouseHover("Investing");
        TestLogger.log("MouseHover Investing");
    }
    public void mouseHoverCitygold(){
        MouseHover("Citigold®");
        TestLogger.log("MouseHover Citygold");
    }


    //Browser through all the products it is offering and validates the links.
    public void creditCardsOffer(){
        Assert.assertEquals(isElementDisplayed("//a[@id='creditcards']"),true);
        clickOnElementByXpath("//a[@id='creditcards']");
        TestLogger.log("click on credit cards");
        clickOnElementByXpath("//div[@class='sia-nav_submenus hidden-xs hidden-sm']//a[@id='lowInterestCards_Link']");
        TestLogger.log("click on 0% Intro APR Credit Cards");
        Assert.assertEquals(isElementDisplayed("//h1[contains(text(),'0% Intro APR Credit Cards')]"),true);
        TestLogger.log("validate 0% Intro APR Credit Cards is displayed");
    }
    public void lendingOffer(){
        Assert.assertEquals(isElementDisplayed("//a[@id='lending']"),true);
        clickOnElementByXpath("//a[@id='lending']");
        TestLogger.log("click on lending");
        clickOnElementByXpath("//div[@class='sia-nav_submenus hidden-xs hidden-sm']//a[@id='personalLoanCredLine_Link']");
        TestLogger.log("click on Personal Loans & Lines of Credit");
        Assert.assertEquals(isElementDisplayed("//h1[@class='header-3 cross-link-heading ng-star-inserted']"),true);
        TestLogger.log("validate Personal Loans & Lines of Credit");
    }
    public void investingOffer(){
        Assert.assertEquals(isElementDisplayed("//a[@id='investing']"),true);
        clickOnElementByXpath("//a[@id='investing']");
        TestLogger.log("click on investing");
        clickOnElementByXpath("//div[@class='sia-nav_submenus hidden-xs hidden-sm']//a[@id='investingCiti_Link']");
        TestLogger.log("click on Investing with Citi");
        Assert.assertEquals(isElementDisplayed("//h1[contains(text(),'Investing with Citi')]"),true);
        TestLogger.log("validate Investing with Citi");
    }

    //Search Items
    public void searchButtonWorks(){
        Assert.assertEquals(isElementDisplayed("//div[@id='personetics-citi-menu']"),true);
        clickOnElementByXpath("//div[@id='personetics-citi-menu']");
        TestLogger.log("Click on search option");
        Assert.assertEquals(isElementDisplayed("//input[@id='citi-autocomplete-content-searchbox-livesearch']"),true);
        clickOnElementByXpath("//input[@id='citi-autocomplete-content-searchbox-livesearch']");
        TestLogger.log("click on search bar");
        typeOnElementByXpath("//input[@id='citi-autocomplete-content-searchbox-livesearch']","Personal loan");
        TestLogger.log("Type on search bar");
        clickOnElementByXpath("//button[@class='citi-autocomplete-content-searchbox-go']");
        TestLogger.log("click on search button");
    }
}
