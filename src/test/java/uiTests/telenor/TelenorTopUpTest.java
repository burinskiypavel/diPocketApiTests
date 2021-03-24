package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorTopUpTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1, enabled = false) // moved to API tests
    public void testCheckFieldTopUpAmountWithDataGreaterThanHUF45000() {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
        type(By.id("dpwa-amount"), "11111111");
        click(By.cssSelector("button[data-dpwa-action='dpwa-topup']"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("The amount you entered is above the maximum limit, which is HUF 45000.00 for this type of transaction"));
    }

    @Test(priority = 2)
    public void testCheckFieldTopUpAmountWithoutData() throws InterruptedException {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
        type(By.id("dpwa-amount"), "");
        click(By.cssSelector("button[data-dpwa-action='dpwa-topup']"));
        String hexColor = getColorOfElement(By.id("dpwa-amount"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
    }

    @Test(priority = 3, enabled = false) // moved to API tests
    public void testCheckFieldTopUpAmountWithInvalidData() {
        if(isElementPresent(By.id("dpwa-amount"))){
            type(By.id("dpwa-amount"), "-0.00");
            click(By.cssSelector("button[data-dpwa-action='dpwa-topup']"));
            String popUpMessage = getTextFromPopUp();
            closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(isPopUpClosed());
            assertThat(popUpMessage,equalTo("Sorry, something went wrong - please try again"));
        } else {

        navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
        type(By.id("dpwa-amount"), "-0.00");
        click(By.cssSelector("button[data-dpwa-action='dpwa-topup']"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage,equalTo("Sorry, something went wrong - please try again"));
        }
    }
}
