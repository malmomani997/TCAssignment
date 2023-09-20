package TCAssignmentScenarios.PagesScenarios;

import TCAssignmentHelpers.Resources.TestData;
import TCAssignmentScenarios.TestHelpers.BaseTest;
import TCAssignmentScenarios.TestHelpers.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignUpTests extends BaseTest {

    /*
    In the following two tests we are trying to validate not being able to login with a non existed user and
    Also trying to log in with an email with a wrong format
     */

    @Test()
    public void signUpWithNonExistedUser() {
        goToSignUpPage();
        SignUp.addEmailAndSignIn(TestData.nonExistedEmail);
        Assert.assertTrue(SignUp.emailNotExistError(), "Error Message Wasn't Displayed");
    }

    @Test(groups = {"Smoke"})
    public void signUpWithInvalidUser() {
        goToSignUpPage();
        SignUp.addEmailAndSignIn(TestData.invalidEmail);
        Assert.assertTrue(SignUp.emailFormatNotCorrectError(), "Error Message Wasn't Displayed");
    }


    public void goToSignUpPage() {
        SignUp.goToSignUpPage();
        SignUp.waitForLoadingSpinnerToDisappear();
    }

}