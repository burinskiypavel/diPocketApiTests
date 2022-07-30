package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TelenorRegistrationVerificationUntickedCheckboxForPersonalInformationProcessingTest extends UITestBase {
    String token = "515161232";
    String phone = "380502128465";

    @Test
    public void testUntickedCheckboxForPersonalInformationProcessing() throws InterruptedException {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoRegisterPaymentBandPage();
        app.getUiTelenorHelper().type(By.name("publicToken"), token);
        app.getUiTelenorHelper().type(By.id("mainPhone"), phone);
        app.getUiTelenorHelper().submitPublicTokenAndPhone();

        app.getUiTelenorHelper().checkThatUntickedCheckboxHasRedColor(By.cssSelector("label.uk-margin-small-bottom[style='cursor: pointer; color: red;']"));
    }
}