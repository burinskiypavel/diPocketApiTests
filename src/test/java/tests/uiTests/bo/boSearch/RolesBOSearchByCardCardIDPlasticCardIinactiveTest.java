package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOSearchByCardCardIDPlasticCardIinactiveTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String cardId = "185822";

    @Test
    public void testRolesBOSearchByCardCardIDPlasticCardIinactive() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        softAssert.assertTrue(areElementsPresent(new String[]{"//td[@ng-reflect-text='" + cardId + "']"}), "Incorrect headers");

        waitFor(By.xpath("//td[@ng-reflect-text='"+cardId+"']"));

//        softAssert.assertTrue(areElementsPresent(new String[]{"//td[@ng-reflect-text='"+cardId+"']", "//td[@ng-reflect-text='"+publicToken+"']",
//                "//td[@ng-reflect-text='"+dipToken+"']", "//td[@ng-reflect-text='"+clientId+"']",
//                "//td[@ng-reflect-text='"+cardholderName+"']"}), "Incorrect data in the table results");

        softAssert.assertAll();
    }

    public void gotoCardDetailsPage(String cardId) {
        click(By.xpath("//td[@ng-reflect-text='" + cardId + "']"));
    }
}