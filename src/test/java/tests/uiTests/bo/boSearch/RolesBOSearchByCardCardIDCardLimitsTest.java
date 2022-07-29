package tests.uiTests.bo.boSearch;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RolesBOSearchByCardCardIDCardLimitsTest extends UITestBase {
    String cardId = "185822";

    @Test
    public void testRolesBOSearchByCardCardIDCardLimits() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().gotoCardSearchTab();
        app.getUiboHelper().searchByCard("id", cardId);
        app.getUiboHelper().gotoCardDetailsPage(cardId);

        app.getUiboHelper().pressOperationsSelectValueFromOperation("Card limits");

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Card id')]"));

        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//div[@role='dialog'] //p"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boSearch/CardLimits.txt");

        assertEquals(actualElementsText, expectedElementsText);

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Card id')]", "//*[contains(text(), 'Card type')]",
                "//*[contains(text(), 'Currency symbol')]", "//*[contains(text(), 'Annual max amount')]", "//*[contains(text(), 'Annual max amount')]", "//*[contains(text(), 'Annual available amount')]"}), "Card limits are incorrect");
    }
}
