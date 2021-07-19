package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorLoginVerificationPhoneFieldWithNotRegisteredPhoneTest extends UITestBase {
    String phone = "111111111111";
    String expectedPhone = "11 111 111 1111";

    @Test
    public void testLoginVerificationPhoneFieldWithNotRegisteredPhone() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoLoginPage();
        type(By.id("phone_number"), phone);
        click(By.cssSelector("button.request-otp"));
        String popUpMessage = getTextFromPopUp2(By.id("register-prompt-message"));
        closePopUp(By.cssSelector("#register-prompt button.uk-modal-close"));

        assertTrue(isPopUpClosed2("register-prompt"));
        assertThat(popUpMessage, equalTo("Phone# "+expectedPhone+" isn’t registered, do you want to?"));
    }
}
