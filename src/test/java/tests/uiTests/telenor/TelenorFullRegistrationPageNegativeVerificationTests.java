package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorFullRegistrationPageNegativeVerificationTests extends UITestBase {
    String phone = "380684764228";
    String smsCode = app.generateRandomNumber(6);
    String wrongSmsCode = "111111";

    @Test(priority = 0, enabled = false)
    public void testVerificationWithInvalidDataYourTemporarySecretAnswerField2() throws SQLException, ClassNotFoundException, InterruptedException {
        //app.getDbHelper().blockClientFromBOFromDBTelenor("31751");

        int stateID =  app.getDbHelper().getClientStateIDFromDBTelenor(phone, "TELENOR");
        if(stateID == 1){
            app.getDbHelper().blockClientFromDBTelenor(phone);
        }

        //app.getDbHelper().blockClientFromDBTelenor(phone);


        app.getDbHelper().unblockClientFromBOFromDBTelenor("31751");

        navigateToTelenorAndDone2IncorrectLoginAndThenSuccessfulLogin(phone, wrongSmsCode, smsCode);
        gotoFullRegistrationPage();
        click(By.cssSelector("button[data-dpwa-image-id='selfie-neutral']"));
        Thread.sleep(3500);
        //waitForSeveralItems(new String[]{"Confirmation", "To proceed, please answer your secret question (case sensitive)", "Forgot secret answer", "Cancel", "Confirm"});
        type(By.id("secAnswer"), "la");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
        Thread.sleep(3500);
        //waitForSeveralItems(new String[]{"Sorry, wrong answer - please, pay attention (the secret answer is case sensitive)"});
        String popUpMessage = getTextFromPopUp2(By.cssSelector("div.uk-form-row div.uk-h4"));

        assertThat(popUpMessage, equalTo("Sorry, wrong answer - please, pay attention (the secret answer is case sensitive)"));

        type(By.id("secAnswer"), "lala");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
        waitForSeveralItems(new String[]{"Sorry, wrong answer - please, pay attention, next wrong input will block your account"});
        String popUpMessage2 = getTextFromPopUp2(By.cssSelector("div.uk-form-row div.uk-h4"));

        assertThat(popUpMessage2, equalTo("Sorry, wrong answer - please, pay attention, next wrong input will block your account"));

        type(By.id("secAnswer"), "lalala");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
        waitForSeveralItems(new String[]{"Your account is blocked.", "Please, contact our call-center and stay in an area with good data connection - WiFi or 3G or higher.", "Data charges from your phone operator may apply when using mobile data"});
    }

    @Test(priority = 1, enabled = false)
    public void testVerificationWithInvalidDataYourTemporarySecretAnswerField() throws SQLException, ClassNotFoundException, InterruptedException {
        app.getDbHelper().blockClientFromBOFromDBTelenor("31751");
//        int stateID =  app.getDbHelper().getClientStateIDFromDBTelenor(phone, "TELENOR");
//        if(stateID == 1){
//            app.getDbHelper().blockClientFromDBTelenor(phone);
//        }

        //app.getDbHelper().blockClientFromDBTelenor(phone);
        app.getDbHelper().unblockClientFromBOFromDBTelenor("31751");
        navigateToTelenorAndLogin2(phone, smsCode);
        gotoFullRegistrationPage();
        click(By.cssSelector("button[data-dpwa-image-id='selfie-neutral']"));
        Thread.sleep(3500);
        //waitForSeveralItems(new String[]{"Confirmation", "To proceed, please answer your secret question (case sensitive)", "Forgot secret answer", "Cancel", "Confirm"});
        type(By.id("secAnswer"), "la");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
        Thread.sleep(3500);
        //waitForSeveralItems(new String[]{"Sorry, wrong answer - please, pay attention (the secret answer is case sensitive)"});
        String popUpMessage = getTextFromPopUp2(By.cssSelector("div.uk-form-row div.uk-h4"));

        assertThat(popUpMessage, equalTo("Sorry, wrong answer - please, pay attention (the secret answer is case sensitive)"));

        type(By.id("secAnswer"), "lala");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
        waitForSeveralItems(new String[]{"Sorry, wrong answer - please, pay attention, next wrong input will block your account"});
        String popUpMessage2 = getTextFromPopUp2(By.cssSelector("div.uk-form-row div.uk-h4"));

        assertThat(popUpMessage2, equalTo("Sorry, wrong answer - please, pay attention, next wrong input will block your account"));

        type(By.id("secAnswer"), "lalala");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
        waitForSeveralItems(new String[]{"Your account is blocked.", "Please, contact our call-center and stay in an area with good data connection - WiFi or 3G or higher.", "Data charges from your phone operator may apply when using mobile data"});
    }

    @Test(priority = 2,enabled = false)
    public void testVerificationWithEmptyYourTemporarySecretAnswerField() throws InterruptedException, SQLException, ClassNotFoundException {
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