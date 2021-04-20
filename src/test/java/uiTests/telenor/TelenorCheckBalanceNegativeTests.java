package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorCheckBalanceNegativeTests extends UITestBase {

    @Test(priority = 1)
    public void testCheckEmptyCardNumberField() throws InterruptedException {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        click(By.cssSelector("a[href='/en/check/balance']"));
        waitForSeveralItems(new String[]{"Check balance", "Card number", "Cancel", "Show balance"});
        type(By.id("token"), "");
        click(By.cssSelector("button[data-dpwa-action='check-balance']"));
        String hexColor = getColorOfElement(By.id("token"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
    }

    @Test(priority = 2)
    public void testCheckCardNumberFieldWithInvalidData() {
        gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        click(By.cssSelector("a[href='/en/check/balance']"));
        waitForSeveralItems(new String[]{"Check balance", "Card number", "Cancel", "Show balance"});
        type(By.id("token"), "888888888");
        click(By.cssSelector("button[data-dpwa-action='check-balance']"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("Token 888-888-888 not found. Please check token and try again"));
    }
}