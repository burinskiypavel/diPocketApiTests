package uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkNewPaymentBandWithIncompleteDataTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test
    public void testLinkNewPaymentBandWithIncompleteData() throws InterruptedException {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        gotoManageSecurityPage();
        if (isElementPresent(By.cssSelector("a[href='/en/security/block']"))) {
            blockPaymentBandTelenor("QA");
            click(By.cssSelector("a[href='/en/security/relink']"));
            waitForSeveralItems(new String[]{"To link your payment band please enter your 9-digits payment band token", "Cancel", "Link new payment band", "Card number"});
            type(By.id("token"), "12345678");
            click(By.cssSelector("button[data-dpwa-action='band-relink']"));
            String hexColor = getColorOfElement(By.id("token"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

            click(By.cssSelector("a[href='/en/security/relink']"));
            waitForSeveralItems(new String[]{"To link your payment band please enter your 9-digits payment band token", "Cancel", "Link new payment band", "Card number"});
            type(By.id("token"), "12345678");
            click(By.cssSelector("button[data-dpwa-action='band-relink']"));
            String hexColor = getColorOfElement(By.id("token"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }
}
