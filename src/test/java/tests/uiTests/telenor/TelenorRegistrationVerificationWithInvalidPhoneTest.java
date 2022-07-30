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
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoRegisterPaymentBandPage();
        app.getUiTelenorHelper().type(By.name("publicToken"), token);
        app.getUiTelenorHelper().type(By.id("mainPhone"), phone);
        app.getUiTelenorHelper().clickCheckbox(By.id("agreeProcessInfo"));
        app.getUiTelenorHelper().submitPublicTokenAndPhone();
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        app.getUiTelenorHelper().closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertTrue(app.getUiTelenorHelper().isPopUpClosed());
        assertThat(popUpMessage, equalTo("Sorry but a mobile phone number should be from a EEA country, Canada, Switzerland or the USA"));
    }
}