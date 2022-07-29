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
        app.getUiUpAndGoHelper().gotoUpAndGoSiteAndDoneBasicAuth("playit-test.dipocket.org/en","dipocket", "LeprechauN");
        app.getUiboHelper().click(By.cssSelector("a[href='/en/check/balance']"));
        app.getUiboHelper().waitForSeveralItems(new String[]{"Check balance and PIN code", "Card identifier", "Cancel", "Continue"});
        app.getUiboHelper().type(By.id("token"), "");
        app.getUiboHelper().click(By.cssSelector("button[data-dpwa-action='check-balance']"));
        String popUpMessage = app.getUiUpAndGoHelper().getTextFromPopUpUpAndGo();
        app.getUiboHelper().closePopUp(By.xpath("//button[contains(text(), 'OK')]"));

        assertThat(popUpMessage, equalTo("Token not found. Please check token and try again"));
    }

    @Test(priority = 2)
    public void testCheckCardNumberFieldWithInvalidData() {
        app.getUiUpAndGoHelper().gotoUpAndGoSiteAndDoneBasicAuth("playit-test.dipocket.org/en","dipocket", "LeprechauN");
        app.getUiUpAndGoHelper().click(By.cssSelector("a[href='/en/check/balance']"));
        app.getUiUpAndGoHelper().waitForSeveralItems(new String[]{"Check balance and PIN code", "Card identifier", "Cancel", "Continue"});
        app.getUiUpAndGoHelper().type(By.id("token"), "88888888");
        app.getUiUpAndGoHelper().click(By.cssSelector("button[data-dpwa-action='check-balance']"));
        String popUpMessage = app.getUiUpAndGoHelper().getTextFromPopUpUpAndGo();
        closePopUp(By.xpath("//button[contains(text(), 'OK')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Token 8888-8888 not found. Please check token and try again"));
    }
}