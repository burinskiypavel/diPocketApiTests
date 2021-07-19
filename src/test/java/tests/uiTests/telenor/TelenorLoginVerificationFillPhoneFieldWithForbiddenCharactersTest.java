package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorLoginVerificationFillPhoneFieldWithForbiddenCharactersTest extends UITestBase {

    @Test
    public void testLoginVerificationFillPhoneFieldWithForbiddenCharacters() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoLoginPage();
        type(By.id("phone_number"), "kkkA@#%*()");

        String phoneText = getAttributeValue(By.id("phone_number"));
        assertThat(phoneText, equalTo(""));
    }
}
