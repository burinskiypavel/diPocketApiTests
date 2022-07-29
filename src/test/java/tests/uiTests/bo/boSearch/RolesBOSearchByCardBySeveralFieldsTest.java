package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RolesBOSearchByCardBySeveralFieldsTest extends UITestBase {
    String cardId = "185890";
    String publicToken = "893518549";
    String dipToken = "51783109";
    String pan = "5455982146179773";
    String clientId = "33217";
    String cardholderName = "Nona Qwertii";
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testRolesBOSearchByCardBySeveralFields() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCardBySeveralFields(cardId, publicToken, dipToken, pan, clientId, cardholderName);

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//table //th[contains(text(), 'Card id')]",
                "//table //th[contains(text(), 'Public token')]", "//table //th[contains(text(), 'DiP token')]",
                "//table //th[contains(text(), 'Masked PAN')]", "//table //th[contains(text(), 'Client id')]",
                "//table //th[contains(text(), 'Client')]", "//table //th[contains(text(), 'Cardholder name')]"}), "Incorrect headers");

        app.getUiboHelper().waitFor(By.xpath("//td[@ng-reflect-text='"+cardId+"']"));

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//td[@ng-reflect-text='"+cardId+"']", "//td[@ng-reflect-text='"+publicToken+"']",
        "//td[@ng-reflect-text='"+dipToken+"']", "//td[@ng-reflect-text='"+clientId+"']",
        "//td[@ng-reflect-text='"+cardholderName+"']"}), "Incorrect data in the table results");

        softAssert.assertAll();
    }
}