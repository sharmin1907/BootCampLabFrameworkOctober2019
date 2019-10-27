package homepagetests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class BrowseProductToCheckOut extends HomePage {
    @Test(enabled = false)
    public void TestBrowsingProducts(){
        validateSearch();
        validateSubmitSearch();
        validateSearchResult();
        validateProducts();
        validateShoppingCart();
    }
}
