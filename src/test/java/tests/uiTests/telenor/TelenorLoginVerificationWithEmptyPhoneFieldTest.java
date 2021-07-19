package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorLoginVerificationWithEmptyPhoneFieldTest extends UITestBase {

    @Test(priority = 1)
    public void testLoginVerificationWithEmptyPhoneField() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoLoginPage();
        type(By.id("phone_number"), "");
        click(By.cssSelector("button.request-otp"));
        String popUpMessage = getTextFromPopUp2(By.cssSelector("div.uk-margin"));
        closePopUp2(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed3(By.cssSelector("div.uk-margin")));
        assertThat(popUpMessage, equalTo("Phone number cannot be empty"));
    }
}
