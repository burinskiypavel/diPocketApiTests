package tests.uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;

public class TelenorNewAndOldPINNegativeTests extends UITestBase {
    String expectedPhone = "38 063 608 3315"; //38 098 031 6499
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1)
    public void testNewPINsAreNotMatched() throws InterruptedException {
        String popupMessage = app.getUiTelenorHelper().navigateToTelenorAndLogin(app.telenorRegistrationPhone2, smsCode);
        app.getUiTelenorHelper().gotoManageSecurityPage();
        if(app.getUiTelenorHelper().isElementPresent(By.cssSelector("a[href='/en/security/unblock']"))) {
            app.getUiTelenorHelper().unblockPaymentBandTelenor("514-614-250", "QA");
        }
        app.getUiTelenorHelper().gotoChangePINPage();
        app.getUiTelenorHelper().type(By.id("pin_new"), "1234");
        app.getUiTelenorHelper().type(By.id("pin_confirm"), "1111");
        String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("pin_confirm"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
        assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
        assertThat(popupMessage, equalTo("Your one time password sent to "+expectedPhone+". If you didn't receive SMS in 2-3 minutes, please request password once again."));
    }

    @Test(priority = 2)
    public void testWrongOldPIN() throws InterruptedException {
        if(app.getUiTelenorHelper().isElementPresent(By.id("pin_new"))){
            app.getUiTelenorHelper().type(By.id("pin_new"), "1111");
            app.getUiTelenorHelper().type(By.id("pin_confirm"), "1234");
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("pin_confirm"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));
            assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
        }

        else {

            String popupMessage = app.getUiTelenorHelper().navigateToTelenorAndLogin(app.telenorRegistrationPhone2, smsCode);
            app.getUiTelenorHelper().gotoManageSecurityPage();
            if(app.getUiTelenorHelper().isElementPresent(By.cssSelector("a[href='/en/security/unblock']"))) {
                app.getUiTelenorHelper().unblockPaymentBandTelenor("514-614-250", "QA");
            }
            app.getUiTelenorHelper().gotoChangePINPage();
            app.getUiTelenorHelper().type(By.id("pin_new"), "1111");
            app.getUiTelenorHelper().type(By.id("pin_confirm"), "1234");
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("pin_confirm"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));
            assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
            assertThat(popupMessage, equalTo("Your one time password sent to "+expectedPhone+". If you didn't receive SMS in 2-3 minutes, please request password once again."));
        }
    }
}