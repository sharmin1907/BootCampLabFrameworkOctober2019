package homepagetests;

import POM.HomePagePOM;
import base.CommonAPI;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePagePOMTest extends CommonAPI {
    HomePagePOM homePagePOM;
    @BeforeMethod
    public void setHomePagePOM(){
        homePagePOM= PageFactory.initElements(driver,HomePagePOM.class);
    }
    @Test(enabled = false)
    public void testWholeFoods(){
        homePagePOM.validateWholeFoodsDisplayed();
        homePagePOM.validateWholeFoodsClickAble();
    }
}
