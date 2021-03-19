package uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class TelenorTopUpTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1)
    public void testCheckFieldTopUpAmountWithDataGreaterThanHUF45000() throws SQLException, ClassNotFoundException, InterruptedException {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone, smsCode);
        type(By.id("dpwa-amount"), "11111111");
        click(By.cssSelector("button[data-dpwa-action='dpwa-topup']"));
        String popUpMessage = getTextFromPopUp();
        closePopUp(By.xpath("//button[contains(text(), 'Ok')]"));

        assertTrue(isPopUpClosed());
        assertThat(popUpMessage, equalTo("The amount you entered is above the maximum limit, which is HUF 45000.00 for this type of transaction"));
    }
}
