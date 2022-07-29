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
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);
        app.getUiboHelper().goTo3rdPartyCardsTab();
        app.getUiboHelper().waitFor(By.xpath("//thead //th[contains(text(), 'Card name')]"));
        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//thead //th"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boClient/Tab3rdPartyCards.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }
}