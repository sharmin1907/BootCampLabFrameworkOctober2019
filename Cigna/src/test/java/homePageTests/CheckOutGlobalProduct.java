package homePageTests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class CheckOutGlobalProduct extends HomePage {
    @Test
    public void validateCignaInternational(){
        cignaInternationalDisplayed();
        cignaInternationalClickable();
    }
    @Test
    public void checkoutIndividualPlans(){
        cignaInternationalDisplayed();
        cignaInternationalClickable();
        individualPlansDisplayed();
        individualPlansClickable();
        scrollIndividualPlan();
    }
}
