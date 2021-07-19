package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorRegistrationVerificationWithIncopliteDataTest extends UITestBase {
    String token = "51388619";
    String phone = "44745";

    @Test(priority = 1)
    public void testRegistrationVerificationWithIncopliteData() throws InterruptedException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.id("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        String publicTokenBorderColor = getColorOfElement(By.id("publicToken"), "border-color");
        String mainPhoneBorderColor = getColorOfElement(By.id("mainPhone"), "border-color");

        assertThat(publicTokenBorderColor, equalTo(app.hexRedColor));
        assertThat(mainPhoneBorderColor, equalTo(app.hexRedColor));
    }
}
