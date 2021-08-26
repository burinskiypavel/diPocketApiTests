package tests.uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorSecretAnswerResetFillSecretAnswerFieldWithInvalidDataTest extends UITestBase {
    String smsCode = app.generateRandomNumber(6);
    String phone = "380684764228";

    @Test
    public void testSecretAnswerResetFillSecretAnswerFieldWithInvalidData() throws SQLException, ClassNotFoundException, InterruptedException {
        app.getDbHelper().blockClientFromDBTelenor(phone);
        app.getDbHelper().unblockClientFromBOFromDBTelenor("31751");
        navigateToTelenorAndLogin2(phone, smsCode);
        gotoManageSecurityPage();
        gotoChangeSecretAnswer();
        gotoForgotSecretAnswer();
        type(By.id("email"), "dipockettest2@gmail.com");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-reset-request']"));
        waitForSeveralItems(new String[]{"Back", "Reset"});
        waitFor(By.id("secAnswer"));
        type(By.id("secAnswer"), "111111");
        click(By.cssSelector("button[data-dpwa-action='sa-reset-confirm']"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Sorry, wrong answer - please, pay attention (the secret answer is case sensitive)"));
    }
}