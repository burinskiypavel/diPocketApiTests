package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorNegativeVerificationFullRegistrationPageTests extends UITestBase {
    String phone = "380684764228";
    String smsCode = app.generateRandomNumber(6);

    @Test(priority = 1, enabled = false)
    public void testVerificationWithInvalidDataYourTemporarySecretAnswerField() throws SQLException, ClassNotFoundException, InterruptedException {
            //app.getDbHelper().blockClientFromDBTelenor(phone);
            //app.getDbHelper().activateClientFromDBTelenor(phone);
            //app.getDbHelper().unblockClientFromBOFromDBTelenor();
            navigateToTelenorAndLogin2(phone, smsCode);
            gotoFullRegistrationPage();
            click(By.cssSelector("button[data-dpwa-image-id='selfie-neutral']"));
            waitForSeveralItems(new String[]{"Confirmation", "To proceed, please answer your secret question (case sensitive)", "Forgot secret answer", "Cancel", "Confirm"});
            type(By.id("secAnswer"), "la");
            pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
            waitForSeveralItems(new String[]{"Sorry, wrong answer - please, pay attention (the secret answer is case sensitive)"});
            String popUpMessage = getTextFromPopUp2(By.cssSelector("div.uk-form-row div.uk-h4"));

            assertThat(popUpMessage, equalTo("Sorry, wrong answer - please, pay attention (the secret answer is case sensitive)"));
    }

    @Test(priority = 2)
    public void testVerificationWithEmptyYourTemporarySecretAnswerField() throws InterruptedException, SQLException, ClassNotFoundException {
            //app.getDbHelper().blockClientFromDBTelenor(phone);
            app.getDbHelper().activateClientFromDBTelenor(phone);
            navigateToTelenorAndLogin2(phone, smsCode);
            gotoFullRegistrationPage();
            click(By.cssSelector("button[data-dpwa-image-id='selfie-neutral']"));
            waitForSeveralItems(new String[]{"Confirmation", "To proceed, please answer your secret question (case sensitive)", "Forgot secret answer", "Cancel", "Confirm"});
            type(By.id("secAnswer"), "");
            pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
            String hexColor = getColorOfElement(By.id("secAnswer"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));
        }
}