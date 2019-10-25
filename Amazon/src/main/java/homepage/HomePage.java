package homepage;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import report.TestLogger;

import java.util.List;

public class HomePage extends CommonAPI {

    /*Test cases:
●	Log In.
●	Browse the products and use the shopping cart to check out.
●	Search Items and verify items.
●	Verify autosuggestion.
●	Navigate to the products.
●	Sign Out.
*/
    public void clickOnSearchBar() {
        clickOnElementByXpath("//input[@id='twotabsearchtextbox']");
        TestLogger.log("Search bar clicked");

    }

    public void typeOnSearchBar(String value) {
        typeOnElementByXpath("//input[@id='twotabsearchtextbox']", value);
        TestLogger.log(value + " typed on Search bar");

    }

    public void clickOnSearchButton() {
        clickOnElementByXpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");
        TestLogger.log("Search button clicked");

    }

    public List<WebElement> getAllElementFromList() {
       /* List<WebElement>elementList=driver.findElements(By.xpath("//*[contains(@value,'search-alias')]"));
        return elementList;*/
        return driver.findElements(By.xpath("//*[contains(@value,'search-alias')]"));
    }
}
