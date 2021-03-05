package base;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

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

    public void closePopUp() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.uk-modal-dialog button.uk-modal-close")));
        driver.findElement(By.cssSelector("div.uk-modal-dialog button.uk-modal-close")).click();
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

    public boolean isPopUpClosed2(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id='dpwa-alert'][aria-hidden='true']")));
        if(driver.findElements(By.cssSelector("div[id='dpwa-alert'][aria-hidden='true']")).size() == 0){
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

    public String getTextFromPopUp2() {
        List<WebElement> elements = driver.findElements(By.cssSelector("div.uk-modal-dialog div.uk-modal-content"));
        return driver.findElement(By.cssSelector("div.uk-modal-dialog div.uk-modal-content")).getText();
    }


    public void submitRegistrationForm() {
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

    public void gotoManageSecurityPage() {
        driver.findElement(By.cssSelector("a[href='/en/cabinet/security']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Change PIN')]")));
    }

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
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

    public void fillRegisterForm() {
        driver.findElement(By.id("firstName")).sendKeys("Pavel");
        driver.findElement(By.id("lastName")).sendKeys("auto qa");
        driver.findElement(By.id("birthDateAsDate")).sendKeys("2000-01-01");
        driver.findElement(By.id("email")).sendKeys("la@mail.com");
        driver.findElement(By.id("street-line-1")).sendKeys("Symsca str, 15");
        driver.findElement(By.id("street-line-2")).sendKeys("Symsca str, 15");
        driver.findElement(By.id("city")).sendKeys("Kharkiv");
        selectFromSelect(By.id("country"), "France");
        driver.findElement(By.id("postcode")).sendKeys("123456");
        //new Select(driver.findElement(By.id("sqs"))).selectByVisibleText("My dream job as a child");
        selectFromSelect(By.id("sqs"), "My dream job as a child");
        driver.findElement(By.id("secAnswer")).sendKeys("QA");
    }

    public void selectFromSelect(By locator, String text) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    public void submitSmsCode() {
        driver.findElement(By.cssSelector("button[data-dpwa-action='register-verify-code']")).click();
        waitForSeveralItems(new String[]{"Name", "Surname"});
        wait.until(ExpectedConditions.elementToBeClickable(By.id("firstName")));
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
}
