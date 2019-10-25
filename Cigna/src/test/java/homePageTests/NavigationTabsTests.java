package homePageTests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class NavigationTabsTests extends HomePage {
    @Test
    public void validateIndividualsAndFamilies(){
        individualsAndFamiliesDisplayed();
        individualsAndFamiliesClickable();
    }
    @Test
    public void validateEmployersAndBrokers(){
        employersAndBrokersDisplayed();
        employersAndBrokersClickable();
    }
    @Test
    public void validateHealthCareProviders(){
        healthCareProvidersDisplayed();
        healthCareProvidersClickable();
    }
    @Test
    public void validateAboutUs(){
        aboutUsDisplayed();
        aboutUsClickable();
    }
}
