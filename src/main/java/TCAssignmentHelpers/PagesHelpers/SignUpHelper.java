package TCAssignmentHelpers.PagesHelpers;

import TCAssignmentHelpers.SharedElements.SharedElementsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpHelper extends SharedElementsHelper {

    WebDriver driver;

    public SignUpHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "signin")
    WebElement goToSignUpButton;

    @FindBy(css = "input[class='signup-form__input']")
    WebElement loginTextField;

    @FindBy(css = "button[class='form-btn']")
    WebElement signInButton;

    @FindBy(css = "span[class='error-msg-top']")
    WebElement emailNotExistError;

    @FindBy(css = "span[class='error-msg']")
    WebElement invalidUserError;

    By loadingSpinners = By.cssSelector("svg[class='spinner']");

    public void goToSignUpPage() {
        waitForElementToAppearWithFindElement(goToSignUpButton);
        goToSignUpButton.click();
    }

    public void waitForLoadingSpinnerToDisappear() {
        waitForElementToDisappear(loadingSpinners);
    }

    public void addEmailAndSignIn(String email) {
        waitForElementToAppearWithFindElement(loginTextField);
        loginTextField.sendKeys(email);
        signInButton.click();
    }

    public boolean emailNotExistError() {
        return emailNotExistError.isDisplayed();
    }

    public boolean emailFormatNotCorrectError() {
        return invalidUserError.isDisplayed();
    }


}
