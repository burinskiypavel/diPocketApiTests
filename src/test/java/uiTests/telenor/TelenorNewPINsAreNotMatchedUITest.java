package uiTests.telenor;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorNewPINsAreNotMatchedUITest extends TestBase {
    WebDriver driver;
    WebDriverWait wait;
    String phone = "380980316499";
    String expectedPhone = "38 098 031 6499";
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @BeforeClass
    public void start(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @Test(priority = 1)
    public void testNewPINsAreNotMatched() throws InterruptedException {
        String popupMessage = navigateToTelenorAndLogin(phone, smsCode);
        gotoManageSecurityPage();
        gotoChangePINPage();
        type(By.id("pin_new"), "1234");
        type(By.id("pin_confirm"), "1111");
        String hex = getColorOfElement(By.id("pin_confirm"), "border-color");

        assertThat(hex, equalTo("#ff422a"));
        Assert.assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
        assertThat(popupMessage, equalTo("Your one time password sent to "+expectedPhone+". If you didn't receive SMS in 2-3 minutes, please request password once again."));
    }

    @Test(priority = 2)
    public void testWrongOldPIN() throws InterruptedException {
        if(isElementPresent(By.id("pin_new"))){
            type(By.id("pin_new"), "1111");
            type(By.id("pin_confirm"), "1234");
            String hex = getColorOfElement(By.id("pin_confirm"), "border-color");

            assertThat(hex, equalTo("#ff422a"));
            Assert.assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
        }
        else {
            String popupMessage = navigateToTelenorAndLogin(phone, smsCode);
            gotoManageSecurityPage();
            gotoChangePINPage();
            type(By.id("pin_new"), "1111");
            type(By.id("pin_confirm"), "1234");
            String hex = getColorOfElement(By.id("pin_confirm"), "border-color");

            assertThat(hex, equalTo("#ff422a"));
            Assert.assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='change-pin-confirm']")));
            assertThat(popupMessage, equalTo("Your one time password sent to "+expectedPhone+". If you didn't receive SMS in 2-3 minutes, please request password once again."));
        }
    }

    public boolean isButtonEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void gotoChangePINPage() {
        driver.findElement(By.xpath("//a[contains(text(), 'Change PIN')]")).click();
    }

    public void gotoManageSecurityPage() {
        driver.findElement(By.cssSelector("a[href='/en/cabinet/security']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Change PIN')]")));
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
        Thread.sleep(3000);

        String color =  driver.findElement(locator).getCssValue(cssValue);

        System.out.println("color: " + color);
        String hex = Color.fromString(color).asHex();
        System.out.println("hex: " + hex);
        return hex;
    }

    public void basicAuth(String url, String login, String password) {
        //driver.navigate().to("https://dipocket:LeprechauN@telenor-test.dipocket.org");
        driver.navigate().to("https://"+login+":"+password+"@"+url+"");
    }

    @AfterClass
    public void stop(){
        driver.quit();
    }
}
