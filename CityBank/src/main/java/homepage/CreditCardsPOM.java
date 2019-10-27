package homepage;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import report.TestLogger;

public class CreditCardsPOM extends CommonAPI {
    @FindBy(linkText = "View All Credit Cards")
    public static WebElement ViewAllCreditCards;
    @FindBy(xpath = "//div[@id='ca-DD-mainTitle']/h1[.='Citi Credit Cards – Apply Online ']")
    public static WebElement ViewAllCreditCardsValue;

    public void validateViewAllCreditCardsDisplayed(){
        Assert.assertEquals(ViewAllCreditCards.isDisplayed(),true);
        TestLogger.log("View all credit cards displayed");
    }
    public void validateViewAllCreditCardsClickable(){
        ViewAllCreditCards.click();
        Assert.assertEquals(ViewAllCreditCardsValue.isDisplayed(),true);
        TestLogger.log("view all credit cards clickable");
    }
}
