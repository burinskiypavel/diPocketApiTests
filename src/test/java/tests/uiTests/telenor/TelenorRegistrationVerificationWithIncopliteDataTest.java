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
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoRegisterPaymentBandPage();
        app.getUiTelenorHelper().type(By.id("publicToken"), token);
        app.getUiTelenorHelper().type(By.id("mainPhone"), phone);
        app.getUiTelenorHelper().clickCheckbox(By.id("agreeProcessInfo"));
        app.getUiTelenorHelper().submitPublicTokenAndPhone();
        String publicTokenBorderColor = app.getUiTelenorHelper().getColorOfElement(By.id("publicToken"), "border-color");
        String mainPhoneBorderColor = app.getUiTelenorHelper().getColorOfElement(By.id("mainPhone"), "border-color");

        assertThat(publicTokenBorderColor, equalTo(app.hexRedColor));
        assertThat(mainPhoneBorderColor, equalTo(app.hexRedColor));
    }
}