package tests.uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorLinkNewPaymentBandWithIncompleteDataTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test
    public void testLinkNewPaymentBandWithIncompleteData() throws InterruptedException {
        app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        app.getUiTelenorHelper().gotoManageSecurityPage();
        if (app.getUiTelenorHelper().isElementPresent(By.cssSelector("a[href='/en/security/block']"))) {
            app.getUiTelenorHelper().blockPaymentBandTelenor("QA");
            app.getUiTelenorHelper().click(By.cssSelector("a[href='/en/security/relink']"));
            app.getUiTelenorHelper().waitForSeveralItems(new String[]{"To link your payment band please enter your 9-digits payment band token", "Cancel", "Link new payment band", "Card number"});
            app.getUiTelenorHelper().type(By.id("token"), "12345678");
            app.getUiTelenorHelper().click(By.cssSelector("button[data-dpwa-action='band-relink']"));
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("token"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

            app.getUiTelenorHelper().click(By.cssSelector("a[href='/en/security/relink']"));
            app.getUiTelenorHelper().waitForSeveralItems(new String[]{"To link your payment band please enter your 9-digits payment band token", "Cancel", "Link new payment band", "Card number"});
            app.getUiTelenorHelper().type(By.id("token"), "12345678");
            app.getUiTelenorHelper().click(By.cssSelector("button[data-dpwa-action='band-relink']"));
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("token"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }
}