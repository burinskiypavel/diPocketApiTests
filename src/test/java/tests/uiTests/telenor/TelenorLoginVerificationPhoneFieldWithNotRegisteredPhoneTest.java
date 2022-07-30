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
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoLoginPage();
        app.getUiTelenorHelper().type(By.id("phone_number"), phone);
        app.getUiTelenorHelper().click(By.cssSelector("button.request-otp"));
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp2(By.id("register-prompt-message"));
        app.getUiTelenorHelper().closePopUp(By.cssSelector("#register-prompt button.uk-modal-close"));

        assertTrue(app.getUiTelenorHelper().isPopUpClosed2("register-prompt"));
        assertThat(popUpMessage, equalTo("Phone# "+expectedPhone+" isn’t registered, do you want to?"));
    }
}