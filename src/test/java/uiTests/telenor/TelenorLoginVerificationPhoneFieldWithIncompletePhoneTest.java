package uiTests.telenor;

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
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoLoginPage();
        type(By.id("phone_number"), phone);
        click(By.cssSelector("button.request-otp"));
        String popUpMessage = getTextFromPopUp2(By.cssSelector("div.uk-margin"));
        closePopUp2(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed3(By.cssSelector("div.uk-margin")));
        assertThat(popUpMessage, equalTo("The phone number you entered seems invalid. Please check again"));
    }
}
