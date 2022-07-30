package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorLoginVerificationFillPhoneFieldWithForbiddenCharactersTest extends UITestBase {

    @Test
    public void testLoginVerificationFillPhoneFieldWithForbiddenCharacters() {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoLoginPage();
        app.getUiTelenorHelper().type(By.id("phone_number"), "kkkA@#%*()");

        String phoneText = app.getUiTelenorHelper().getAttributeValue(By.id("phone_number"));
        assertThat(phoneText, equalTo(""));
    }
}