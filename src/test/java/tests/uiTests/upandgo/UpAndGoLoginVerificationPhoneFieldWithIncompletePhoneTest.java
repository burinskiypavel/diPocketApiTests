package tests.uiTests.upandgo;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class UpAndGoLoginVerificationPhoneFieldWithIncompletePhoneTest extends UITestBase {
    String phone = "3806344";
    String hexRedColor = "#ff0000";

    @Test
    public void testLoginVerificationPhoneFieldWithIncompletePhoneWithEmptyPassword() throws InterruptedException {
        gotoUpAndGoSiteAndDoneBasicAuth("playit-test.dipocket.org/en","dipocket", "LeprechauN");
        gotoLoginPageUpAndGo();
        type(By.id("phone_number"), phone);
        String hexColor = getColorOfElement(By.id("phone_number"), "border-color");

        assertThat(hexColor, equalTo(hexRedColor));
        assertFalse(isButtonEnabled(By.id("dpwa-login")));
    }

    @Test
    public void testLoginVerificationPhoneFieldWithIncompletePhoneWithPassword() throws InterruptedException {
        gotoUpAndGoSiteAndDoneBasicAuth("playit-test.dipocket.org/en","dipocket", "LeprechauN");
        gotoLoginPageUpAndGo();
        type(By.id("phone_number"), phone);
        type(By.id("key"), "12345qw");
        String hexColor = getColorOfElement(By.id("phone_number"), "border-color");

        assertThat(hexColor, equalTo(hexRedColor));
        assertFalse(isButtonEnabled(By.id("dpwa-login")));
    }
}
