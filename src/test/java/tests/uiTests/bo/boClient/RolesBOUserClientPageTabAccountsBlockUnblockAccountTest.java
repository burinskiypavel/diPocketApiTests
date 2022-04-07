package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RolesBOUserClientPageTabAccountsBlockUnblockAccountTest extends UITestBase {
    String accountName = "test";
    String phone = "380634413376";
    String randomLimit = app.generateRandomNumber(4);
    int cardId = 187562;

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

    @Test(priority = 4)
    public void testRolesBOUserClientPageTabAccountsCardsTablesBlock() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        goToAccountsTab();
        click(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));

        waitFor(By.cssSelector("td[ng-reflect-text='Plastic']"));

        setClientPageFilter("id", "188989");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='188989']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='id'] input[type='text']"));

        setClientPageFilter("publicToken", "893529504");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='893529504']")));
        deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='publicToken'] input[type='text']"));

        setClientPageFilter("dipToken", "32842383");
        assertTrue(areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='32842383']")));
        performContextClick(By.cssSelector("td[ng-reflect-text='186406']"));

        assertTrue(areElementsPresent(new String[]{"//span[contains(text(), 'Block card')]", "//span[contains(text(), 'Unblock card')]",
        "//span[contains(text(), 'Get QR')]", "//span[contains(text(), 'Card limits')]", "//span[contains(text(), 'Reset pin counter')]",
        "//span[contains(text(), 'Reset ePin')]", "//span[contains(text(), 'Reset contactless counter')]",
        "//span[contains(text(), 'Activate card')]"}));
    }

    @Test(priority = 5)
    public void testRolesBOUserClientPageTabAccountsBlockCard () throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        goToAccountsTab();
        click(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));
        waitFor(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        performContextClick(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));


        if(isElementPresent(By.cssSelector("li[data-ik='1'] a[tabindex='0']"))){
            click(By.xpath("//li //span[contains(text(), 'Unblock card')]"));
            click(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        }


        click(By.xpath("//li //span[contains(text(), 'Block card')]"));

        assertTrue(areElementsPresent(new String[]{"//label[contains(text(), '41 Lost card (can be unblocked)')]", "//label[contains(text(), '43 Stolen card')]",
        "//label[contains(text(), '62 Restricted card')]", "//label[contains(text(), '83 Card destroyed')]"}));

        click(By.xpath("//label[contains(text(), '41 Lost card (can be unblocked)')]"));
        click(By.cssSelector("app-button[ng-reflect-label='Block']"));
        waitFor(By.xpath("//div[contains(text(), 'Card was blocked successfully')]"));
    }
}