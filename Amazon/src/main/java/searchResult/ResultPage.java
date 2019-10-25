package searchResult;

import base.CommonAPI;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import report.TestLogger;

public class ResultPage extends CommonAPI {
    public void validateSearchPageDisplayed() {
        WebElement element = getElement("//div[@id='s-refinements']");
        Assert.assertEquals(element.isDisplayed(), true, "element isn't displayed");
        TestLogger.log("Search result panel is displayed : " + element.isDisplayed());
    }
}
