package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorRegistrationVerifyPhoneFieldWithAlreadyUsedDataTest extends UITestBase {
    String token = "513886198";
    String phone = "380661470959";
    String expectedPhone = "38 066 147 0959";

    @Test(priority = 1)
    public void testRegistrationVerifyPhoneFieldWithAlreadyUsedData() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        String popUpMessage = getTextFromPopUp();
        closePopUp();

        assertTrue(isPopUpClosed2());
        checkThatAfterRedirectionPhoneNumberDisplayedInPhoneField(expectedPhone);
        assertThat(popUpMessage, equalTo("We are redirecting you to LOGIN as you are already registered"));
    }
}
