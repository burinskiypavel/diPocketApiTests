package uiTests.telenor;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorUntickedCheckboxForPersonalInformationProcessingUITest extends TestBase {
    WebDriver driver;
    WebDriverWait wait;
    String token = "512166950";
    String phone = "380502128463";
    String smsCode = null;

    @BeforeClass
    public void start(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @Test(priority = 1)
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
        fillRegisterForm();
        submitRegistrationForm();
        String popUpMessage = getTextFromPopUp();
        closePopUp();

        checkThatUntickedCheckboxesHasRedColor();
        assertThat(popUpMessage, equalTo("There is something missing - we marked in red all fields that require your attention"));
    }

    public void closePopUp() {
        driver.findElement(By.cssSelector("button.uk-modal-close")).click();
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

    public String getTextFromPopUp() {
        return driver.findElement(By.cssSelector("div.uk-modal-content")).getText();
    }

    public void submitRegistrationForm() {
        driver.findElement(By.cssSelector("button[data-dpwa-action='register-complete']")).click();
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

    @AfterClass
    public void stop(){
        driver.quit();
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

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
