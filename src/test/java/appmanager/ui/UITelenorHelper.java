package appmanager.ui;

import appmanager.ApplicationManager;
import appmanager.UIHelperBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UITelenorHelper extends UIHelperBase {

    public UITelenorHelper(WebDriver driver) {
        super(driver);
    }

    public void submitRegistrationForm() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-dpwa-action='register-complete']")));
        driver.findElement(By.cssSelector("button[data-dpwa-action='register-complete']")).click();
    }

    public void submitPublicTokenAndPhone() {
        driver.findElement(By.cssSelector("button[data-dpwa-action='register-check']")).click();
    }

    public void gotoRegisterPaymentBandPage() {
        driver.findElement(By.cssSelector("a[href='/en/register']")).click();
        waitForSeveralItems(new String[]{"Register payment band", "Login data", "Card number"});
        Assert.assertTrue(isButtonEnabled(By.cssSelector("a[href='/en/']")));
        Assert.assertTrue(isButtonEnabled(By.cssSelector("button[data-dpwa-action='register-check']")));
        Assert.assertTrue(isElementPresent(By.id("agreeProcessInfo")));
    }

    public void gotoLoginPage() {
        driver.findElement(By.cssSelector("a[href='/en/login']")).click();
        waitForSeveralItems(new String[]{"Login", "Phone"});
    }

    public void gotoTelenorSiteAndDoneBasicAuth(String url, String login, String password) {
        //driver.navigate().to("https://dipocket:LeprechauN@telenor-test.dipocket.org");
        driver.navigate().to("https://"+login+":"+password+"@"+url+"");
        waitForSeveralItems(new String[]{"Register payment band", "Login", "Check balance"});
    }

    public void gotoChangePINPage() {
        driver.findElement(By.xpath("//a[contains(text(), 'Change PIN')]")).click();
    }

    public void gotoChangeSecretAnswer() throws InterruptedException {
        Thread.sleep(400);
        driver.findElement(By.xpath("//a[contains(text(), 'Change Secret answer')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secAnswer")));
        waitForSeveralItems(new String[]{"Forgot secret answer"});
        Assert.assertTrue(isElementPresent(By.xpath("//a[contains(text(), 'Forgot secret answer')]")));
    }

    public void gotoForgotSecretAnswer() {
        driver.findElement(By.xpath("//a[contains(text(), 'Forgot secret answer')]")).click();
        waitForSeveralItems(new String[]{"Secret answer reset", "Please enter your email to reset your secret answer"});
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        Assert.assertTrue(isButtonEnabled(By.cssSelector("button[data-dpwa-action='sa-reset-request']")));
        Assert.assertTrue(isButtonEnabled(By.xpath("//a[contains(text(), 'Back')]")));
    }

    public void gotoChangeEmail() {
        driver.findElement(By.xpath("//a[contains(text(), 'Change E-mail')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
    }

    public void gotoManageSecurityPage() throws InterruptedException {
        Thread.sleep(400);
        waitForSeveralItems(new String[]{"Top-up", "Manage security", "Card activity", "Your profile"});
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/en/cabinet/security']")));
        driver.findElement(By.cssSelector("a[href='/en/cabinet/security']")).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Change PIN')]")));
        waitForSeveralItems(new String[]{"Change Secret answer", "Change E-mail"});
        Assert.assertTrue(isElementPresent(By.xpath("//*[contains(text(), 'Change Secret answer')]")));
    }

    public void gotoOffloadFundsPage() {
        driver.findElement(By.cssSelector("a[href='/en/cabinet/offload']")).click();
        waitForSeveralItems(new String[]{"Beneficiary", "Name", "Surname", "Account #", "If you confirm, you will irrevocably lose all the extra functionality available to registered customers and you will not be able to register again with the same mobile number"});
        Assert.assertTrue(isButtonEnabled(By.cssSelector("a[href='/en/cabinet']")));
        Assert.assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='offload-confirm']")));
        Assert.assertTrue(isElementPresent(By.name("agreeDelete")));
    }

    public void gotoFullRegistrationPage() throws InterruptedException {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), 'Full Registration')]")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/en/security/fdd']")));
        Thread.sleep(1400);
        driver.findElement(By.cssSelector("a[href='/en/security/fdd']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), 'Your selfie')]")));
        Thread.sleep(1400);//500
    }

    public String navigateToTelenorAndLogin(String phone, String smsCode) {
        ApplicationManager app = new ApplicationManager();
        basicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        driver.findElement(By.cssSelector("a[href='/en/login']")).click();
        driver.findElement(By.id("phone_number")).sendKeys(phone);
        driver.findElement(By.cssSelector("button.request-otp")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.uk-modal-dialog")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.uk-text-right button.uk-modal-close")));

        String popup = driver.findElement(By.cssSelector("div.uk-modal-content")).getText();

        driver.findElement(By.cssSelector("div.uk-text-right button.uk-modal-close")).click();


        given().log().uri().log().headers().log().body()
                .contentType("application/json; charset=utf-8")
                .header("site", Site.TELENOR.toString())
                .body("{\n" +
                        "  \"phoneNumber\" : \""+phone+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"")
                .then().log().all()
                .statusCode(200);


        driver.findElement(By.id("password")).sendKeys(smsCode);
        driver.findElement(By.id("dpwa-login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/en/logout']")));
        return popup;
    }

    public void navigateToTelenorAndLogin2(String phone, String smsCode) {
        ApplicationManager app = new ApplicationManager();
        basicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        driver.findElement(By.cssSelector("a[href='/en/login']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("phone_number")));
        driver.findElement(By.id("phone_number")).sendKeys(phone);
        driver.findElement(By.cssSelector("button.request-otp")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.uk-modal-dialog")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.uk-text-right button.uk-modal-close")));

        driver.findElement(By.cssSelector("div.uk-text-right button.uk-modal-close")).click();


        given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", Site.TELENOR.toString())
                .body("{\n" +
                        "  \"phoneNumber\" : \""+phone+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"")
                .then().log().all()
                .statusCode(200);


        driver.findElement(By.id("password")).sendKeys(smsCode);
        driver.findElement(By.id("dpwa-login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/en/logout']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dpwa-amount")));
    }

    public void navigateToTelenorAndDone2IncorrectLoginAndThenSuccessfulLogin(String phone, String incorrectSmsCode, String smsCode) {
        ApplicationManager app = new ApplicationManager();
        basicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        click(By.cssSelector("a[href='/en/login']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("phone_number")));
        type(By.id("phone_number"), phone);
        click(By.cssSelector("button.request-otp"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.uk-modal-dialog")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.uk-text-right button.uk-modal-close")));

        click(By.cssSelector("div.uk-text-right button.uk-modal-close"));

        type(By.id("password"), incorrectSmsCode);
        click(By.id("dpwa-login"));

        waitForSeveralItems(new String[]{"Login or password is incorrect"});
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        click(By.id("dpwa-login"));

        waitForSeveralItems(new String[]{"Login or password is incorrect"});
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        given().log().uri().log().headers().log().body()
                .contentType("application/json; charset=utf-8")
                .header("site", Site.TELENOR.toString())
                .body("{\n" +
                        "  \"phoneNumber\" : \""+phone+"\"\n" +
                        "}")
                .when()
                .post(app.dipocket3_intranet+"/TestServices/v1/telenor/sendOtpForPhone/"+smsCode+"")
                .then().log().all()
                .statusCode(200);

        type(By.id("password"), smsCode);
        click(By.id("dpwa-login"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='/en/logout']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("dpwa-amount")));
    }

    public void checkThatUntickedCheckboxesHasRedColor() {
        String color1 =  driver.findElements(By.cssSelector("label.dpwa-field-empty")).get(0).getCssValue("color");

        System.out.println("color1: " + color1);
        String hex1 = Color.fromString(color1).asHex();
        System.out.println("hex1: " + hex1);

        String color2 =  driver.findElements(By.cssSelector("label.dpwa-field-empty")).get(1).getCssValue("color");

        System.out.println("color2: " + color2);
        String hex2 = Color.fromString(color2).asHex();
        System.out.println("hex2: " + hex2);

        assertThat(hex1, equalTo("#ff422a")); //red
        assertThat(hex2, equalTo("#ff422a")); //red
    }

    public void checkThatUntickedCheckboxHasRedColor(By locator) throws InterruptedException {
        String hexColor = getColorOfElement(locator, "color");

        assertThat(hexColor, equalTo("#ff0000")); //red
    }

    public void fillRegisterForm(String firstName, String lastName, String birthDate, String email, String streetLine1, String streetLine2, String city, String country, String postcode, String secAnswer) {
        waitForSeveralItems(new String[]{"Name", "Surname"});
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("birthDateAsDate")).sendKeys(birthDate);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("street-line-1")).sendKeys(streetLine1);
        driver.findElement(By.id("street-line-2")).sendKeys(streetLine2);
        driver.findElement(By.id("city")).sendKeys(city);
        selectFromSelect(By.id("country"), country);
        driver.findElement(By.id("postcode")).sendKeys(postcode);
        //new Select(driver.findElement(By.id("sqs"))).selectByVisibleText("My dream job as a child");
        selectFromSelect(By.id("sqs"), "My dream job as a child");
        driver.findElement(By.id("secAnswer")).sendKeys(secAnswer);

        driver.findElement(By.id("agreeTerms")).click();
        driver.findElement(By.id("agreeTariffs")).click();
    }

    public void fillRegisterFormEmptyCheckboxes(String firstName, String lastName, String birthDate, String email, String streetLine1, String streetLine2, String city, String country, String postcode, String secAnswer) {
        waitForSeveralItems(new String[]{"Name", "Surname"});
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("birthDateAsDate")).sendKeys(birthDate);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("street-line-1")).sendKeys(streetLine1);
        driver.findElement(By.id("street-line-2")).sendKeys(streetLine2);
        driver.findElement(By.id("city")).sendKeys(city);
        selectFromSelect(By.id("country"), country);
        driver.findElement(By.id("postcode")).sendKeys(postcode);
        //new Select(driver.findElement(By.id("sqs"))).selectByVisibleText("My dream job as a child");
        selectFromSelect(By.id("sqs"), "My dream job as a child");
        driver.findElement(By.id("secAnswer")).sendKeys(secAnswer);
    }

    public void submitSmsCode() {
        driver.findElement(By.cssSelector("button[data-dpwa-action='register-verify-code']")).click();
        //waitForSeveralItems(new String[]{"Name", "Surname"});
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
    }

    public void fillSmsCode(String smsCode) {
        waitForSeveralItems(new String[]{"Verification code"});
        wait.until(ExpectedConditions.elementToBeClickable(By.id("smsCode")));
        driver.findElement(By.id("smsCode")).sendKeys(smsCode);
    }

    public String getSMSCodeFromDBTelenorAndWait(String phone) throws InterruptedException, ClassNotFoundException, SQLException {
        ApplicationManager app = new ApplicationManager();
        Thread.sleep(3000);
        String smsCode = app.getDbHelper().getSMSCodeFromDBTelenor(phone);
        return smsCode;
    }

    public void checkThatAfterRedirectionPhoneNumberDisplayedInPhoneField(String phone) {
        String loginPhoneNumber = driver.findElement(By.id("phone_number")).getAttribute("value");
        assertThat(loginPhoneNumber, equalTo(phone));
    }

    public void unblockPaymentBandTelenor(String token, String secAnswer) {
        click(By.cssSelector("a[href='/en/security/unblock']"));
        waitForSeveralItems(new String[]{"Unblock", "Cancel", "For security reasons, to unblock your payment band please enter your 9-digits payment band token"});
        type(By.id("publicToken"), token);

        click(By.cssSelector("button[data-dpwa-action='unblock-card']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("secAnswer")));
        type(By.id("secAnswer"), secAnswer);
        click(By.cssSelector("button[data-dpwa-action='sa-send']"));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/en/security/block']")));
    }

    public void blockPaymentBandTelenor(String secAnswer) {
        click(By.cssSelector("a[href='/en/security/block']"));
        waitForSeveralItems(new String[]{"Confirm", "Cancel"});
        click(By.cssSelector("button[data-dpwa-action='band-block-confirm']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("secAnswer")));
        type(By.id("secAnswer"), secAnswer);
        click(By.cssSelector("button[data-dpwa-action='sa-send']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/en/security/unblock']")));
    }

    public void answerYourSecretQuestion(String secAnswer) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("secAnswer")));
        type(By.id("secAnswer"), secAnswer);
        pressConfirm(By.cssSelector("button[data-dpwa-action='sa-send']"));
    }

    public boolean isPopUpClosed3(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        if(driver.findElements(locator).size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isPopUpClosedRedirection(String id){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='" + id + "'][aria-hidden='true']")));
        if(driver.findElements(By.cssSelector("div[id='" + id + "'][aria-hidden='true']")).size() == 0)
        {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isPopUpClosed2(String id){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='" + id + "'][aria-hidden='false']")));
        if(driver.findElements(By.cssSelector("div[id='" + id + "'][aria-hidden='true']")).size() > 0)
        {
            return true;
        }
        else {
            return false;
        }
    }
}