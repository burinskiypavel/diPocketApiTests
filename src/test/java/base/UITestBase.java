package base;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class UITestBase {

    protected final ApplicationManager app = new ApplicationManager();

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void start() {
        app.initStart();
        app.init();

        //selenium server works
//        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("browser", "chrome");
//        ChromeOptions options = new ChromeOptions();
//        options.merge(caps);
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--headless");
        //WebDriverManager.chromedriver().version("88").setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @AfterClass
    public void stop(){
        driver.quit();
    }

    public boolean isDefault2(By locator) {
        WebElement element = driver.findElement(locator);
        boolean ariaSelected = Boolean.parseBoolean(element.getAttribute("aria-selected"));
        return ariaSelected;
    }

    public void performContextClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public void moveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void deleteTextFromTextarea(By locator) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public boolean areElementsPresentAfterSorting(By locator){
        boolean bool;
        int size = driver.findElements(locator).size();
        if(size >= 1){
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public void closePopUp(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public void closePopUp2(By locator) {
        //wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElements(locator).get(1).click();
    }

    public boolean isPopUpClosed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='dpwa-alert'][aria-hidden='true']")));
        if(driver.findElements(By.cssSelector("div[id='dpwa-alert'][aria-hidden='true']")).size() == 1){
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

    public boolean isPopUpClosed3(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        if(driver.findElements(locator).size() == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void uploadFile(By locator, String path) {
        WebElement fileInput = driver.findElement(locator);
        fileInput.sendKeys(path);
    }

    public String getTextFromPopUp() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Ok')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='dpwa-alert'][aria-hidden='false']")));
        return driver.findElement(By.cssSelector("div.uk-modal-content")).getText();
    }

    public String getTextFromPopUp2(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator).getText();
    }

    public void submitRegistrationForm() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-dpwa-action='register-complete']")));
        driver.findElement(By.cssSelector("button[data-dpwa-action='register-complete']")).click();
    }

    public void submitPublicTokenAndPhone() {
        driver.findElement(By.cssSelector("button[data-dpwa-action='register-check']")).click();
    }

    public void clickCheckbox(By locator) {
        driver.findElement(locator).click();
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

    public void waitForSeveralItems(String mas []){
        wait = new WebDriverWait(driver, 25);
        for(int i = 0; i < mas.length; i++){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+mas[i]+"')]")));
        }
    }

    public void waitForSeveralItems2(String mas []){
        wait = new WebDriverWait(driver, 20);
        for(int i = 0; i < mas.length; i++){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(mas[i])));
        }
    }

    public void waitFor(By locator){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForInvisibilityOfElement(By locator) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void pressKeys(Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    public void gotoTelenorSiteAndDoneBasicAuth(String url, String login, String password) {
        //driver.navigate().to("https://dipocket:LeprechauN@telenor-test.dipocket.org");
        driver.navigate().to("https://"+login+":"+password+"@"+url+"");
        waitForSeveralItems(new String[]{"Register payment band", "Login", "Check balance"});
    }

    public void basicAuth(String url, String login, String password) {
        //driver.navigate().to("https://dipocket:LeprechauN@telenor-test.dipocket.org");
        driver.navigate().to("https://"+login+":"+password+"@"+url+"");
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

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void pressConfirm(By locator){
        driver.findElement(locator).click();
    }

    public boolean isButtonEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public boolean isCheckboxSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    public boolean isTabActiveAndSelected(By locator) {
        boolean bool = isElementPresent(locator);
        return bool;
    }

    public boolean isPageOpen(By locator) {
        boolean bool = isElementPresent(locator);
        return bool;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public boolean isDefault(By locator) {
        boolean bool = isElementPresent(locator);
        return bool;
    }

    public boolean areElementsPresent(String mas []){
        boolean bool = false;
        for(int i = 0; i < mas.length; i++){

            bool =  isElementPresent(By.xpath(mas[i]));

            if(bool == false){
                System.out.println("element is not present: " + mas[i]);
                return false;
            }
        }
        return true;
    }

    public boolean areButtonsPresent(String mas []){
        boolean bool = false;
        for(int i = 0; i < mas.length; i++){

            bool =  isElementPresent(By.xpath(mas[i]));

            if(bool == false){
                System.out.println("button is not present: " + mas[i]);
                return false;
            }
        }
        return true;
    }

    public String navigateToTelenorAndLogin(String phone, String smsCode) {
        basicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        driver.findElement(By.cssSelector("a[href='/en/login']")).click();
        driver.findElement(By.id("phone_number")).sendKeys(phone);
        driver.findElement(By.cssSelector("button.request-otp")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.uk-modal-dialog")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.uk-text-right button.uk-modal-close")));

        String popup = driver.findElement(By.cssSelector("div.uk-modal-content")).getText();

        driver.findElement(By.cssSelector("div.uk-text-right button.uk-modal-close")).click();


        given().log().uri().log().headers().log().body()
                .header("content-type", "application/json; charset=utf-8")
                .header("site", app.telenorSite)
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
                .header("site", app.telenorSite)
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
                .header("site", app.telenorSite)
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

    public String getColorOfElement(By locator, String cssValue) throws InterruptedException {
        Thread.sleep(2000);

        String color =  driver.findElement(locator).getCssValue(cssValue);

        System.out.println("color: " + color);
        String hex = Color.fromString(color).asHex();
        System.out.println("hex: " + hex);
        return hex;
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

    public void selectFromSelect(By locator, String text) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
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
        Thread.sleep(3000);
        String smsCode = app.getDbHelper().getSMSCodeFromDBTelenor(phone);
        return smsCode;
    }

    public void checkThatAfterRedirectionPhoneNumberDisplayedInPhoneField(String phone) {
        String loginPhoneNumber = driver.findElement(By.id("phone_number")).getAttribute("value");
        assertThat(loginPhoneNumber, equalTo(phone));
    }

    public boolean isElementHasRedColor(By locator) {
        if(driver.findElements(locator).size() == 1){
            return true;
        } else {
            return false;
        }
    }

    public String getAttributeValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public void pressBackSpace() {
        Actions actions = new Actions(driver);
        Action seriesOfActions = actions
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .build();
        seriesOfActions.perform() ;
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

//    Up And Go

    public void gotoUpAndGoSiteAndDoneBasicAuth(String url, String login, String password) {
        //driver.navigate().to("https://dipocket:LeprechauN@telenor-test.dipocket.org");
        driver.navigate().to("https://"+login+":"+password+"@"+url+"");
        waitForSeveralItems(new String[]{"Register your card", "Login", "Check balance and PIN code"});
    }

    public void gotoLoginPageUpAndGo() {
        driver.findElement(By.cssSelector("a[href='/en/cabinet']")).click();
        waitForSeveralItems(new String[]{"Login", "Phone number"});
    }

    public String getTextFromPopUpUpAndGo() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'OK')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='dpwa-alert'][aria-hidden='false']")));
        return driver.findElement(By.cssSelector("div.uk-modal-content")).getText();
    }

    // bo

    @FindBy(css = "app-button[ng-reflect-label='Edit']")
    public WebElement editBtn;

    public void gotoBOSiteAndLoginWithBOUserRole(String login, String password) throws InterruptedException {
        driver.navigate().to("https://support.dipocket.dev/NgBOTool");
        waitForSeveralItems(new String[]{"Login:", "Password:", "Log in"});
        type(By.cssSelector("input[type='text']"), login);
        type(By.cssSelector("input[type='password']"), password);
        Thread.sleep(500);
        click(By.cssSelector("button[type='button']"));
        waitForSeveralItems(new String[]{"Search", "Take Ticket", "Home", "Logout"});
    }

    public void gotoBOSiteAndLoginWithCBOUserRole(String login, String password) throws InterruptedException {
        driver.navigate().to("https://support.dipocket.dev/NgBOTool");
        waitForSeveralItems(new String[]{"Login:", "Password:", "Log in"});
        type(By.cssSelector("input[type='text']"), login);
        type(By.cssSelector("input[type='password']"), password);
        Thread.sleep(500);
        click(By.cssSelector("button[type='button']"));
        waitForSeveralItems(new String[]{"Tickets", "BO Users", "Search", "Operations", "Reports"});
    }

    public void gotoBOUsersPage() {
        click(By.xpath("//p[contains(text(), 'BO Users')]"));
        waitFor(By.xpath("//span[contains(text(), 'Active users')]"));
    }

    public void gotoSearchPage() {
        click(By.cssSelector("div[ng-reflect-router-link='search']"));
        waitFor(By.xpath("//*[contains(text(), 'Card')]"));
    }

    public void gotoRolesTab() {
        click(By.id("p-tabpanel-2-label"));
    }

    public void gotoAllUsersTab() {
        click(By.id("p-tabpanel-1-label"));
    }

    public void addRole(String roleID, String roleName) throws InterruptedException {
        click(By.cssSelector("app-button[label='+ Add']"));
        waitForSeveralItems(new String[]{"Role ID:", "Role name:", "Add Role"});
        type(By.cssSelector("app-input[ng-reflect-label='Role ID'] input[type='text']"), roleID);
        type(By.cssSelector("app-input[ng-reflect-label='Role name'] input[type='text']"), roleName);
        Thread.sleep(500);
        click(By.cssSelector("app-button[ng-reflect-label='Add']"));
    }

    public void selectRoleFromDropDown(final String name) {
        click(By.cssSelector("p-dropdown[placeholder='Role']"));
        click(By.cssSelector("li[aria-label='" + name + "']"));
        waitFor(By.cssSelector("div[role='checkbox']"));
    }

    public void editUserRole(String roleName) throws InterruptedException {
        click(By.cssSelector("app-button[label='Edit']"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), roleName);
        Thread.sleep(500);
        click(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Edit']"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Edit']")));
    }

    public void deleteRole() {
        click(By.cssSelector("app-button[label='Delete']"));
        click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
        waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));
    }

    public void selectBOUser(String text) throws InterruptedException {
        click(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='" + text + "']"));
        Thread.sleep(500);
    }

    public void searchBOUser(String tabPanel, String filter, String text) {
        type(By.cssSelector("p-tabpanel[header='" + tabPanel + "'] p-columnfilter[field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }

    public void searchAndSelectBOUser(String tabPanel, String filter, String text) throws InterruptedException {
        searchBOUser(tabPanel, filter, text);
        selectBOUser(text);
    }

    public void editUser(String firsname) throws InterruptedException {
        type(By.cssSelector("app-input[ng-reflect-name='firstName'] input[type='text']"), firsname);
        Thread.sleep(1500);
        click(By.cssSelector("app-button[ng-reflect-label='Edit user']"));
        waitFor(By.xpath("//*[contains(text(), 'User updated successfully')]"));
    }

    public void fillBOUserFieldsInPopup(String firstname, String lastname, String phone, String email, String username) {
        type(By.cssSelector("app-input[ng-reflect-name='firstName'] input[type='text']"), firstname);
        type(By.cssSelector("app-input[ng-reflect-name='lastName'] input[type='text']"), lastname);
        type(By.cssSelector("app-input-number[ng-reflect-name='phone'] input.p-inputtext"), phone);
        type(By.cssSelector("app-input[ng-reflect-name='email'] input[type='text']"), email);
        type(By.cssSelector("app-input[ng-reflect-name='username'] input[type='text']"), username);
    }

    public boolean isButtonEnabled2(By locator) {
        boolean enabled = false;
        WebElement element = driver.findElements(locator).get(1);
        boolean disabled = Boolean.parseBoolean(element.getAttribute("ng-reflect-disabled"));
        System.out.println(disabled);

        if(disabled){
            return false;
        } else if (disabled == false){
            enabled  = true;
        }

        return enabled;
    }

    public boolean isButtonEnabled3(By locator) {
        boolean enabled = false;
        WebElement element = driver.findElement(locator);
        boolean disabled = Boolean.parseBoolean(element.getAttribute("ng-reflect-disabled"));
        System.out.println(disabled);

        if(disabled){
            return false;
        } else if (disabled == false){
            enabled  = true;
        }

        return enabled;
    }

    public void unblockUser() {
        click(By.cssSelector("app-button[ng-reflect-label='Unblock user']"));
        click(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        waitFor(By.xpath("//*[contains(text(), 'User unblocked successfully')]"));
    }

    public void blockUser(String blockReason) throws InterruptedException {
        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Block user']"));
        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to block user')]"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), blockReason);
        Thread.sleep(1000);
        click(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Block user']"));
        waitFor(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitFor(By.cssSelector("td[ng-reflect-text='Blocked']"));
    }

    public void setClientPageFilter(String filter, String text) {
        type(By.cssSelector("p-columnfilter[field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }

    public void setDropDownClientPageFilter(String filter, String value) {
        click(By.cssSelector("p-columnfilter[field='" + filter + "']"));
        click(By.cssSelector("li[aria-label='" + value + "']"));
        waitFor(By.cssSelector("i.p-dropdown-clear-icon"));
    }

    public void clearFilter(By locator) {
        click(locator);
    }

    public void moveToElementAndPerformContextClick(String accountName) throws InterruptedException {
        moveToElement(By.cssSelector("td[ng-reflect-text='" + accountName + "']"));
        Thread.sleep(1500);
        performContextClick(By.cssSelector("td[ng-reflect-text='" + accountName + "']"));
        waitForElementToBeClickable(By.xpath("//span[contains(text(), 'Block account')]"));
        //Thread.sleep(1000);
    }

    public void unblockAccount() throws InterruptedException {
        click(By.xpath("//span[contains(text(), 'Unblock account')]"));
        click(By.cssSelector("app-button[label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was unblocked successfully')]"));
        Thread.sleep(1500);
    }

    public void boClientPageBlockAccount() throws InterruptedException {
        click(By.xpath("//span[contains(text(), 'Block account')]"));
        click(By.cssSelector("app-button[label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was blocked successfully')]"));
        Thread.sleep(1500);
    }

    public String blockAccount() {
        click(By.xpath("//span[contains(text(), 'Block account')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-block-account-modal p"));
        click(By.cssSelector("app-button[label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was blocked successfully')]"));
        return actualPopupText;
    }

    public String unblockAccountAndGetPopupText() {
        click(By.xpath("//span[contains(text(), 'Unblock account')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-unblock-account-modal p"));
        click(By.cssSelector("app-button[label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was unblocked successfully')]"));
        return actualPopupText;
    }

    public void goToAccountsTab() {
        click(By.id("p-tabpanel-8-label"));
    }

    public void goToClientPage(String phone) {
        click(By.cssSelector("td[ng-reflect-text='"+phone+"']"));
        waitFor(By.cssSelector("p.user-name"));
    }

    public void search(String by, String value, String phone) {
        type(By.cssSelector("app-input-number[ng-reflect-name='" + by + "'] input.p-inputnumber-input"), value);
        waitFor(By.cssSelector("td[ng-reflect-text='"+phone+"']"));
    }

    public void updateLimits(String lowLimit, String highLimit) throws InterruptedException {
        type(By.cssSelector("app-input[ng-reflect-name='lowLimit'] input[type='text']"), lowLimit);
        type(By.cssSelector("app-input[ng-reflect-name='highLimit'] input[type='text']"), highLimit);
        Thread.sleep(1000);
        click(By.cssSelector("app-button[ng-reflect-label='Save']"));
        waitFor(By.xpath("//div[contains(text(), 'Account limits was changed successfully')]"));
    }

    public void blockCard() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Block card')]"));
        waitFor(By.xpath("//label[contains(text(), '41 Lost card (can be unblocked)')]"));
        assertTrue(areElementsPresent(new String[]{"//label[contains(text(), '41 Lost card (can be unblocked)')]", "//label[contains(text(), '43 Stolen card')]",
                "//label[contains(text(), '62 Restricted card')]", "//label[contains(text(), '83 Card destroyed')]"}));

        click(By.xpath("//label[contains(text(), '41 Lost card (can be unblocked)')]"));
        Thread.sleep(1200);
        click(By.cssSelector("app-button[ng-reflect-label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Card was blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//div[contains(text(), 'Card was blocked successfully')]"));
    }

    public void unblockCard() throws InterruptedException {
        click(By.xpath("//li //span[contains(text(), 'Unblock card')]"));
        waitFor(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        click(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        waitFor(By.xpath("//div[contains(text(), 'Card was unblocked successfully')]"));
        Thread.sleep(4000);
    }

    public String getNextElementFromTheTable(String cardId, int element) {
        String actualState = driver.findElement(By.xpath("//td[text() = '"+cardId+"']/following-sibling::td["+element+"]")).getText();
        return actualState;
    }
}