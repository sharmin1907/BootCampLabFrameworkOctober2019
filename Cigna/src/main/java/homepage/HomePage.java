package homepage;

import base.CommonAPI;
import org.testng.Assert;
import report.TestLogger;

public class HomePage extends CommonAPI {
    /*
    Test Cases:
●	Log In.
●	Click on navigation Tabs.
●	Navigate through different level of Health coverage.
●	Search for Medical tools.
●	Checkout the Cigna global products.
●	Sign Out.

     */
    //Log in
    public void loginWorks(){
        Assert.assertEquals(isElementDisplayed("//a[@class='btn btn-sm btn-primary'][text()='Log in to myCigna']"),true);
        clickOnElementByXpath("//a[@class='btn btn-sm btn-primary'][text()='Log in to myCigna']");
        driver.navigate().to("https://my.cigna.com/web/public/guest");
        clickOnElementByXpath("//input[@id='username']");
        typeOnElementByXpath("//input[@id='username']","Random");
        clickOnElementByXpath("//input[@id='password']");
        typeOnElementByXpath("//input[@id='password']","1234abcd");
        clickOnElementByXpath("//input[@id='loginbutton']");
    }

    //Click on navigation Tabs
    public void individualsAndFamiliesDisplayed(){
        Assert.assertEquals(isElementDisplayed("//a[@class='nav-link'][contains(text(),'Individuals and Families')]"),true);
        TestLogger.log("Individuals and Families is displayed");
    }
    public void individualsAndFamiliesClickable(){
        clickOnElementByXpath("//a[@class='nav-link'][contains(text(),'Individuals and Families')]");
        TestLogger.log("Click on Individual and Families");
    }
    public void employersAndBrokersDisplayed(){
        Assert.assertEquals(isElementDisplayed("//a[@class='nav-link'][contains(text(),'Employers and Brokers')]"),true);
        TestLogger.log("Employers And Brokers is displayed");
    }
    public void  employersAndBrokersClickable(){
        clickOnElementByXpath("//a[@class='nav-link'][contains(text(),'Employers and Brokers')]");
        TestLogger.log("Click on Employers And Brokers");
    }
    public void healthCareProvidersDisplayed(){
        Assert.assertEquals(isElementDisplayed("//a[@class='nav-link'][contains(text(),'Health Care Providers')]"),true);
        TestLogger.log("Health Care Providers is displayed");
    }
    public void  healthCareProvidersClickable(){
        clickOnElementByXpath("//a[@class='nav-link'][contains(text(),'Health Care Providers')]");
        TestLogger.log("Click on Health Care Providers");
    }
    public void aboutUsDisplayed(){
        Assert.assertEquals(isElementDisplayed("//a[@class='nav-link'][contains(text(),'About Us')]"),true);
        TestLogger.log("About Us is displayed");
    }
    public void  aboutUsClickable(){
        clickOnElementByXpath("//a[@class='nav-link'][contains(text(),'About Us')]");
        TestLogger.log("Click on About Us");
    }

    //Navigate through different level of Health coverage
    public void coverageAndClaimsDisplayed(){
        Assert.assertEquals(isElementDisplayed("//button[contains(text(),'Coverage and Claims')]"),true);
        TestLogger.log("Coverage and Claims is displayed");
    }
    public void coverageAndClaimsClickable(){
        clickOnElementByXpath("//button[contains(text(),'Coverage and Claims')]");
        TestLogger.log("Click on Coverage and Claims");
    }
    public void coveragePolicyClickable(){
        clickOnElementByXpath("//a[contains(text(),'Coverage Policies')]");
        TestLogger.log("Coverage policies is clickable");
    }
    public void scrollCoveragePolicies(){
        driver.navigate().to("https://www.cigna.com/health-care-providers/coverage-and-claims/policies/");
        scrollIntoView("//a[contains(text(),'Back to Coverage and')]");
    }

    //Checkout the Cigna global products
    public void cignaInternationalDisplayed(){
        Assert.assertEquals(isElementDisplayed("//a[@class='nav-link small-text'][contains(text(),'Cigna International')]"),true);
        TestLogger.log("Cigna International is displayed");
    }
    public void cignaInternationalClickable(){
        clickOnElementByXpath("//a[@class='nav-link small-text'][contains(text(),'Cigna International')]");
        TestLogger.log("Click on Cigna International");
    }
    public void individualPlansDisplayed(){
        Assert.assertEquals(isElementDisplayed("//a[contains(text(),'Individual Plans')]"),true);
        TestLogger.log("Individual Plans is displayed");
    }
    public void individualPlansClickable(){
        clickOnElementByXpath("//a[contains(text(),'Individual Plans')]");
        TestLogger.log("Click on Individual Plans");
    }
    public void scrollIndividualPlan(){
        driver.navigate().to("https://www.cigna.com/international/individual-plans?WT.z_nav=international;Header;Individual%20Plans");
        scrollIntoView("//h2[contains(text(),'Outpatient Insurance')]");
        clickOnElementByXpath("//li[1]//div[1]//div[1]//div[1]//div[2]//a[1]");
    }
}
