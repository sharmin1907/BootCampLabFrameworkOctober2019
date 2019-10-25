package cignaPOM;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import report.TestLogger;

public class CignaPOM extends CommonAPI {
    @FindBy(linkText = "Contact Us")
    public static WebElement ContactUs;
    @FindBy(xpath = "//div[@id='header-row']/div[@class='ls-lqr']/div[@class='ls-area']/div[@class='ls-area-body']/div[@class='ls-cmp-wrap']//h1[@class='display']")
    public static WebElement ContactUsValue;


    public void contactUsDisplayed(){
        Assert.assertEquals(ContactUs.isDisplayed(),true);
        TestLogger.log("Contact us is displayed");
    }
    public void contactUsClickable(){
        ContactUs.click();
        Assert.assertEquals(ContactUsValue.isDisplayed(),true);

    }

}
