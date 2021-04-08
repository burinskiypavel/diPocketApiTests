package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorRegistrationVerificationWithInvalidTokenTest extends UITestBase {

    @Test
    public void testRegistrationVerificationWithInvalidToken() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), "111111111");
        type(By.id("mainPhone"), "447459005207");
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Card number is invalid. Please enter the correct card number"));
    }
}