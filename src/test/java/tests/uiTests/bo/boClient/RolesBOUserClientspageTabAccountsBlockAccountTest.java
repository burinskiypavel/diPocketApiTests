package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientspageTabAccountsBlockAccountTest extends UITestBase {

    @Test
    public void testRolesBOUserClientspageTabAccountsBlockAccount() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        type(By.cssSelector("app-input-number[ng-reflect-name='id'] input.p-inputnumber-input"), "33217");
        waitFor(By.cssSelector("td[ng-reflect-text='380634413376']"));
        click(By.cssSelector("td[ng-reflect-text='380634413376']"));
        waitFor(By.cssSelector("p.user-name"));
        click(By.id("p-tabpanel-8-label"));
        performContextClick(By.cssSelector("td[ng-reflect-text='test']"));

        if(!isElementPresent(By.cssSelector("li[data-ik='2'] a[tabindex='0']"))){
            click(By.xpath("//span[contains(text(), 'Unblock account')]"));
            click(By.cssSelector("app-button[label='Unblock']"));
            waitFor(By.xpath("//div[contains(text(), 'Account was unblocked successfully')]"));
            Thread.sleep(2500);

            moveToElement(By.cssSelector("td[ng-reflect-text='test']"));
            Thread.sleep(1500);
            performContextClick(By.cssSelector("td[ng-reflect-text='test']"));
            waitForElementToBeClickable(By.xpath("//span[contains(text(), 'Block account')]"));
            Thread.sleep(2500);
        }

        click(By.xpath("//span[contains(text(), 'Block account')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-block-account-modal p"));
        click(By.cssSelector("app-button[label='Block']"));

        Assert.assertEquals(actualPopupText, "Are you sure want to block account with name: test?");

        //assertTrue(areElementsPresent(new String[]{"//th[contains(text(), 'Name')]", "//th[contains(text(), 'Type')]", "//th[contains(text(), 'Currency')]", "//th[contains(text(), 'Max amount')]", "//th[contains(text(), 'Limit amount')]"}));
    }
}