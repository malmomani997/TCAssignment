package TCAssignmentScenarios.PagesScenarios;

import TCAssignmentScenarios.TestHelpers.BaseTest;
import TCAssignmentScenarios.TestHelpers.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;


public class StcLandingPageTest extends BaseTest {

    /*
    In the verifyCurrencyAndLocalsBeingUpdated test we are verifying first that the page components
    Are being displayed then we are verifying the currency compared to the country then we are
    Checking the updating the locals and doing the same check for each local
     */

    @Test(retryAnalyzer = Retry.class)
    public void verifyCurrencyAndLocalsBeingUpdated() {
        verifyPlansAndCurrencyDisplayed();

        StcLanding.updateCountry();
        Assert.assertTrue(StcLanding.updateCountryPopupDisplayed() , "Update Country Popup Wasn't Displayed");
        StcLanding.chooseCountry(StcLanding.navigateToBahrain);

        verifyPlansAndCurrencyDisplayed();

        StcLanding.updateCountry();
        Assert.assertTrue(StcLanding.updateCountryPopupDisplayed(), "Update Country Popup Wasn't Displayed");
        StcLanding.chooseCountry(StcLanding.navigateToKuwait);

        verifyPlansAndCurrencyDisplayed();

    }

    /*
      In the verifyPricesOfPlansOnAllLocals test we are checking for all plans prices (lite , classic , premium)
      Across all three locals (SA,KW,BH)
     */
    @Test(retryAnalyzer = Retry.class , groups = {"Smoke"})
    public void verifyPricesOfPlansOnAllLocals()
    {
        verifyAllPlansPrices();

        StcLanding.updateCountry();
        Assert.assertTrue(StcLanding.updateCountryPopupDisplayed() , "Update Country Popup Wasn't Displayed");
        StcLanding.chooseCountry(StcLanding.navigateToBahrain);
        verifyAllPlansPrices();

        StcLanding.updateCountry();
        Assert.assertTrue(StcLanding.updateCountryPopupDisplayed() , "Update Country Popup Wasn't Displayed");
        StcLanding.chooseCountry(StcLanding.navigateToKuwait);
        verifyAllPlansPrices();
    }

    /*
    In this test I'm trying to verify that the redeem gift card section is only displayed on the Saudi Arabia local and
    It's not displayed on Kuwait and Bahrain Locals
     */

    @Test
    public void verifyGiftCardSectionIsOnlyInSaudi() {
        verifyPlansAndCurrencyDisplayed();
        Assert.assertTrue(StcLanding.verifyGiftCardSection() , "Gift Card Sections Wasn't Displayed");

        StcLanding.updateCountry();
       Assert.assertTrue(StcLanding.updateCountryPopupDisplayed() , "Update Country Popup Wasn't Displayed");
        StcLanding.chooseCountry(StcLanding.navigateToBahrain);

        Assert.assertFalse(StcLanding.verifyGiftCardSection() , "Gift Card Section Was Displayed");

        StcLanding.updateCountry();
        Assert.assertTrue(StcLanding.updateCountryPopupDisplayed(), "Update Country Popup Wasn't Displayed");
        StcLanding.chooseCountry(StcLanding.navigateToKuwait);

        Assert.assertFalse(StcLanding.verifyGiftCardSection() , "Gift Card Section Was Displayed" );

    }




   public void verifyPlansAndCurrencyDisplayed(){
       Assert.assertTrue(StcLanding.allPlansDisplayed() , "Plans Weren't Displayed Correctly");
       Assert.assertTrue(StcLanding.verifyCurrencyByCountry(), "Country Doesn't Match The Currency");
   }

   public void verifyAllPlansPrices() {
       Assert.assertTrue(StcLanding.allPlansDisplayed() , "Plans Weren't Displayed Correctly");
       Assert.assertTrue(StcLanding.verifyCurrencyByCountry(), "Country Doesn't Match The Currency");
       Assert.assertTrue(StcLanding.verifyPriceForLitePlan() , "Price of the Lite Plan Isn't Correct");
       Assert.assertTrue(StcLanding.verifyPriceForClassicPlan() , "Price of the Classic Plan Isn't Correct");
       Assert.assertTrue(StcLanding.verifyPriceForPremiumPlan() , "Price of the Premium Plan Isn't Correct");
   }

}