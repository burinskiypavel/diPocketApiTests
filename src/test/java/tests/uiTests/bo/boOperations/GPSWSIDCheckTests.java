package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GPSWSIDCheckTests extends UITestBase {

    @Test//bug DEV-3246
    public void testGPSWSIDCheck() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoGPSWSIDCheckTab();
        app.getUiboHelper().type(By.cssSelector("app-gps-wsid-check-tap p-inputnumber input"), "20669371");
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Check']"));
    }
}