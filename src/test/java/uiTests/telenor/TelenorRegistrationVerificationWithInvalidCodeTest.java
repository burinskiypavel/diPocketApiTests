package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorRegistrationVerificationWithInvalidCodeTest extends UITestBase {
    String token = "515161232";
    String phone = "380502128465";
    String smsCode = "000000";

    @Test
    public void testRegistrationVerificationWithInvalidCode() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        fillSmsCode(smsCode);
        submitSmsCode();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertThat(popUpMessage, equalTo("Entered verification code is incorrect. Please, try again"));
    }
}