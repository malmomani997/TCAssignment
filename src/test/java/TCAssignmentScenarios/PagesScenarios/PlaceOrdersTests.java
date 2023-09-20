package TCAssignmentScenarios.PagesScenarios;

import TCAssignmentHelpers.Resources.TestData;
import TCAssignmentScenarios.TestHelpers.BaseTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaceOrdersTests extends BaseTest {
    /*
    In the following three scenarios I'm trying to place an order with different plan types on each local
    Note that I cant place the order all the way to the end as Its on prod Env
     */

    @Test
    public void placeOrderWithLitePlanOnSaudiLocal() {
        String priceOnLandingForThePlan = getCheckoutPlanPrice(StcLanding.liteCurrency);
        Checkout.checkoutPlan(Checkout.checkoutWithLitePlan);
        Assert.assertEquals(priceOnLandingForThePlan, Checkout.getPriceOfPlanWithoutFractional(), "Prices Didn't Match Between Landing Page And Checkout Page");
        Checkout.confirmPaymentButton();
        Assert.assertTrue(Checkout.addonsFormDisplayed());
        Checkout.chooseAddOn(0);
        Checkout.confirmAddonsButton();
        Assert.assertTrue(Checkout.placeOrderFormDisplayed());
        Checkout.addPhoneNumber(TestData.phoneNumber);
        Checkout.confirmSubscriptionButton();
    }

    @Test(groups = {"Smoke"})
    public void placeOrderWithClassicPlanOnKuwaitLocal() {
        StcLanding.updateCountry();
        Assert.assertTrue(StcLanding.updateCountryPopupDisplayed(), "Update Country Popup Wasn't Displayed");
        StcLanding.chooseCountry(StcLanding.navigateToKuwait);
        String priceOnLandingForThePlan = getCheckoutPlanPrice(StcLanding.classicCurrency);
        Checkout.checkoutPlan(Checkout.checkoutWithClassicPlan);
        Assert.assertEquals(priceOnLandingForThePlan, Checkout.getPriceOfPlanWithFractional(), "Prices Didn't Match Between Landing Page And Checkout Page");
        Checkout.confirmPaymentButton();
        Assert.assertTrue(Checkout.addonsFormDisplayed());
        Checkout.chooseAddOn(0);
        Checkout.confirmAddonsButton();
        Assert.assertTrue(Checkout.placeOrderFormDisplayed());
        Checkout.addPhoneNumber(TestData.phoneNumber);
        Checkout.confirmSubscriptionButton();
    }

    @Test
    public void placeOrderWithPremiumPlanOnBahrainLocal() {
        StcLanding.updateCountry();
        Assert.assertTrue(StcLanding.updateCountryPopupDisplayed(), "Update Country Popup Wasn't Displayed");
        StcLanding.chooseCountry(StcLanding.navigateToBahrain);
        String priceOnLandingForThePlan = getCheckoutPlanPrice(StcLanding.premiumCurrency);
        Checkout.checkoutPlan(Checkout.checkoutWithPremiumPlan);
        Assert.assertEquals(priceOnLandingForThePlan, Checkout.getPriceOfPlanWithoutFractional(), "Prices Didn't Match Between Landing Page And Checkout Page");
        Checkout.confirmPaymentButton();
        Assert.assertTrue(Checkout.addonsFormDisplayed());
        Checkout.chooseAddOn(0);
        Checkout.confirmAddonsButton();
        Assert.assertTrue(Checkout.placeOrderFormDisplayed());
        Checkout.addPhoneNumber(TestData.phoneNumber);
        Checkout.confirmSubscriptionButton();
    }

    public String getCheckoutPlanPrice(WebElement planType) {
        return StcLanding.getPlanPrice(planType);
    }


}