package tests.uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorEmptyFieldEmailTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1)
    public void testEmptyFieldEmail() throws InterruptedException {
        navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        gotoManageSecurityPage();
        gotoChangeEmail();
        waitForSeveralItems(new String[]{"Confirm", "Cancel", "Change E-mail"});
        type(By.id("email"), "");
        pressConfirm(By.cssSelector("button[data-dpwa-action='email-verify']"));
        String hexColor = getColorOfElement(By.id("email"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
    }
}
