package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;

public class TelenorRegistrationVerificationMaximumSMSCountLimitReachedTests extends UITestBase {
    String token = "514826821";
    String phone = "38050" + app.generateRandomNumber(7);
    String smsCode = null;

    @Test(priority = 1)
    public void testRegistrationVerificationWithInvalidCode() {
        smsCode = "000000";
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        fillSmsCode(smsCode);
        submitSmsCode();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertThat(popUpMessage, equalTo("Entered verification code is incorrect. Please, try again"));
    }

    @Test(priority = 2)
    public void testRegistrationVerificationWithEmpty2CheckBoxes() throws SQLException, ClassNotFoundException, InterruptedException {
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

    @Test(priority = 3)
    public void testVerificationRegisterFormWithEmptyFilds() throws InterruptedException, SQLException, ClassNotFoundException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        smsCode = getSMSCodeFromDBTelenorAndWait(phone);
        fillSmsCode(smsCode);
        submitSmsCode();
        submitRegistrationForm();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        String firstNameBorderColor = getColorOfElement(By.id("firstName"), "border-color");
        String lastNameeBorderColor = getColorOfElement(By.id("lastName"), "border-color");
        String birthDateBorderColor = getColorOfElement(By.id("birthDateAsDate"), "border-color");
        String emailBorderColor = getColorOfElement(By.id("email"), "border-color");
        String streetLineBorderColor = getColorOfElement(By.id("street-line-1"), "border-color");
        String cityBorderColor = getColorOfElement(By.id("city"), "border-color");
        String countryBorderColor = getColorOfElement(By.id("country"), "border-color");
        String postcodeBorderColor = getColorOfElement(By.id("postcode"), "border-color");
        String secAnswerBorderColor = getColorOfElement(By.id("secAnswer"), "border-color");

        assertThat(firstNameBorderColor, equalTo(app.hexRedColor));
        assertThat(lastNameeBorderColor, equalTo(app.hexRedColor));
        assertThat(birthDateBorderColor, equalTo(app.hexRedColor));
        assertThat(emailBorderColor, equalTo(app.hexRedColor));
        assertThat(streetLineBorderColor, equalTo(app.hexRedColor));
        assertThat(cityBorderColor, equalTo(app.hexRedColor));
        assertThat(countryBorderColor, equalTo(app.hexRedColor));
        assertThat(postcodeBorderColor, equalTo(app.hexRedColor));
        assertThat(secAnswerBorderColor, equalTo(app.hexRedColor));
        assertThat(popUpMessage, equalTo("There is something missing - we marked in red all fields that require your attention"));
    }

    @Test(priority = 4)
    public void testRegistrationVerificationWithInvalidEmailData() throws InterruptedException, SQLException, ClassNotFoundException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        smsCode = getSMSCodeFromDBTelenorAndWait(phone);
        fillSmsCode(smsCode);
        submitSmsCode();
        fillRegisterForm("Pavel", "auto qa", "2000-01-01", "qwerty1gmail", "Symsca str, 15", "Symsca str, 15", "Kharkiv", "France", "123456", "QA");
        submitRegistrationForm();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));
        String emailBorderColor = getColorOfElement(By.id("email"), "border-color");

        assertThat(emailBorderColor, equalTo(app.hexRedColor));
        assertThat(popUpMessage, equalTo("There is something missing - we marked in red all fields that require your attention"));
    }

    @Test(priority = 5)
    public void testVerifyThatItsImpossibleToRegisterIfUserAgeLessThan18() throws InterruptedException, SQLException, ClassNotFoundException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        smsCode = getSMSCodeFromDBTelenorAndWait(phone);
        fillSmsCode(smsCode);
        submitSmsCode();
        fillRegisterForm("Pavel", "auto qa", "2020/09/09", "la@mail.com", "Symsca str, 15", "Symsca str, 15", "Kharkiv", "France", "123456", "QA");
        submitRegistrationForm();
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.cssSelector("div.uk-modal-dialog button.uk-modal-close"));

        assertThat(popUpMessage, equalTo("We are really, really sorry but we cannot register you as you are not yet 18 y.o."));
    }

    @Test(priority = 6)
    public void testVerifyDateOfBirthFieldWithInvalidData() throws InterruptedException, SQLException, ClassNotFoundException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        smsCode = getSMSCodeFromDBTelenorAndWait(phone);
        fillSmsCode(smsCode);
        submitSmsCode();
        fillRegisterForm("Pavel", "auto qa", "1111/13/40", "la@mail.com", "Symsca str, 15", "Symsca str, 15", "Kharkiv", "France", "123456", "QA");
        submitRegistrationForm();
        String birthDateBorderColor = getColorOfElement(By.id("birthDateAsDate"), "border-color");

        assertThat(birthDateBorderColor,equalTo(app.hexRedColor));
    }

    @Test(priority = 7)
    public void testRegistrationVerificationSmsCodeWithIncopliteData() {
        smsCode = "12345";
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        fillSmsCode(smsCode);
        submitSmsCode();

        assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='register-verify-code']")));
    }
}