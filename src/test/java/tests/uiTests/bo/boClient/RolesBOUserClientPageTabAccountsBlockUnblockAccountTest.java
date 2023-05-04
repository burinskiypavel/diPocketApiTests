package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class RolesBOUserClientPageTabAccountsBlockUnblockAccountTest extends UITestBase {
    String accountName = "Main Account";
    String accountName2 = "test";
    String phone2 = "380634413376";
    String randomLimit = app.generateRandomNumber(4);
    String cardId = "186658"; // 187562
    String clientId2 = "33217";
    String phone = "380980316499";
    String clientId = "34138";

    @Test(priority = 1)
    public void testRolesBOUserClientPageTabAccountsBlockAccount() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboClientHelper().selectAccountFromAccountTableAndPerformContextClick(accountName);


        if(!app.getUiboHelper().isElementPresent(By.cssSelector("li[data-ik='2'] a[tabindex='0']"))){
            app.getUiboClientHelper().unblockAccount();
            app.getUiboHelper().moveToElementAndPerformContextClick(accountName);
        }

        String actualPopupText = app.getUiboClientHelper().blockAccountGetPopupText();

        assertEquals(actualPopupText, "Are you sure want to block account with name: "+accountName+"?");

        app.getUiboHelper().moveToElement(By.cssSelector("td span[ng-reflect-text='"+accountName+"']"));
        String actualState = app.getUiboHelper().getText(By.xpath("//p-tabpanel[@header='Accounts'] //tbody //tr[1] //td[2]"));

        assertEquals(actualState, "Active(Blocked)");
    }

    @Test(priority = 2)
    public void testRolesBOUserClientPageTabAccountsUnblockAccount() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboClientHelper().selectAccountFromAccountTableAndPerformContextClick(accountName);

        if(app.getUiboHelper().isElementPresent(By.cssSelector("li[data-ik='2'] a[tabindex='0']"))){
            app.getUiboClientHelper().blockAccount();
            app.getUiboHelper().moveToElementAndPerformContextClick(accountName);
        }

        String actualPopupText = app.getUiboClientHelper().unblockAccountAndGetPopupText();

        assertEquals(actualPopupText, "Are you sure want to unblock account with name: "+accountName+"?");

        app.getUiboHelper().moveToElement(By.cssSelector("td span[ng-reflect-text='"+accountName+"']"));
        String actualState = app.getUiboHelper().getText(By.xpath("//p-tabpanel[@header='Accounts'] //tbody //tr[1] //td[2]"));

        assertEquals(actualState, "Active");
    }

    @Test(priority = 3)
    public void testRolesBOUserClientPageTabAccountsOverdraftLimit() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboClientHelper().selectAccountFromAccountTableAndPerformContextClick(accountName);
        app.getUiboClientHelper().overdraftLimitUpdateAccountLimits(randomLimit, randomLimit);

        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//div[contains(text(), 'Account limits was changed successfull')]")));
    }

    @Test(priority = 4)
    public void testRolesBOUserClientPageTabAccountsCardsTablesBlock() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId2, phone2);
        app.getUiboClientHelper().goToClientPage(phone2);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboClientHelper().selectAccountNameFromAccountTableAndWaitCardPresentInCardTable("Auto PLN test", "Plastic");

        app.getUiboClientHelper().verifyClientPageFilter(By.xpath("//app-table[2] //p-columnfilter[@ng-reflect-field='id'] //input"), "188975", "id", By.cssSelector("td span[ng-reflect-text='188975']"));
        app.getUiboClientHelper().verifyClientPageFilter(By.xpath("//app-table[2] //p-columnfilter[@ng-reflect-field='publicToken'] //input"), "668789330", "publicToken", By.cssSelector("td span[ng-reflect-text='668789330']"));
        app.getUiboClientHelper().verifyClientPageFilter(By.xpath("//app-table[2] //p-columnfilter[@ng-reflect-field='dipToken'] //input"), "94890352", "dipToken", By.cssSelector("td span[ng-reflect-text='94890352']"));
        app.getUiboClientHelper().selectCardFromCardTablePerformContextClick("186377");

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//span[contains(text(), 'Block card')]", "//span[contains(text(), 'Unblock card')]",
        "//span[contains(text(), 'Get QR')]", "//span[contains(text(), 'Card limits')]", "//span[contains(text(), 'Reset pin counter')]",
        "//span[contains(text(), 'Reset ePin')]", "//span[contains(text(), 'Reset contactless counter')]",
        "//span[contains(text(), 'Activate card')]"}));
    }

    @Test(priority = 5)
    public void testRolesBOUserClientPageTabAccountsBlockCard() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboClientHelper().selectAccountNameFromAccountTableAndWaitCardPresentInCardTable(accountName, cardId);
        app.getUiboClientHelper().selectCardFromCardTablePerformContextClick(cardId);

        if(app.getUiboHelper().isElementPresent(By.cssSelector("li[data-ik='1'] a[tabindex='0']"))){
            app.getUiboClientHelper().unblockCard();
            app.getUiboHelper().moveToElement(By.cssSelector("td span[ng-reflect-text='"+cardId+"']"));
            app.getUiboHelper().performContextClick(By.cssSelector("td span[ng-reflect-text='"+cardId+"']"));
        }

        app.getUiboClientHelper().blockCard();

        app.getUiboHelper().moveToElement(By.cssSelector("td span[ng-reflect-text='"+cardId+"']"));
        String actualState = app.getUiboClientHelper().getStateFromCardTable(By.xpath("//app-accounts //app-table[2] //tbody/tr[1]/td[4]"));

        assertEquals(actualState, "Blocked");
    }

    @Test(priority = 6)
    public void testRolesBOUserClientPageTabAccountsUnblockCard() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboClientHelper().selectAccountNameFromAccountTableAndWaitCardPresentInCardTable(accountName, cardId);
        app.getUiboClientHelper().selectCardFromCardTablePerformContextClick(cardId);

        if(app.getUiboHelper().isElementPresent(By.cssSelector("li[data-ik='0'] a[tabindex='0']"))){
            app.getUiboClientHelper().blockCard();
            app.getUiboHelper().moveToElement(By.cssSelector("td span[ng-reflect-text='"+cardId+"']"));
            app.getUiboHelper().performContextClick(By.cssSelector("td span[ng-reflect-text='"+cardId+"']"));
        }

        app.getUiboClientHelper().unblockCard();
        app.getUiboHelper().moveToElement(By.cssSelector("td span[ng-reflect-text='"+cardId+"']"));
        String actualState = app.getUiboClientHelper().getStateFromCardTable(By.xpath("//app-accounts //app-table[2] //tbody/tr[1]/td[4]"));

        assertEquals(actualState, "Active");
    }

    @Test(priority = 7)
    public void testRolesBOUserClientPageTabAccountsCardLimits() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboClientHelper().selectAccountNameFromAccountTableAndWaitCardPresentInCardTable(accountName, cardId);
        app.getUiboClientHelper().selectCardFromCardTablePerformContextClick(cardId);
        app.getUiboClientHelper().clickCardLimits();

        List<String> actualElementsHeaderText = app.getUiboHelper().getActualText(By.xpath("//app-card-limits //app-limits-info //span[@class='pr-3']"));
        List<String> expectedElementsHeaderText = app.getUiboHelper().getDateFromFile("files/bo/boClient/rolesBOUserClientPageTabAccountsCardLimitsHeader.txt");
        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//app-card-limits //p"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boClient/rolesBOUserClientPageTabAccountsCardLimits.txt");

        app.getUiboHelper().closePopUp(By.cssSelector("timesicon[ng-reflect-style-class='p-dialog-header-close-icon']"));
        app.getUiboHelper().waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));

        assertEquals(actualElementsHeaderText, expectedElementsHeaderText);
        assertEquals(actualElementsText, expectedElementsText);
    }

    @Test(priority = 8)
    public void testRolesBOUserClientPageTabAccountsResetContactlessCounters() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToAccountsTab();
        app.getUiboClientHelper().selectAccountNameFromAccountTableAndWaitCardPresentInCardTable(accountName, cardId);
        app.getUiboClientHelper().selectCardFromCardTablePerformContextClick(cardId);
        String actualPopupText = app.getUiboClientHelper().resetContactlessCounter();

        assertEquals(actualPopupText, "Are you sure you want to reset contactless counter for card "+cardId+"?");
    }
}