package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorRegistrationVerificationWithInvalidPhoneTest extends UITestBase {
    String token = "514826821";
    String phone = "000000000000";

    @Test
    public void testRegistrationVerificationWithInvalidPhone() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Sorry but a mobile phone number should be from a EEA country, Canada, Switzerland or the USA"));
    }
}
