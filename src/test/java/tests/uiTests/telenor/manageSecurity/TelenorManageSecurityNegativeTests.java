package tests.uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorManageSecurityNegativeTests extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);
    String secAnswer = "QA";

    @Test(priority = 1)
    public void testEmptyFieldSecretAnswer() throws InterruptedException {
        app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        app.getUiTelenorHelper().gotoManageSecurityPage();
        app.getUiTelenorHelper().gotoChangeSecretAnswer();
        app.getUiTelenorHelper().answerYourSecretQuestion(secAnswer);
        app.getUiTelenorHelper().waitForSeveralItems(new String[]{"Secret question", "Secret answer", "Confirm", "Cancel"});
        app.getUiTelenorHelper().type(By.id("secAnswer"), "");
        app.getUiTelenorHelper().pressConfirm(By.cssSelector("button[data-dpwa-action='change-secret-answer-confirm']"));
        String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("secAnswer"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
    }

    @Test(priority = 2)
    public void testEmptyFieldUseYourOwnQuestion() throws InterruptedException {
        if (app.getUiTelenorHelper().isElementPresent(By.id("sqs"))) {
            app.getUiTelenorHelper().selectFromSelect(By.id("sqs"), "Use your own question");
            app.getUiTelenorHelper().type(By.id("sqc"), "");
            app.getUiTelenorHelper().type(By.id("secAnswer"), "");

            app.getUiTelenorHelper().pressConfirm(By.cssSelector("button[data-dpwa-action='change-secret-answer-confirm']"));
            String useUourOwnAuestionHexColor = app.getUiTelenorHelper().getColorOfElement(By.id("sqc"), "border-color");
            String secAnswerHexColor = app.getUiTelenorHelper().getColorOfElement(By.id("secAnswer"), "border-color");

            assertThat(useUourOwnAuestionHexColor, equalTo(app.hexRedColor));
            assertThat(secAnswerHexColor, equalTo(app.hexRedColor));

        } else {

            app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
            app.getUiTelenorHelper().gotoManageSecurityPage();
            app.getUiTelenorHelper().gotoChangeSecretAnswer();
            app.getUiTelenorHelper().answerYourSecretQuestion(secAnswer);
            app.getUiTelenorHelper().waitForSeveralItems(new String[]{"Secret question", "Secret answer", "Confirm", "Cancel"});
            app.getUiTelenorHelper().selectFromSelect(By.id("sqs"), "Use your own question");
            app.getUiTelenorHelper().type(By.id("sqc"), "");
            app.getUiTelenorHelper().type(By.id("secAnswer"), "");

            app.getUiTelenorHelper().pressConfirm(By.cssSelector("button[data-dpwa-action='change-secret-answer-confirm']"));
            String useUourOwnAuestionHexColor = app.getUiTelenorHelper().getColorOfElement(By.id("sqc"), "border-color");
            String secAnswerHexColor = app.getUiTelenorHelper().getColorOfElement(By.id("secAnswer"), "border-color");

            assertThat(useUourOwnAuestionHexColor, equalTo(app.hexRedColor));
            assertThat(secAnswerHexColor, equalTo(app.hexRedColor));
        }
    }
}