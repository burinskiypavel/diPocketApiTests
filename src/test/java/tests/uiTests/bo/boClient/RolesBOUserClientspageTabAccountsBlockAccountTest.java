package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
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
            unblockAccount();
            moveToElementAndPerformContextClick("test");
        }

        click(By.xpath("//span[contains(text(), 'Block account')]"));
        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-block-account-modal p"));
        click(By.cssSelector("app-button[label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Account was blocked successfully')]"));

        assertEquals(actualPopupText, "Are you sure want to block account with name: test?");

//        Thread.sleep(500);
//        moveToElement(By.xpath("//td[text() = 'test']"));
//        moveToElement(By.xpath("//td[text() = 'test']"));
//        Thread.sleep(1000);
//        String actualState = driver.findElement(By.xpath("//td[text() = 'test']/following-sibling::td[1]")).getText();
//
//        Assert.assertEquals(actualState, "Active(Blocked)");
    }
}