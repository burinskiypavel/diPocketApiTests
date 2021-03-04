package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TelenorRegistrationVerificationWithUntickedCheckboxForProcessingOfThePersonalInformationTest extends UITestBase {

    @Test(priority = 1)
    public void testRegistrationVerificationWithUntickedCheckboxForProcessingOfThePersonalInformation() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), "513886198");
        type(By.id("mainPhone"), "447459005206");
        submitPublicTokenAndPhone();

        assertTrue(isElementHasRedColor(By.cssSelector("label[style*='color: red;']")));
    }
}
