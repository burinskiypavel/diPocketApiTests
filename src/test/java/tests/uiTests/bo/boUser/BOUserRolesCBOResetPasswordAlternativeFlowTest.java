package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOResetPasswordAlternativeFlowTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOResetPasswordAlternativeFlow() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoAllUsersTab();
        type(By.cssSelector("p-tabpanel[header='All users'] p-columnfilter[field='username'] input[type='text']"), "PAVELB");
        Actions actions = new Actions(driver);
        Action seriesOfActions = actions
                .sendKeys(Keys.ENTER).build();
        seriesOfActions.perform() ;

        click(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='Burinskiy']"));
        Thread.sleep(500);
        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Reset password']"));

        waitFor(By.cssSelector("div[role='dialog']"));
        waitForSeveralItems(new String[]{"Are you sure want to reset password and send new one?"});
        click(By.cssSelector("span.p-dialog-header-close-icon"));

        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog']")));

        assertFalse(isElementPresent(By.cssSelector("div[role='dialog']")));
    }
}