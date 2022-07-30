package tests.uiTests.telenor;

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
        app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        app.getUiTelenorHelper().type(By.id("dpwa-amount"), "150001");
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("dpwa-amount"), "border-color");
        app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(app.getUiTelenorHelper().isPopUpClosed());
        assertThat(popUpMessage, equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
        assertThat(hexColor, equalTo(app.hexRedColor));
    }

    @Test(priority = 2) // moved to API tests
    public void testCheckFieldTopUpAmountWithInvalidData() throws InterruptedException {
        if(app.getUiTelenorHelper().isElementPresent(By.id("dpwa-amount"))){
            app.getUiTelenorHelper().type(By.id("dpwa-amount"), "-0.00");
            String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("dpwa-amount"), "border-color");
            app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(app.getUiTelenorHelper().isPopUpClosed());
            assertThat(popUpMessage,equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

            app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
            app.getUiTelenorHelper().type(By.id("dpwa-amount"), "-0.00");
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("dpwa-amount"), "border-color");
        app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(app.getUiTelenorHelper().isPopUpClosed());
        assertThat(popUpMessage,equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
        assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }

    @Test(priority = 3)
    public void testCheckFieldTopUpAmountWithoutData() throws InterruptedException {
        if (app.getUiTelenorHelper().isElementPresent(By.id("dpwa-amount"))) {
            app.getUiTelenorHelper().click(By.id("dpwa-amount"));
            app.getUiTelenorHelper().pressBackSpace();
            String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("dpwa-amount"), "border-color");
            app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(app.getUiTelenorHelper().isPopUpClosed());
            assertThat(popUpMessage, equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

            app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
            app.getUiTelenorHelper().click(By.id("dpwa-amount"));
            app.getUiTelenorHelper().pressBackSpace();
            String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("dpwa-amount"), "border-color");
            app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(app.getUiTelenorHelper().isPopUpClosed());
            assertThat(popUpMessage, equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
            assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }

    @Test(priority = 4)
    public void testCheckSystemBehaviorWithEmptyFields() throws InterruptedException {
        if (app.getUiTelenorHelper().isElementPresent(By.id("dpwa-amount"))) {
            assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.cssSelector("button[data-dpwa-action='dpwa-topup']")));

        } else {

            app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
            assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.cssSelector("button[data-dpwa-action='dpwa-topup']")));
        }
    }

    @Test(priority = 5, enabled = false) //BUG Error message is not displayed
    public void testCheckFieldTopUpAmountWithDataLessThan200Forints() throws InterruptedException {
        if(app.getUiTelenorHelper().isElementPresent(By.id("dpwa-amount"))){
            app.getUiTelenorHelper().type(By.id("dpwa-amount"), "199");
            String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("dpwa-amount"), "border-color");
            app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(app.getUiTelenorHelper().isPopUpClosed());
            assertThat(popUpMessage,equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

            app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
            app.getUiTelenorHelper().type(By.id("dpwa-amount"), "199");
            String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("dpwa-amount"), "border-color");
            app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

            assertTrue(app.getUiTelenorHelper().isPopUpClosed());
            assertThat(popUpMessage,equalTo("Minimum top-up amount is Ft 200, maximum Ft 45000"));
            assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }
}