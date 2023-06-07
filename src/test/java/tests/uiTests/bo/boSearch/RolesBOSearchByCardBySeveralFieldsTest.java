package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

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
        app.getUiboCardHelper().searchByCardBySeveralFields(cardId, publicToken, dipToken, pan, clientId, cardholderName);

        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//thead //tr //th"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boSearch/rolesBOSearchByCardBySeveralFieldsTableHeaders.txt");

        softAssert.assertEquals(actualElementsText, expectedElementsText);

        softAssert = app.getUiboCardHelper().verifySearchInformationPresentInSearchResults(softAssert, cardId, publicToken, dipToken, clientId, cardholderName);

        softAssert.assertAll();
    }
}