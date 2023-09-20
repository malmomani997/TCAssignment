package TCAssignmentHelpers.PagesHelpers;

import TCAssignmentHelpers.SharedElements.SharedElementsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPageHelper extends SharedElementsHelper {

    WebDriver driver;

    public CheckoutPageHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public @FindBy(id = "lite-selection")
    WebElement checkoutWithLitePlan;

    public @FindBy(id = "classic-selection")
    WebElement checkoutWithClassicPlan;

    public @FindBy(id = "premium-selection")
    WebElement checkoutWithPremiumPlan;

    @FindBy(id = "order-tier-price")
    WebElement priceOfPlanInCheckoutPage;

    @FindBy(id = "btnChoosePaymentMethod")
    WebElement confirmPaymentMethodButton;

    @FindBy(css = "div[class='check-ico']")
    List<WebElement> addOnCheckbox;

    @FindBy(id = "btnChooseAddons")
    WebElement confirmAddonsButton;

    @FindBy(css = "div[class='option-group']")
    WebElement addonsForm;

    @FindBy(css = "input[maxlength='11']")
    WebElement phoneNumberField;

    @FindBy(css = "div[class='two-cols']")
    WebElement placeOrderForm;

    @FindBy(id = "btnFinalStepSubscribe")
    WebElement confirmSubButton;

    public String getPriceOfPlanWithoutFractional() {
        String price = priceOfPlanInCheckoutPage.getText().split(" ")[0].trim();
        Double price1 = Double.parseDouble(price);
        price = price1.toString();
        return price.split("\\.")[0];
    }

    public String getPriceOfPlanWithFractional() {
        String price = priceOfPlanInCheckoutPage.getText().split(" ")[0].trim();
        Double price1 = Double.parseDouble(price);
        price = price1.toString();
        return price;
    }

    public void chooseAddOn(int addOnNumber) {
        addOnCheckbox.get(addOnNumber).click();
    }

    public void checkoutPlan(WebElement planType) {
        planType.click();
    }

    public void confirmPaymentButton() {
        confirmPaymentMethodButton.click();
    }

    public void confirmAddonsButton() {
        confirmAddonsButton.click();
    }

    public boolean addonsFormDisplayed() {
        return addonsForm.isDisplayed();
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public boolean placeOrderFormDisplayed() {
        return placeOrderForm.isDisplayed();
    }

    public void confirmSubscriptionButton() {
        scrollBy(800);
        waitForElementToAppearWithFindElement(footerSection);
        waitForElementToAppearWithFindElement(confirmSubButton);
        confirmSubButton.click();
    }

}
