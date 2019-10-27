package homepageTests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class ProductOfferingValidationTests extends HomePage {
    @Test
    public void validateCreditCardsOffer(){
        creditCardsOffer();
        lendingOffer();
        investingOffer();
    }
}
