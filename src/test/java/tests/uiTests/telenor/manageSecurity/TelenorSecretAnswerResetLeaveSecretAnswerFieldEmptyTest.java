package tests.uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorSecretAnswerResetLeaveSecretAnswerFieldEmptyTest extends UITestBase {
    String smsCode = app.generateRandomNumber(6);

    @Test
    public void testSecretAnswerResetLeaveSecretAnswerFieldEmpty() throws InterruptedException {
        navigateToTelenorAndLogin2(app.telenorLoginPhone, smsCode);
        gotoManageSecurityPage();
        gotoChangeSecretAnswer();
        gotoForgotSecretAnswer();
        type(By.id("email"), "assetspb@gmail.com");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-reset-request']"));
        waitForSeveralItems(new String[]{"Back", "Reset"});
        waitFor(By.id("secAnswer"));
        type(By.id("secAnswer"), "");
        click(By.cssSelector("button[data-dpwa-action='sa-reset-confirm']"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));
        waitFor(By.id("email"));
        waitForSeveralItems2(new String[]{"button[data-dpwa-action='sa-reset-request']", "a[href='javascript:history.back()']"});

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("You entered invalid value. Please correct and try again"));
    }
}