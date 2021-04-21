package uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorSecretAnswerResetLeaveEmailFieldEmptyTest extends UITestBase {
    String smsCode = app.generateRandomNumber(6);

    @Test
    public void testSecretAnswerResetLeaveEmailFieldEmpty() {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        gotoManageSecurityPage();
        gotoChangeSecretAnswer();
        gotoForgotSecretAnswer();
        type(By.id("email"), "");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-reset-request']"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("E-mail address is invalid"));
    }
}