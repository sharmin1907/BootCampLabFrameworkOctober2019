package homePageTests;

import homepage.HomePage;
import org.testng.annotations.Test;

public class CoverageAndClaims extends HomePage {
    @Test
    public void validateCoverageAndClaims(){
        healthCareProvidersDisplayed();
        healthCareProvidersClickable();
        coverageAndClaimsDisplayed();
        coverageAndClaimsClickable();
        coveragePolicyClickable();
        scrollCoveragePolicies();

    }
}
