package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTab3rdPartyCardsTest extends UITestBase {
    String accountName = "test";
    String phone = "380634413376";
    String randomLimit = app.generateRandomNumber(4);
    String cardId = "187562";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTab3rdPartyCards() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goTo3rdPartyCardsTab();
//        click(By.cssSelector("td[ng-reflect-text='"+accountName+"']"));
//        waitFor(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
//        performContextClick(By.cssSelector("td[ng-reflect-text='"+cardId+"']"));
//        click(By.xpath("//li //span[contains(text(), 'Reset contactless counter')]"));
//        String actualPopupText = getTextFromPopUp2(By.cssSelector("app-reset-contactless-counter-modal p"));
//        click(By.cssSelector("app-button[label='Reset']"));
//        waitFor(By.xpath("//div[contains(text(), 'Contactless counter was successfully reset')]"));
//
//        assertEquals(actualPopupText, "Are you sure you want to reset contactless counter for card 187562?");
    }
}