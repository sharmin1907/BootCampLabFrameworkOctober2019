package homepage;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

    //Log In.
    public void login() {
        Assert.assertEquals(isElementDisplayed("//span[contains(text(),'Hello, Sign in')]"), true);
        clickOnElementByXpath("//span[contains(text(),'Hello, Sign in')]");
        clickOnElementByXpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][contains(text(),'Sign in')]");
        TestLogger.log("sign in field open");
    }
    public void validateEmailField(){
            clickOnElementByXpath("//input[@id='ap_email']");
        }
        public void typeOnEmailField(String value){
            typeOnElementByXpath("//input[@id='ap_email']",value);
        }
        public void clickOnContinue(){
        clickOnElementByXpath("//input[@id='continue']");
    }
    public void validatePasswordField(String value){
        typeOnElementByXpath("//input[@id='ap_password']",value);
    }
    public void clickOnSignInButton(){
        clickOnElementByXpath("//input[@id='signInSubmit']");
    }

    //Browse the products and use the shopping cart to check out.

    public void validateSearch(){
        driver.navigate().to("https://www.amazon.com/?ref_=nav_signin&");
        typeOnElementByXpath("//input[@id='twotabsearchtextbox']","selenium books");
    }
    public void validateSubmitSearch(){
        clickOnElementByXpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']");
    }
    public void validateSearchResult(){
        isElementDisplayed("//a[@class='nav-imageHref']//img");
    }
    public void validateProducts(){
        clickOnElementByXpath("//span[contains(text(),'Test Automation using Selenium WebDriver with Java')]");
    }
    public void validateShoppingCart(){
        clickOnElementByXpath("//input[@id='add-to-cart-button']");
        driver.navigate().to("https://www.amazon.com");
    }
    //Search Items and verify items.
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

    //sign out
    public void signOut() {
        clickOnElementByXpath("//a[@id='nav-link-accountList']");
        clickOnElementByXpath("//a[@id='nav-item-signout']");
    }


    public List<WebElement> getAllElementFromList() {
       /* List<WebElement>elementList=driver.findElements(By.xpath("//*[contains(@value,'search-alias')]"));
        return elementList;*/
        return driver.findElements(By.xpath("//*[contains(@value,'search-alias')]"));
    }
}
