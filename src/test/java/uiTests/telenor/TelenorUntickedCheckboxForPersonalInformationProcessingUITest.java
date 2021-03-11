package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorUntickedCheckboxForPersonalInformationProcessingUITest extends UITestBase {
    String token = "515161232";
    String phone = "380502128465";
    String smsCode = null;

    @Test(enabled = false)
    public void testUntickedCheckboxForPersonalInformationProcessing() throws SQLException, ClassNotFoundException, InterruptedException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        smsCode = getSMSCodeFromDBTelenorAndWait(phone);
        fillSmsCode(smsCode);
        submitSmsCode();
        fillRegisterFormEmptyCheckboxes("Pavel", "auto qa", "2000-01-01", "la@mail.com", "Symsca str, 15", "Symsca str, 15", "Kharkiv", "France", "123456", "QA");
        submitRegistrationForm();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        checkThatUntickedCheckboxesHasRedColor();
        assertThat(popUpMessage, equalTo("There is something missing - we marked in red all fields that require your attention"));
    }
}