package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorRegistrationVerificationWithInvalidTokenTest extends UITestBase {

    @Test
    public void testRegistrationVerificationWithInvalidToken() {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoRegisterPaymentBandPage();
        app.getUiTelenorHelper().type(By.name("publicToken"), "111111111");
        app.getUiTelenorHelper().type(By.id("mainPhone"), "447459005207");
        app.getUiTelenorHelper().clickCheckbox(By.id("agreeProcessInfo"));
        app.getUiTelenorHelper().submitPublicTokenAndPhone();
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        app.getUiTelenorHelper().closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertTrue(app.getUiTelenorHelper().isPopUpClosed());
        assertThat(popUpMessage, equalTo("Card number is invalid. Please enter the correct card number"));
    }
}