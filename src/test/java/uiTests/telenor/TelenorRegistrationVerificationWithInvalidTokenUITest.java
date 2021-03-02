package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorRegistrationVerificationWithInvalidTokenUITest extends UITestBase {
    String token = "111111111";
    String phone = "447459005207";

    @Test(priority = 1)
    public void testRegistrationVerificationWithInvalidToken() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        String popUpMessage = getTextFromPopUp();
        closePopUp();

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Card number is invalid. Please enter the correct card number"));
    }
}
