package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RolesBOSearchByCardCardIDCardLimits extends UITestBase {
    String cardId = "185822";

    @Test
    public void testRolesBOSearchByCardCardIDCardLimits() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        gotoCardSearchTab();
        searchByCard("id", cardId);
        gotoCardDetailsPage(cardId);

        pressOperationsSelectValueFromOperation("Card limits");

        waitFor(By.xpath("//*[contains(text(), 'Card id')]"));

        List<String> actualElementsText = getActualText(By.xpath("//div[@role='dialog'] //p"));
        List<String> expectedElementsText = getDateFromFile("files/bo/CardLimits.txt");

        assertEquals(actualElementsText, expectedElementsText);

        assertTrue(areElementsPresent(new String[]{"//*[contains(text(), 'Card id')]", "//*[contains(text(), 'Card type')]",
                "//*[contains(text(), 'Currency symbol')]", "//*[contains(text(), 'Annual max amount')]", "//*[contains(text(), 'Annual max amount')]", "//*[contains(text(), 'Annual available amount')]"}), "Card limits are incorrect");
    }
}
