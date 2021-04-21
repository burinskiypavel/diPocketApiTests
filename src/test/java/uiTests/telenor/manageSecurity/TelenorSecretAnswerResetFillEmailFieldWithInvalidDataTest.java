package uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorSecretAnswerResetFillEmailFieldWithInvalidDataTest extends UITestBase {
    String smsCode = app.generateRandomNumber(6);
    String invalidEmail = "testtest.com";

    @Test
    public void testSecretAnswerResetFillEmailFieldWithInvalidData() throws InterruptedException {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        gotoManageSecurityPage();
        gotoChangeSecretAnswer();
        gotoForgotSecretAnswer();
        type(By.id("email"), invalidEmail);
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-reset-request']"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));
        String hexColor = getColorOfElement(By.id("email"), "border-color");

        assertTrue(isPopUpClosed());
        assertThat(hexColor, equalTo(app.hexRedColor));
        assertThat(popUpMessage, equalTo("E-mail address " + invalidEmail + " is invalid"));
    }
}