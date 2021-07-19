package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorLoginVerificationWithEmptyOneTimePasswordFieldTest extends UITestBase {

    @Test
    public void testLoginVerificationWithEmptyOneTimePasswordField() throws InterruptedException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoLoginPage();
        type(By.id("phone_number"), app.telenorLoginPhone);
        click(By.cssSelector("button.request-otp"));
        closePopUp(By.cssSelector("div.uk-text-right button.uk-modal-close"));
        click(By.id("dpwa-login"));
        String oneTimePasswordBorderColor = getColorOfElement(By.id("password"), "border-color");

        assertThat(oneTimePasswordBorderColor,equalTo(app.hexRedColor));
    }
}
