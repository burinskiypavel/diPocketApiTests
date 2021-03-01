package uiTests.telenor;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorRegistrationVerificationWithInvalidTokenUITest extends TestBase {
    WebDriver driver;
    WebDriverWait wait;
    String token = "111111111";
    String phone = "447459005207";

    @BeforeClass
    public void start(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @Test(priority = 1)
    public void testRegistrationVerificationWithInvalidToken() throws InterruptedException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        gotoRegisterPaymentBandPage();
        type(By.name("publicToken"), token);
        type(By.id("mainPhone"), phone);
        clickCheckbox(By.id("agreeProcessInfo"));
        submitPublicTokenAndPhone();
        String popUpMessage = getTextFromPopUp();
        closePopUp();

        Assert.assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Card number is invalid. Please enter the correct card number"));
    }

    public void closePopUp() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.uk-modal-close")));
        driver.findElement(By.cssSelector("button.uk-modal-close")).click();
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

    public String getTextFromPopUp() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='dpwa-alert'][aria-hidden='false']")));
        return driver.findElement(By.cssSelector("div.uk-modal-content")).getText();
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
