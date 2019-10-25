package homepagetests;

import POM.HomePagePOM;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class WholeFoodsTests extends CommonAPI {
    @Test
    public void testWholeFoods() {
        HomePagePOM homePagePOM = PageFactory.initElements(driver, HomePagePOM.class);
        homePagePOM.validateWholeFoodsDisplayed();
        homePagePOM.validateWholeFoodsClickAble();
    }
}
