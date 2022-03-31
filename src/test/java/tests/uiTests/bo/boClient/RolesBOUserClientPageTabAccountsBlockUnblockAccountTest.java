package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabAccountsBlockUnblockAccountTest extends UITestBase {
    String accountName = "test";
    String phone = "380634413376";
    String randomLimit = app.generateRandomNumber(4);

    @Test(priority = 1)
    public void testRolesBOUserClientPageTabAccountsBlockAccount() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        goToAccountsTab();
        performContextClick(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));

        if(!isElementPresent(By.cssSelector("li[data-ik='2'] a[tabindex='0']"))){
            unblockAccount();
            moveToElementAndPerformContextClick(accountName);
        }

        String actualPopupText = blockAccount();

        assertEquals(actualPopupText, "Are you sure want to block account with name: "+accountName+"?");

//        Thread.sleep(500);
//        moveToElement(By.xpath("//td[text() = '"+accountName+"']"));
//        Thread.sleep(1000);
//        String actualState = driver.findElement(By.xpath("//td[text() = 'test']/following-sibling::td[1]")).getText();
//
//        assertEquals(actualState, "Active(Blocked)");
    }

    @Test(priority = 2)
    public void testRolesBOUserClientPageTabAccountsUnblockAccount() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        goToAccountsTab();
        performContextClick(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));

        if(isElementPresent(By.cssSelector("li[data-ik='2'] a[tabindex='0']"))){
            boClientPageBlockAccount();
            moveToElementAndPerformContextClick(accountName);
        }

        String actualPopupText = unblockAccountAndGetPopupText();

        assertEquals(actualPopupText, "Are you sure want to unblock account with name: "+accountName+"?");
    }

    @Test(priority = 3)
    public void testRolesBOUserClientPageTabAccountsOverdraftLimit() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        goToAccountsTab();
        performContextClick(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));

        click(By.xpath("//span[contains(text(), 'Overdraft limit')]"));
        updateLimits(randomLimit, randomLimit);

        assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'Account limits was changed successfull')]")));
    }
}