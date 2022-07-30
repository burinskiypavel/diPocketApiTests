package tests.uiTests.telenor;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertFalse;

public class TelenorOffloadFundsWithoutDataInAccountFieldTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @Test(priority = 1)
    public void testOffloadFundsWithoutDataInAccountFiel() throws InterruptedException {
        app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        app.getUiTelenorHelper().gotoOffloadFundsPage();
        app.getUiTelenorHelper().type(By.id("accountNo"), "");
        app.getUiTelenorHelper().clickCheckbox(By.name("agreeDelete"));
        String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("accountNo"), "border-color");

        assertFalse(app.getUiTelenorHelper().isCheckboxSelected(By.name("agreeDelete")));
        assertThat(hexColor, equalTo(app.hexRedColor));
        assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.cssSelector("button[data-dpwa-action='offload-confirm']")));
    }
}