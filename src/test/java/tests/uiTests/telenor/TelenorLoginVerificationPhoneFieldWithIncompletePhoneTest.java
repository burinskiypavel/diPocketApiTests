package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorLoginVerificationPhoneFieldWithIncompletePhoneTest extends UITestBase {
    String phone = "3806344";

    @Test
    public void testLoginVerificationPhoneFieldWithIncompletePhone() {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoLoginPage();
        app.getUiTelenorHelper().type(By.id("phone_number"), phone);
        app.getUiTelenorHelper().click(By.cssSelector("button.request-otp"));
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp2(By.cssSelector("div.uk-margin"));
        app.getUiTelenorHelper().closePopUpFromMultiple(By.xpath("//button[contains(text(), 'Ok')]"), 1);

        assertTrue(app.getUiTelenorHelper().isPopUpClosed3(By.cssSelector("div.uk-margin")));
        assertThat(popUpMessage, equalTo("The phone number you entered seems invalid. Please check again"));
    }
}