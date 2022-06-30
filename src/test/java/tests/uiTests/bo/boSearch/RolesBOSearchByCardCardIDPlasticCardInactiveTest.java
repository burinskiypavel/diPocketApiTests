package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class RolesBOSearchByCardCardIDPlasticCardInactiveTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String cardId = "185822";

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
}