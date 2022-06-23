package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
}