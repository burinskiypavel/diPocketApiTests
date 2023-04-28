package tests.uiTests.bo.boSearch;

import base.UITestBase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RolesBOSearchByCardCardIDPlasticCardInactiveTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String cardId = "185822";
    String cardId2 = "185777";
    String cardId3 = "184046";
    String cardIdForResendPin = "178359";

    @Test
    public void testRolesBOSearchByCardCardIDPlasticCardInactive() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//a[@role='tab'] //span[contains(text(), 'Info')]", "//a[@role='tab'] //span[contains(text(), 'Client')]",
                "//a[@role='tab'] //span[contains(text(), 'Transactions')]"}), "Incorrect tabs");
        softAssert.assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//app-button[@ng-reflect-label='Back to search']",
                "//app-button[@ng-reflect-label='Show client info']", "//app-button[@ng-reflect-label='Operations']"}), "Incorrect buttons");
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOSearchByCardCardIDVerifyMaskedPan() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);

        String maskedPan = app.getUiboHelper().getText(By.xpath("//span[@class='maskedPan'] //span[1]"));
        app.getUiboHelper().click(By.xpath("//app-button[@label='Show']"));
        String pan = app.getUiboHelper().getText(By.xpath("//span[@class='maskedPan'] //span[1]"));

        softAssert.assertEquals(maskedPan, "545598******8829");
        softAssert.assertEquals(pan, "5455982163608829");
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOSearchByCardCardIDAccountLimits() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);
        app.getUiboCardHelper().clickOperations();
        app.getUiboCardHelper().clickAccountsLimits();
        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//app-account-limits //table //tr"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boCard/searchByCardCardIDAccountLimits.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }

    @Test
    public void testRolesBOSearchByCardCardIDBlockAccount() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);

        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));

        if(app.getUiboHelper().isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Unblock account')]"))){
            app.getUiboCardHelper().unblockAccountFromSearchByCard();
            app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));
            app.getUiboHelper().waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block account')]"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Account limits')]"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        }

        app.getUiboHelper().blockAccountFromSearchByCard();
        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));

        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Unblock account')]")));
    }

    @Test
    public void testRolesBOSearchByCardCardIDUnblockAccount() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);

        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));

        if(app.getUiboHelper().isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Block account')]"))){
            app.getUiboHelper().blockAccountFromSearchByCard();
            app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));
            app.getUiboHelper().waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock account')]"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Account limits')]"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        }

        app.getUiboCardHelper().unblockAccountFromSearchByCard();
        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));

        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Block account')]")));
    }

    @Test
    public void testRolesBOSearchByCardCardIDOverdraftLimit() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);
        app.getUiboCardHelper().clickOperations();
        app.getUiboCardHelper().overdraftLimit("100", "150");
    }

    @Test
    public void testRolesBOSearchByCardCardIDBlockCard() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);

        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));

        if(app.getUiboHelper().isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Unblock card')]"))){
            app.getUiboHelper().unblockCardFromSearchByCard();
            app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));
            app.getUiboHelper().waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block account')]"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Account limits')]"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        }

        app.getUiboHelper().waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block card')]"));
        app.getUiboHelper().click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Block card')]"));

        app.getUiboHelper().click(By.xpath("//p-radiobutton[@ng-reflect-value='41']"));
        Thread.sleep(1200);
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Block']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Card was blocked successfully')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDUnblockCard() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);

        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));

        if(app.getUiboHelper().isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Unblock card')]"))){


        }
        else if(app.getUiboHelper().isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Block card')]"))){
            app.getUiboHelper().blockCardFromSearchByCard();
            app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));
            app.getUiboHelper().waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock account')]"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Account limits')]"));
            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        }

        app.getUiboHelper().waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock card')]"));
        app.getUiboHelper().click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Unblock card')]"));
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Unblock']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Card was unblocked successfully')]"));
    }

    @Test(enabled = false)
    public void testRolesBOSearchByCardCardIDUnblockCardCardHasStatCode43_83() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId2);
        app.getUiboHelper().gotoCardDetailsPage(cardId2);

        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));

        app.getUiboHelper().waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock card')]"));
        app.getUiboHelper().click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Unblock card')]"));
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Unblock']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Card was unblocked successfully')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDResetEpin() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardIdForResendPin);
        app.getUiboHelper().gotoCardDetailsPage(cardIdForResendPin);
        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));
        app.getUiboCardHelper().resetEpin();
    }

    @Test
    public void testRolesBOSearchByCardCardIDChargeFee() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);

        app.getUiboHelper().click(By.xpath("//app-button[@label='Operations']"));

        app.getUiboHelper().waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Charge Fee')]"));
        app.getUiboHelper().click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Charge Fee')]"));
        app.getUiboHelper().fillAndPressDoneManualFeeChargePopUp("F", "test", "Fee for Cashback", "1000");

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Incorrect user (UserName = PAVELB_AUTO_BO) role, expected: FINANCE, actual: BO')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDResendPIN() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardIdForResendPin);
        app.getUiboHelper().gotoCardDetailsPage(cardIdForResendPin);
        app.getUiboCardHelper().clickOperations();
        app.getUiboCardHelper().resendPIN();
    }
    @Test
    public void testRolesBOSearchByCardCardIDTransactionsTAB() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);
        app.getUiboCardHelper().goToTransactionsTab();
        app.getUiboCardHelper().searchByTime("All");
        app.getUiboHelper().waitFor(By.xpath("//td //span[@ng-reflect-text='629314']"));
        List<String> actualElementsText = app.getUiboHelper().getActualTextFirstElementsReplaceLineSeparator(By.xpath("//table //tbody //tr"), 34);
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boCard/transactionTabData.txt");

        assertThat(actualElementsText, equalTo(expectedElementsText));
    }

    @Test
    public void testRolesBOSearchByCardCardIDClientTAB() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);
        app.getUiboHelper().goToCardClientInfoTab();

        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//table //tr"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boSearch/ClientTabPage.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }

    @Test
    public void testRolesBOSearchByCardCardIDShowClientInfo() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);
        app.getUiboCardHelper().pressShowClientInfo();
        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//app-client-details //p"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boSearch/ShowClientInfo.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }

    @Test
    public void testRolesBOSearchByCardCardIDBackToSearch() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);
        app.getUiboCardHelper().clickBackToSearch();
        List<String> actualElementsText = app.getUiboHelper().getActualText(By.cssSelector("#searchContent label"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boSearch/backToSearch.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }
}