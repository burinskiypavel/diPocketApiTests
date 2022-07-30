package tests.uiTests.telenor;

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

    @Test
    public void testRegistrationVerifyPhoneFieldWithAlreadyUsedData() {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoRegisterPaymentBandPage();
        app.getUiTelenorHelper().type(By.name("publicToken"), token);
        app.getUiTelenorHelper().type(By.id("mainPhone"), phone);
        app.getUiTelenorHelper().clickCheckbox(By.id("agreeProcessInfo"));
        app.getUiTelenorHelper().submitPublicTokenAndPhone();
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        app.getUiTelenorHelper().closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertTrue(app.getUiTelenorHelper().isPopUpClosedRedirection("dpwa-alert"));
        app.getUiTelenorHelper().checkThatAfterRedirectionPhoneNumberDisplayedInPhoneField(expectedPhone);
        assertThat(popUpMessage, equalTo("We are redirecting you to LOGIN as you are already registered"));
    }
}