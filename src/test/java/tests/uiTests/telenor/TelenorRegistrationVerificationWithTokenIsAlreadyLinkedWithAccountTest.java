package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorRegistrationVerificationWithTokenIsAlreadyLinkedWithAccountTest extends UITestBase {

    @Test
    public void testRegistrationVerificationWithTokenIsAlreadyLinkedWithAccount() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), "512-047-269");
        type(By.id("mainPhone"), "1111111111111");
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Card number is invalid. Please enter the correct card number"));
    }
}