package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorManageSecurityNegativeTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1)
    public void testEmptyFieldSecretAnswer() throws InterruptedException {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
        gotoManageSecurityPage();
        gotoChangeSecretAnswer();
        type(By.id("secAnswer"), "qa");
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
        waitForSeveralItems(new String[]{"Secret question", "Secret answer", "Confirm", "Cancel"});
        type(By.id("secAnswer"), "");
        pressConfirm(By.cssSelector("button[data-dpwa-action='change-secret-answer-confirm']"));
        String hexColor = getColorOfElement(By.id("secAnswer"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
    }

    @Test(priority = 2)
    public void testEmptyFieldUseYourOwnQuestion() throws InterruptedException {
        if (isElementPresent(By.id("sqs"))) {
            selectFromSelect(By.id("sqs"), "Use your own question");
            type(By.id("sqc"), "");
            type(By.id("secAnswer"), "");

            pressConfirm(By.cssSelector("button[data-dpwa-action='change-secret-answer-confirm']"));
            String useUourOwnAuestionHexColor = getColorOfElement(By.id("sqc"), "border-color");
            String secAnswerHexColor = getColorOfElement(By.id("secAnswer"), "border-color");

            assertThat(useUourOwnAuestionHexColor, equalTo(app.hexRedColor));
            assertThat(secAnswerHexColor, equalTo(app.hexRedColor));

        } else {
            navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
            gotoManageSecurityPage();
            gotoChangeSecretAnswer();
            type(By.id("secAnswer"), "qa");
            pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
            waitForSeveralItems(new String[]{"Secret question", "Secret answer", "Confirm", "Cancel"});
            selectFromSelect(By.id("sqs"), "Use your own question");
            type(By.id("sqc"), "");
            type(By.id("secAnswer"), "");

            pressConfirm(By.cssSelector("button[data-dpwa-action='change-secret-answer-confirm']"));
            String useUourOwnAuestionHexColor = getColorOfElement(By.id("sqc"), "border-color");
            String secAnswerHexColor = getColorOfElement(By.id("secAnswer"), "border-color");

            assertThat(useUourOwnAuestionHexColor, equalTo(app.hexRedColor));
            assertThat(secAnswerHexColor, equalTo(app.hexRedColor));
        }
    }
}
