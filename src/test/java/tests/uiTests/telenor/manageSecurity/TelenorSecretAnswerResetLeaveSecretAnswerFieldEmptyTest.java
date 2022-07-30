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
        app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorLoginPhone, smsCode);
        app.getUiTelenorHelper().gotoManageSecurityPage();
        app.getUiTelenorHelper().gotoChangeSecretAnswer();
        app.getUiTelenorHelper().gotoForgotSecretAnswer();
        app.getUiTelenorHelper().type(By.id("email"), "assetspb@gmail.com");
        app.getUiTelenorHelper().pressConfirm(By.cssSelector("button[data-dpwa-action='sa-reset-request']"));
        app.getUiTelenorHelper().waitForSeveralItems(new String[]{"Back", "Reset"});
        app.getUiTelenorHelper().waitFor(By.id("secAnswer"));
        app.getUiTelenorHelper().type(By.id("secAnswer"), "");
        app.getUiTelenorHelper().click(By.cssSelector("button[data-dpwa-action='sa-reset-confirm']"));
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));
        app.getUiTelenorHelper().waitFor(By.id("email"));
        app.getUiTelenorHelper().waitForSeveralItems2(new String[]{"button[data-dpwa-action='sa-reset-request']", "a[href='javascript:history.back()']"});

        assertTrue(app.getUiTelenorHelper().isPopUpClosed());
        assertThat(popUpMessage, equalTo("You entered invalid value. Please correct and try again"));
    }
}