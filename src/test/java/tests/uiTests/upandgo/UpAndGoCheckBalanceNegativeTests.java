package tests.uiTests.upandgo;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class UpAndGoCheckBalanceNegativeTests extends UITestBase {
    String hexRedColor = "#ff0000";

    @Test(priority = 1)
    public void testCheckEmptyCardNumberField() throws InterruptedException {
        gotoUpAndGoSiteAndDoneBasicAuth("playit-test.dipocket.org/en","dipocket", "LeprechauN");
        click(By.cssSelector("a[href='/en/check/balance']"));
        waitForSeveralItems(new String[]{"Check balance and PIN code", "Card identifier", "Cancel", "Continue"});
        type(By.id("token"), "");
        click(By.cssSelector("button[data-dpwa-action='check-balance']"));
        String hexColor = getColorOfElement(By.id("token"), "border-color");

        assertThat(hexColor, equalTo(hexRedColor));
    }

    @Test(priority = 2)
    public void testCheckCardNumberFieldWithInvalidData() {
        gotoUpAndGoSiteAndDoneBasicAuth("playit-test.dipocket.org/en","dipocket", "LeprechauN");
        click(By.cssSelector("a[href='/en/check/balance']"));
        waitForSeveralItems(new String[]{"Check balance and PIN code", "Card identifier", "Cancel", "Continue"});
        type(By.id("token"), "88888888");
        click(By.cssSelector("button[data-dpwa-action='check-balance']"));
        String popUpMessage = getTextFromPopUpUpAndGo();
        closePopUp(By.xpath("//button[contains(text(), 'OK')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Token 8888-8888 not found. Please check token and try again"));
    }
}