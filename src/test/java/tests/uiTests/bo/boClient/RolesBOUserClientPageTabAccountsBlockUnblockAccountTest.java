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
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToAccountsTab();
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));

        if(!app.getUiboHelper().isElementPresent(By.cssSelector("li[data-ik='2'] a[tabindex='0']"))){
            app.getUiboHelper().unblockAccount();
            app.getUiboHelper().moveToElementAndPerformContextClick(accountName);
        }

        String actualPopupText = app.getUiboHelper().blockAccount();

        assertEquals(actualPopupText, "Are you sure want to block account with name: "+accountName+"?");

        app.getUiboHelper().moveToElement(By.xpath("//td[text() = '"+accountName+"']"));
        String actualState = app.getUiboHelper().getText(By.xpath("//app-accounts-table //tbody //tr[1] //td[2]"));

        assertEquals(actualState, "Active(Blocked)");
    }

    @Test(priority = 2)
    public void testRolesBOUserClientPageTabAccountsUnblockAccount() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToAccountsTab();
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));

        if(app.getUiboHelper().isElementPresent(By.cssSelector("li[data-ik='2'] a[tabindex='0']"))){
            app.getUiboHelper().boClientPageBlockAccount();
            app.getUiboHelper().moveToElementAndPerformContextClick(accountName);
        }

        String actualPopupText = app.getUiboHelper().unblockAccountAndGetPopupText();

        assertEquals(actualPopupText, "Are you sure want to unblock account with name: "+accountName+"?");

        app.getUiboHelper().moveToElement(By.xpath("//td[text() = '"+accountName+"']"));
        String actualState = app.getUiboHelper().getText(By.xpath("//app-accounts-table //tbody //tr[1] //td[2]"));

        assertEquals(actualState, "Active");
    }

    @Test(priority = 3)
    public void testRolesBOUserClientPageTabAccountsOverdraftLimit() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToAccountsTab();
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));

        app.getUiboHelper().click(By.xpath("//span[contains(text(), 'Overdraft limit')]"));
        app.getUiboHelper().updateLimits(randomLimit, randomLimit);

        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//div[contains(text(), 'Account limits was changed successfull')]")));
    }

    @Test(priority = 4)
    public void testRolesBOUserClientPageTabAccountsCardsTablesBlock() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId2, phone2);
        app.getUiboHelper().goToClientPage(phone2);
        app.getUiboHelper().goToAccountsTab();
        app.getUiboHelper().click(By.cssSelector("td[ng-reflect-text='"+accountName2+"']"));

        app.getUiboHelper().waitFor(By.cssSelector("td[ng-reflect-text='Plastic']"));

        app.getUiboHelper().setClientPageFilter("id", "188989");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='188989']")));
        app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='id'] input[type='text']"));

        app.getUiboHelper().setClientPageFilter("publicToken", "893529504");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='893529504']")));
        app.getUiboHelper().deleteTextFromTextarea(By.cssSelector("p-columnfilter[field='publicToken'] input[type='text']"));

        app.getUiboHelper().setClientPageFilter("dipToken", "32842383");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.cssSelector("td[ng-reflect-text='32842383']")));
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='186406']"));

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
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToAccountsTab();
        app.getUiboHelper().click(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));
        app.getUiboHelper().waitFor(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));

        if(app.getUiboHelper().isElementPresent(By.cssSelector("li[data-ik='1'] a[tabindex='0']"))){
            app.getUiboHelper().unblockCard();
            app.getUiboHelper().moveToElement(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
            app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        }

        app.getUiboHelper().blockCard();

        app.getUiboHelper().moveToElement(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        String actualState = app.getUiboHelper().getNextElementFromTheTable(cardId, 3);

        assertEquals(actualState, "Blocked");
    }

    @Test(priority = 6)
    public void testRolesBOUserClientPageTabAccountsUnblockCard() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToAccountsTab();
        app.getUiboHelper().click(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));
        app.getUiboHelper().waitFor(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));

        if(app.getUiboHelper().isElementPresent(By.cssSelector("li[data-ik='0'] a[tabindex='0']"))){
            app.getUiboHelper().blockCard();
            app.getUiboHelper().moveToElement(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
            app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        }

        app.getUiboHelper().unblockCard();
        app.getUiboHelper().moveToElement(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        String actualState = app.getUiboHelper().getNextElementFromTheTable(cardId, 3);

        assertEquals(actualState, "Active");
    }

    @Test(priority = 7)
    public void testRolesBOUserClientPageTabAccountsCardLimits() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToAccountsTab();
        app.getUiboHelper().click(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));
        app.getUiboHelper().waitFor(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        app.getUiboHelper().click(By.xpath("//li //span[contains(text(), 'Card limits')]"));
        app.getUiboHelper().waitFor(By.xpath("//span[contains(text(), 'Card id:')]"));

        List<String> actualElementsHeaderText = app.getUiboHelper().getActualText(By.xpath("//app-card-limits-modal //app-limits-info //span[@class='pr-3']"));
        List<String> expectedElementsHeaderText = app.getUiboHelper().getDateFromFile("files/bo/boClient/rolesBOUserClientPageTabAccountsCardLimitsHeader.txt");

        assertEquals(actualElementsHeaderText, expectedElementsHeaderText);

        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//app-card-limits-modal //p"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boClient/rolesBOUserClientPageTabAccountsCardLimits.txt");

        assertEquals(actualElementsText, expectedElementsText);

        app.getUiboHelper().closePopUp(By.cssSelector("span.p-dialog-header-close-icon"));
        app.getUiboHelper().waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
    }

    @Test(priority = 8)
    public void testRolesBOUserClientPageTabAccountsResetContactlessCounters() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goToAccountsTab();
        app.getUiboHelper().click(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));
        app.getUiboHelper().waitFor(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        app.getUiboHelper().performContextClick(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
        app.getUiboHelper().click(By.xpath("//li //span[contains(text(), 'Reset contactless counter')]"));
        String actualPopupText = app.getUiboHelper().getTextFromPopUp2(By.cssSelector("app-reset-contactless-counter-modal p"));
        app.getUiboHelper().click(By.cssSelector("app-button[label='Reset']"));
        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Contactless counter was successfully reset')]"));

        assertEquals(actualPopupText, "Are you sure you want to reset contactless counter for card "+cardId+"?");
    }
}