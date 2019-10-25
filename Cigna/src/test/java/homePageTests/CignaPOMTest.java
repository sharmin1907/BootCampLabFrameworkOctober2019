package homePageTests;

import base.CommonAPI;
import cignaPOM.CignaPOM;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CignaPOMTest extends CommonAPI {
    CignaPOM cignaPOM;
    @BeforeMethod
    public void setCignaPOM(){
        cignaPOM = PageFactory.initElements(driver,CignaPOM.class);
    }
    @Test(enabled = false)
    public void testContactUs(){
        cignaPOM.contactUsDisplayed();
        cignaPOM.contactUsClickable();
    }
}
