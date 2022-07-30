package tests.uiTests.telenor.manageSecurity;

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
        app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        app.getUiTelenorHelper().gotoManageSecurityPage();
        app.getUiTelenorHelper().gotoChangeSecretAnswer();
        app.getUiTelenorHelper().gotoForgotSecretAnswer();
        app.getUiTelenorHelper().type(By.id("email"), invalidEmail);
        app.getUiTelenorHelper().pressConfirm(By.cssSelector("button[data-dpwa-action='sa-reset-request']"));
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));
        String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("email"), "border-color");

        assertTrue(app.getUiTelenorHelper().isPopUpClosed());
        assertThat(hexColor, equalTo(app.hexRedColor));
        assertThat(popUpMessage, equalTo("E-mail address " + invalidEmail + " is invalid"));
    }
}