package uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

public class UnblockPaymentBandWithIncompleteDataTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1)
    public void testUnblockPaymentBandWithIncompleteData() {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        gotoManageSecurityPage();
        if(isElementPresent(By.cssSelector("a[href='/en/security/block']"))){
            click(By.cssSelector("a[href='/en/security/block']"));
            waitForSeveralItems(new String[]{"Confirm", "Cancel"});
            click(By.cssSelector("button[data-dpwa-action='band-block-confirm']"));
            type(By.id("secAnswer"), "QA");
            click(By.cssSelector("button[data-dpwa-action='sa-send']"));

            //gotoManageSecurityPage();
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/en/security/unblock']")));
            click(By.cssSelector("a[href='/en/security/unblock']"));
            waitForSeveralItems(new String[]{"Card number", "Cancel", "Unblock"});
            type(By.id("publicToken"), "12345678");

            assertFalse(isButtonEnabled(By.xpath("//button[@data-dpwa-action='unblock-card']")));

        } else {

            click(By.cssSelector("a[href='/en/security/unblock']"));
            waitForSeveralItems(new String[]{"Card number", "Cancel", "Unblock"});
            type(By.id("publicToken"), "12345678");

            assertFalse(isButtonEnabled(By.xpath("//button[@data-dpwa-action='unblock-card']")));
        }
    }
}