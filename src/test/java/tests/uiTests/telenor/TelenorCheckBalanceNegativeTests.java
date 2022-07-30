package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorCheckBalanceNegativeTests extends UITestBase {

    @Test(priority = 1)
    public void testCheckEmptyCardNumberField() throws InterruptedException {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().click(By.cssSelector("a[href='/en/check/balance']"));
        app.getUiTelenorHelper().waitForSeveralItems(new String[]{"Check balance", "Card number", "Cancel", "Show balance"});
        app.getUiTelenorHelper().type(By.id("token"), "");
        app.getUiTelenorHelper().click(By.cssSelector("button[data-dpwa-action='check-balance']"));
        String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("token"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
    }

    @Test(priority = 2)
    public void testCheckCardNumberFieldWithInvalidData() {
        app.getUiTelenorHelper().gotoTelenorSiteAndDoneBasicAuth("telenor-test.dipocket.org","dipocket", "LeprechauN");
        app.getUiTelenorHelper().click(By.cssSelector("a[href='/en/check/balance']"));
        app.getUiTelenorHelper().waitForSeveralItems(new String[]{"Check balance", "Card number", "Cancel", "Show balance"});
        app.getUiTelenorHelper().type(By.id("token"), "888888888");
        app.getUiTelenorHelper().click(By.cssSelector("button[data-dpwa-action='check-balance']"));
        String popUpMessage = app.getUiTelenorHelper().getTextFromPopUp();
        app.getUiTelenorHelper().closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(app.getUiTelenorHelper().isPopUpClosed());
        assertThat(popUpMessage, equalTo("Token 888-888-888 not found. Please check token and try again"));
    }
}