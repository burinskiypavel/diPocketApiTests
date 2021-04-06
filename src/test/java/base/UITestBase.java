package base;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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


    public String getTextFromPopUp() {
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
    }

    public void gotoLoginPage() {
        driver.findElement(By.cssSelector("a[href='/en/login']")).click();
        waitForSeveralItems(new String[]{"Login", "Phone"});
    }

    public void waitForSeveralItems(String mas []){
        wait = new WebDriverWait(driver, 20);
        for(int i = 0; i < mas.length; i++){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+mas[i]+"')]")));
        }
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

    public void gotoChangeSecretAnswer() {
        driver.findElement(By.xpath("//a[contains(text(), 'Change Secret answer')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("secAnswer")));
    }

    public void gotoChangeEmail() {
        driver.findElement(By.xpath("//a[contains(text(), 'Change E-mail')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
    }

    public void gotoManageSecurityPage() {
        driver.findElement(By.cssSelector("a[href='/en/cabinet/security']")).click();
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Change PIN')]")));
        waitForSeveralItems(new String[]{"Change Secret answer", "Change E-mail"});
    }

    public void gotoFullRegistrationPage() throws InterruptedException {
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), 'Full Registration')]")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/en/security/fdd']")));
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='/en/security/fdd']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), 'Your selfie')]")));
        Thread.sleep(500);
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

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
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
}
