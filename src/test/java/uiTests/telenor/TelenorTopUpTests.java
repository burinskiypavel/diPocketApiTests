package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TelenorTopUpTests extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1) // moved to API tests
    public void testCheckFieldTopUpAmountWithDataGreaterThanHUF45000() throws InterruptedException {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
        type(By.id("dpwa-amount"), "150001");
        String popUpMessage = getTextFromPopUp();
        String hexColor = getColorOfElement(By.id("dpwa-amount"), "border-color");
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
        assertThat(hexColor, equalTo(app.hexRedColor));
    }

    @Test(priority = 2) // moved to API tests
    public void testCheckFieldTopUpAmountWithInvalidData() throws InterruptedException {
        if(isElementPresent(By.id("dpwa-amount"))){
            type(By.id("dpwa-amount"), "-0.00");
            String popUpMessage = getTextFromPopUp();
            String hexColor = getColorOfElement(By.id("dpwa-amount"), "border-color");
            closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(isPopUpClosed());
            assertThat(popUpMessage,equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

        navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
        type(By.id("dpwa-amount"), "-0.00");
        String popUpMessage = getTextFromPopUp();
        String hexColor = getColorOfElement(By.id("dpwa-amount"), "border-color");
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage,equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
        assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }

    @Test(priority = 3)
    public void testCheckFieldTopUpAmountWithoutData() throws InterruptedException {
        if (isElementPresent(By.id("dpwa-amount"))) {
            click(By.id("dpwa-amount"));
            pressBackSpace();
            String popUpMessage = getTextFromPopUp();
            String hexColor = getColorOfElement(By.id("dpwa-amount"), "border-color");
            closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(isPopUpClosed());
            assertThat(popUpMessage, equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

            navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
            click(By.id("dpwa-amount"));
            pressBackSpace();
            String popUpMessage = getTextFromPopUp();
            String hexColor = getColorOfElement(By.id("dpwa-amount"), "border-color");
            closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(isPopUpClosed());
            assertThat(popUpMessage, equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
            assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }

    @Test(priority = 4)
    public void testCheckSystemBehaviorWithEmptyFields() throws InterruptedException {
        if (isElementPresent(By.id("dpwa-amount"))) {
            assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='dpwa-topup']")));

        } else {

            navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
            assertFalse(isButtonEnabled(By.cssSelector("button[data-dpwa-action='dpwa-topup']")));
        }
    }
}
