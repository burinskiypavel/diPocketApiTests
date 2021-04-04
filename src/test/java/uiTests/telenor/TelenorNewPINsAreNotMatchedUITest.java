package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;

public class TelenorNewPINsAreNotMatchedUITest extends UITestBase {
    String phone = "380636083315";
    String expectedPhone = "38 063 608 3315"; //38 098 031 6499
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1)
    public void testNewPINsAreNotMatched() throws InterruptedException {
        String popupMessage = navigateToTelenorAndLogin(phone, smsCode);
        gotoManageSecurityPage();
        gotoChangePINPage();
        type(By.id("pin_new"), "1234");
        type(By.id("pin_confirm"), "1111");
        String hexColor = getColorOfElement(By.id("pin_confirm"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
        assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
        assertThat(popupMessage, equalTo("Your one time password sent to "+expectedPhone+". If you didn't receive SMS in 2-3 minutes, please request password once again."));
    }

    @Test(priority = 2)
    public void testWrongOldPIN() throws InterruptedException {
        if(isElementPresent(By.id("pin_new"))){
            type(By.id("pin_new"), "1111");
            type(By.id("pin_confirm"), "1234");
            String hexColor = getColorOfElement(By.id("pin_confirm"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));
            assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
        }
        else {

            String popupMessage = navigateToTelenorAndLogin(phone, smsCode);
            gotoManageSecurityPage();
            gotoChangePINPage();
            type(By.id("pin_new"), "1111");
            type(By.id("pin_confirm"), "1234");
            String hexColor = getColorOfElement(By.id("pin_confirm"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));
            assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
            assertThat(popupMessage, equalTo("Your one time password sent to "+expectedPhone+". If you didn't receive SMS in 2-3 minutes, please request password once again."));
        }
    }
}
