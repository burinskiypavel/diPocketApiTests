package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TelenorRegistrationVerificationUntickedCheckboxForPersonalInformationProcessingTest extends UITestBase {
    String token = "515161232";
    String phone = "380502128465";

    @Test
    public void testUntickedCheckboxForPersonalInformationProcessing() throws InterruptedException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        submitPublicTokenAndPhone();

        checkThatUntickedCheckboxHasRedColor(By.cssSelector("label.uk-margin-small-bottom[style='cursor: pointer; color: red;']"));
    }
}