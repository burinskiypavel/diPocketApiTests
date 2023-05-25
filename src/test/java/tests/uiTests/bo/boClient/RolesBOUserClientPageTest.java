package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class RolesBOUserClientPageTest extends UITestBase {
    SoftAssert softAssert = new SoftAssert();
    String clientId = "33217";
    String phone = "380634413376";

    @Test
    public void testRolesBOUserClientPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboClientHelper().virifyTabsOnSerchPage();
        softAssert.assertTrue(app.getUiboHelper().isDefault2(By.id("p-tabpanel-0-label")));
        softAssert = app.getUiboClientHelper().verifySearchFields();
        app.getUiboHelper().search("id", clientId, phone);
        softAssert = app.getUiboClientHelper().verifyClientSearchResult(phone, "vikarez20@gmail.com");
        app.getUiboClientHelper().goToClientPage(phone);
        softAssert.assertAll();
    }

    @Test
    public void testRolesBOUserVerifyClientInfoOnClientPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);

        app.getUiboHelper().waitFor(By.xpath("//app-client-info"));
        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//app-client-info //p"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("src/test/java/ExpectedData/bo/boClient/verifyClientInfoOnClientPage.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }

    @Test
    public void testRolesBOUserVerifyButtonsAndTabsOnClientPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);

        softAssert = app.getUiboClientHelper().verifyTabs();
        softAssert = app.getUiboClientHelper().virifyButtons();
        softAssert.assertAll();
    }
}