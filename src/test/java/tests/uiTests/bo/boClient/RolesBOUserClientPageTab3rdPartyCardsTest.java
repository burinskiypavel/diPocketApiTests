package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class RolesBOUserClientPageTab3rdPartyCardsTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTab3rdPartyCards() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goTo3rdPartyCardsTab();
        waitFor(By.xpath("//thead //th[contains(text(), 'Card name')]"));
        List<String> actualElementsText = getActualText(By.xpath("//thead //th"));
        List<String> expectedElementsText = getDateFromFile("files/bo/boClient/Tab3rdPartyCards.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }
}