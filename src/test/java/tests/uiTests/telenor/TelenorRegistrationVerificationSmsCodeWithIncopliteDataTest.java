package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;

public class TelenorRegistrationVerificationSmsCodeWithIncopliteDataTest extends UITestBase {
    String token = "514826821";
    String phone = "380502128466";
    String smsCode = "12345";

    @Test(enabled = false)
    public void testRegistrationVerificationSmsCodeWithIncopliteData() {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoRegisterPaymentBandPage();
        app.getUiTelenorHelper().type(By.name("publicToken"), token);
        app.getUiTelenorHelper().type(By.id("mainPhone"), phone);
        app.getUiTelenorHelper().clickCheckbox(By.id("agreeProcessInfo"));
        app.getUiTelenorHelper().submitPublicTokenAndPhone();
        app.getUiTelenorHelper().fillSmsCode(smsCode);
        app.getUiTelenorHelper().submitSmsCode();

        assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.cssSelector("button[data-dpwa-action='register-verify-code']")));
    }
}