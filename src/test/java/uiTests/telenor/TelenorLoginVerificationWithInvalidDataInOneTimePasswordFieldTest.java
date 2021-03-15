package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorLoginVerificationWithInvalidDataInOneTimePasswordFieldTest extends UITestBase {

    @Test
    public void testLoginVerificationWithInvalidDataInOneTimePasswordField() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoLoginPage();
        type(By.id("phone_number"), app.telenorLoginPhone);
        click(By.cssSelector("button.request-otp"));
        closePopUp(By.cssSelector("div.uk-text-right button.uk-modal-close"));
        type(By.id("password"), "123456");
        click(By.id("dpwa-login"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage,equalTo("Login or password is incorrect"));
    }
}
