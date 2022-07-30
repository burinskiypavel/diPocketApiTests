package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorLoginVerificationWithInvalidDataInOneTimePasswordFieldTest extends UITestBase {

    @Test
    public void testLoginVerificationWithInvalidDataInOneTimePasswordField() {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoLoginPage();
        app.getUiTelenorHelper().type(By.id("phone_number"), app.telenorLoginPhone);
        app.getUiTelenorHelper().click(By.cssSelector("button.request-otp"));
        app.getUiTelenorHelper().closePopUp(By.cssSelector("div.uk-text-right button.uk-modal-close"));
        app.getUiTelenorHelper().type(By.id("password"), "123456");
        app.getUiTelenorHelper().click(By.id("dpwa-login"));
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(app.getUiTelenorHelper().isPopUpClosed());
        assertThat(popUpMessage,equalTo("Login or password is incorrect"));
    }
}