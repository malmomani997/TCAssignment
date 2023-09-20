package TCAssignmentHelpers.PagesHelpers;

import TCAssignmentHelpers.SharedElements.SharedElementsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StcLandingPageHelper extends SharedElementsHelper {

    WebDriver driver;

    public StcLandingPageHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "country-name")
    WebElement countryName;

    public @FindBy(id = "currency-lite")
    WebElement liteCurrency;

    public @FindBy(id = "currency-classic")
    WebElement classicCurrency;

    public @FindBy(id = "currency-premium")
    WebElement premiumCurrency;

    @FindBy(css = "div[class='country-current']")
    WebElement updateCountryButton;

    @FindBy(id = "country-selct")
    WebElement countrySelectForm;

    public @FindBy(id = "bh")
    WebElement navigateToBahrain;

    public @FindBy(id = "sa")
    WebElement navigateToSaudi;

    public @FindBy(id = "kw")
    WebElement navigateToKuwait;


    @FindBy(id = "name-lite")
    WebElement litePlan;

    @FindBy(id = "name-classic")
    WebElement classicPlan;

    @FindBy(id = "name-premium")
    WebElement premiumPlan;

    @FindBy(css = "div[class='giftcard']")
    WebElement giftCardSection;

    @FindBy(css = "button[class='button']:nth-child(3)")
    WebElement goToAddGiftCardButton;

    public void navigateToStc() {
        driver.get("https://subscribe.stctv.com/sa-en");
    }

    public String getCountryName() {
        return countryName.getText();
    }

    public String getPlanName(WebElement plan) {
        return plan.getText();
    }

    public String getCountryCurrency() {
        return classicCurrency.getText().split(" ")[1].split("/")[0];
    }

    public String getPlanPrice(WebElement planType) {
        return planType.getText().split(" ")[0].trim();
    }

    public boolean verifyCurrencyByCountry() {
        String Country = getCountryName();
        String Currency = getCountryCurrency();

        if (Country.equals("KSA") && Currency.equals("SAR")) {
            return true;
        } else if (Country.equals("Kuwait") && Currency.equals("KWD")) {
            return true;
        } else if (Country.equals("Bahrain") && Currency.equals("BHD")) {
            return true;
        } else
            return false;

    }

    public boolean verifyPriceForLitePlan() {
        String Country = getCountryName();

        if (Country.equals("KSA")) {
            if (getPlanName(litePlan).equals("LITE") && getPlanPrice(liteCurrency).equals("15")) {
                return true;
            }
        } else if (Country.equals("Kuwait")) {
            if (getPlanName(litePlan).equals("LITE") && getPlanPrice(liteCurrency).equals("1.2")) {
                return true;
            }
        } else if (Country.equals("Bahrain")) {
            if (getPlanName(litePlan).equals("LITE") && getPlanPrice(liteCurrency).equals("2")) {
                return true;
            }
        }

        return false;
    }

    public boolean verifyPriceForClassicPlan() {
        String Country = getCountryName();

        if (Country.equals("KSA")) {
            if (getPlanName(classicPlan).equals("CLASSIC") && getPlanPrice(classicCurrency).equals("25")) {
                return true;
            }
        }

        if (Country.equals("Kuwait")) {
            if (getPlanName(classicPlan).equals("CLASSIC") && getPlanPrice(classicCurrency).equals("2.5")) {
                return true;
            }
        }

        if (Country.equals("Bahrain")) {
            if (getPlanName(classicPlan).equals("CLASSIC") && getPlanPrice(classicCurrency).equals("3")) {
                return true;
            }
        }

        return false;
    }

    public boolean verifyPriceForPremiumPlan() {
        String Country = getCountryName();

        if (Country.equals("KSA")) {
            if (getPlanName(premiumPlan).equals("PREMIUM") && getPlanPrice(premiumCurrency).equals("60")) {
                return true;
            }
        }

        if (Country.equals("Kuwait")) {
            if (getPlanName(premiumPlan).equals("PREMIUM") && getPlanPrice(premiumCurrency).equals("4.8")) {
                return true;
            }
        }

        if (Country.equals("Bahrain")) {
            if (getPlanName(premiumPlan).equals("PREMIUM") && getPlanPrice(premiumCurrency).equals("6")) {
                return true;
            }
        }

        return false;
    }

    public boolean verifyGiftCardSection() {
        String Country = getCountryName();

        switch (Country) {
            case "KSA":
                return giftCardSection.isDisplayed();

            case "Kuwait":
            case "Bahrain":
                return false;

            default:
                return false;
        }

    }

    public void updateCountry() {
        updateCountryButton.click();
    }

    public void chooseCountry(WebElement Country) {
        Country.click();
    }

    public boolean allPlansDisplayed() {
        if (litePlan.isDisplayed() && classicPlan.isDisplayed() && premiumPlan.isDisplayed()) {
            return true;
        } else
            return false;
    }

    public boolean updateCountryPopupDisplayed() {
        waitForElementToAppearWithFindElement(countrySelectForm);
        if (countrySelectForm.isDisplayed())
            return true;
        else
            return false;
    }


}
