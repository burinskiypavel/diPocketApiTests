package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;

public class TelenorRegistrationVerificationSmsCodeWithIncopliteDataTest extends UITestBase {
    String token = "514826821";
    String phone = "380502128466";
    String smsCode = "12345";

    @Test(enabled = false)
    public void testRegistrationVerificationSmsCodeWithIncopliteData() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        fillSmsCode(smsCode);
        submitSmsCode();

        assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='register-verify-code']")));
    }
}