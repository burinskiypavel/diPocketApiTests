package tests.uiTests.upandgo;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UpAndGoLoginVerificationFillPhoneFieldWithForbiddenCharactersTest extends UITestBase {

    @Test
    public void testLoginVerificationFillPhoneFieldWithForbiddenCharacters() {
        app.getUiUpAndGoHelper().gotoUpAndGoSiteAndDoneBasicAuth("playit-test.dipocket.org/en","dipocket", "LeprechauN");
        app.getUiUpAndGoHelper().gotoLoginPageUpAndGo();
        app.getUiUpAndGoHelper().type(By.id("phone_number"), "kkkA@#%*()");

        String phoneText = app.getUiUpAndGoHelper().getAttributeValue(By.id("phone_number"));
        assertThat(phoneText, equalTo(""));
    }
}