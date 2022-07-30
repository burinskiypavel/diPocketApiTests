package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorLoginVerificationWithEmptyOneTimePasswordFieldTest extends UITestBase {

    @Test
    public void testLoginVerificationWithEmptyOneTimePasswordField() throws InterruptedException {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoLoginPage();
        app.getUiTelenorHelper().type(By.id("phone_number"), app.telenorLoginPhone);
        app.getUiTelenorHelper().click(By.cssSelector("button.request-otp"));
        app.getUiTelenorHelper().closePopUp(By.cssSelector("div.uk-text-right button.uk-modal-close"));
        app.getUiTelenorHelper().click(By.id("dpwa-login"));
        String oneTimePasswordBorderColor = app.getUiTelenorHelper().getColorOfElement(By.id("password"), "border-color");

        assertThat(oneTimePasswordBorderColor,equalTo(app.hexRedColor));
    }
}