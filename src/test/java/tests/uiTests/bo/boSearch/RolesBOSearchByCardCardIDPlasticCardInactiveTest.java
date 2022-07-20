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
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        softAssert.assertTrue(areElementsPresent(new String[]{"//a[@role='tab'] //span[contains(text(), 'Card')]", "//a[@role='tab'] //span[contains(text(), 'Client')]",
                "//a[@role='tab'] //span[contains(text(), 'Transactions')]"}), "Incorrect tabs");
        softAssert.assertTrue(areButtonsPresent(new String[]{"//app-button[@ng-reflect-label='Back to search']",
                "//app-button[@ng-reflect-label='Show client info']", "//app-button[@ng-reflect-label='Operations']"}), "Incorrect buttons");
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOSearchByCardCardIDVerifyMaskedPan() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        String maskedPan = getText(By.xpath("//span[@class='maskedPan'] //span[1]"));
        click(By.xpath("//app-button[@label='Show']"));
        String pan = getText(By.xpath("//span[@class='maskedPan'] //span[1]"));

        softAssert.assertEquals(maskedPan, "545598******8829");
        softAssert.assertEquals(pan, "5455982163608829");
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOSearchByCardCardIDAccountLimits() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        click(By.xpath("//app-button[@label='Operations']"));
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Account limits')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Account limits')]"));

        softAssert.assertTrue(areElementsPresent(new String[]{"//table //th[contains(text(), 'Name')]", "//table //th[contains(text(), 'Type')]",
                "//table //th[contains(text(), 'Currency')]", "//table //th[contains(text(), 'Max amount')]", "//table //th[contains(text(), 'Limit amount')]"}), "Account limits has incorrect headers ");
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOSearchByCardCardIDBlockAccount() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        click(By.xpath("//app-button[@label='Operations']"));

        if(isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Unblock account')]"))){
            unblockAccountFromSearchByCard();
            click(By.xpath("//app-button[@label='Operations']"));
            waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block account')]"));
            waitFor(By.xpath("//*[contains(text(), 'Account limits')]"));
            waitFor(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        }

        blockAccountFromSearchByCard();
        click(By.xpath("//app-button[@label='Operations']"));

        assertTrue(isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Unblock account')]")));
    }

    @Test
    public void testRolesBOSearchByCardCardIDUnblockAccount() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        click(By.xpath("//app-button[@label='Operations']"));

        if(isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Block account')]"))){
            blockAccountFromSearchByCard();
            click(By.xpath("//app-button[@label='Operations']"));
            waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock account')]"));
            waitFor(By.xpath("//*[contains(text(), 'Account limits')]"));
            waitFor(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        }

        unblockAccountFromSearchByCard();
        click(By.xpath("//app-button[@label='Operations']"));

        assertTrue(isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Block account')]")));
    }

    @Test
    public void testRolesBOSearchByCardCardIDOverdraftLimit() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        click(By.xpath("//app-button[@label='Operations']"));
        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Overdraft limit')]"));
        type(By.xpath("//p-inputnumber[@id='formly_3_input-number_lowLimit_0'] //input"), "100");
        type(By.xpath("//p-inputnumber[@id='formly_3_input-number_highLimit_1'] //input"), "150");
        click(By.xpath("//p-button[@ng-reflect-label='Save']"));

        waitFor(By.xpath("//*[contains(text(), 'Account limits was changed successfully')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDBlockCard() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        click(By.xpath("//app-button[@label='Operations']"));

        if(isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Unblock card')]"))){
            unblockCardFromSearchByCard();
            click(By.xpath("//app-button[@label='Operations']"));
            waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block account')]"));
            waitFor(By.xpath("//*[contains(text(), 'Account limits')]"));
            waitFor(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        }

        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Block card')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Block card')]"));

        click(By.xpath("//p-radiobutton[@ng-reflect-value='41']"));
        Thread.sleep(1200);
        click(By.xpath("//p-button[@ng-reflect-label='Block']"));

        waitFor(By.xpath("//*[contains(text(), 'Card was blocked successfully')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDUnblockCard() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        click(By.xpath("//app-button[@label='Operations']"));

        if(isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Unblock card')]"))){


        }
        else if(isElementPresent(By.xpath("//a[@tabindex='0'] //span[contains(text(), 'Block card')]"))){
            blockCardFromSearchByCard();
            click(By.xpath("//app-button[@label='Operations']"));
            waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock account')]"));
            waitFor(By.xpath("//*[contains(text(), 'Account limits')]"));
            waitFor(By.xpath("//*[contains(text(), 'Overdraft limit')]"));
        }

        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock card')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Unblock card')]"));
        click(By.xpath("//p-button[@ng-reflect-label='Unblock']"));

        waitFor(By.xpath("//*[contains(text(), 'Card was unblocked successfully')]"));
    }

    @Test(enabled = false)
    public void testRolesBOSearchByCardCardIDUnblockCardCardHasStatCode43_83() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId2);
        gotoCardDetailsPage(cardId2);

        click(By.xpath("//app-button[@label='Operations']"));

        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Unblock card')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Unblock card')]"));
        click(By.xpath("//p-button[@ng-reflect-label='Unblock']"));

        waitFor(By.xpath("//*[contains(text(), 'Card was unblocked successfully')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDResetEpin() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardIdForResendPin);
        gotoCardDetailsPage(cardIdForResendPin);

        click(By.xpath("//app-button[@label='Operations']"));

        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Reset ePin')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Reset ePin')]"));
        click(By.xpath("//p-button[@ng-reflect-label='Reset']"));

        waitFor(By.xpath("//*[contains(text(), 'Card ePin has been successfully reset')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDChargeFee() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        click(By.xpath("//app-button[@label='Operations']"));

        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Charge Fee')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Charge Fee')]"));
        fillAndPressDoneManualFeeChargePopUp("F", "test", "Fee for Cashback", "1000");

        waitFor(By.xpath("//*[contains(text(), 'Incorrect user (UserName = EVGENYA) role, expected: FINANCE, actual: BO')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDResendPIN() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardIdForResendPin);
        gotoCardDetailsPage(cardIdForResendPin);

        click(By.xpath("//app-button[@label='Operations']"));

        waitForElementToBeClickable(By.xpath("//*[contains(text(), 'Resend PIN')]"));
        click(By.xpath("//a[@role='menuitem'] //span[contains(text(), 'Resend PIN')]"));
        waitFor(By.xpath("//p-button[@ng-reflect-label='Proceed']"));
        click(By.xpath("//p-button[@ng-reflect-label='Proceed']"));

        waitFor(By.xpath("//*[contains(text(), 'PIN was successfully resent')]"));
    }

    @Test
    public void testRolesBOSearchByCardCardIDTransactionsTAB() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);
        goToTransactionsTab();
        selectFromDropDown("value", "All");
        click(By.xpath("//p-button[@ng-reflect-label='Search']"));
        waitFor(By.xpath("//td[@ng-reflect-text='629314']"));
        List<String> actualElementsText = getActualText(By.xpath("//table //tbody //tr"));
        List<String> expectedElementsText = getDateFromFile("files/bo/TransactionTabData.txt");

        assertThat(actualElementsText, equalTo(expectedElementsText));
    }

    @Test
    public void testRolesBOSearchByCardCardIDClientTAB() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);
        goToCardClientInfoTab();

        List<String> actualElementsText = getActualText(By.xpath("//table //tr"));
        List<String> expectedElementsText = getDateFromFile("files/bo/ClientTabPage.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }

    @Test
    public void testRolesBOSearchByCardCardIDShowClientInfo() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);
        click(By.xpath("//app-button[@ng-reflect-label='Show client info']"));
        waitForElementToBeClickable(By.xpath("//app-client-details //p"));
        waitFor(By.xpath("//app-client-button-block"));

        List<String> actualElementsText = getActualText(By.xpath("//app-client-details //p"));
        List<String> expectedElementsText = getDateFromFile("files/bo/ShowClientInfo.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }

    @Test
    public void testRolesBOSearchByCardCardIDBackToSearch() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);
        click(By.xpath("//app-button[@ng-reflect-label='Back to search']"));
        waitFor(By.id("searchContent"));

        List<String> actualElementsText = getActualText(By.cssSelector("#searchContent label"));
        List<String> expectedElementsText = getDateFromFile("files/bo/boSearch/backToSearch.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }
}