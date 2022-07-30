package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TelenorRegistrationVerificationWithUntickedCheckboxForProcessingOfThePersonalInformationTest extends UITestBase {

    @Test(priority = 1)
    public void testRegistrationVerificationWithUntickedCheckboxForProcessingOfThePersonalInformation() {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().gotoRegisterPaymentBandPage();
        app.getUiTelenorHelper().type(By.name("publicToken"), "513886198");
        app.getUiTelenorHelper().type(By.id("mainPhone"), "447459005206");
        app.getUiTelenorHelper().submitPublicTokenAndPhone();

        assertTrue(app.getUiTelenorHelper().isElementHasRedColor(By.cssSelector("label[style*='color: red;']")));
    }
}