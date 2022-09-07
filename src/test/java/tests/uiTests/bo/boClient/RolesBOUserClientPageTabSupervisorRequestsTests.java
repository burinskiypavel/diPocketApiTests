package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabSupervisorRequestsTests extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";
    String requestId = "3080";

    @Test
    public void testRolesBOUserClientPageTabSupervisorRequests() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToSupervisorRequestsTab();

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'Request id')]", "//thead //th[contains(text(), 'Role')]",
                "//thead //th[contains(text(), 'Client id')]", "//thead //th[contains(text(), 'Phone')]",
                "//thead //th[contains(text(), 'Full name')]", "//thead //th[contains(text(), 'State')]",
                "//thead //th[contains(text(), 'Created date')]", "//thead //th[contains(text(), 'Approved date')]"}));

        app.getUiboClientHelper().verifyClientPageFilter("reqId", "3079");
        app.getUiboClientHelper().verifyDropDownClientPageFilter("role", "Child");
        app.getUiboClientHelper().verifyClientPageFilter("rClientId", "33655");
        app.getUiboClientHelper().verifyClientPageFilter("rClientPhone", "380638918373");
        app.getUiboClientHelper().verifyClientPageFilter("rFullName", "Vika Qwerty");
        app.getUiboClientHelper().verifyDropDownClientPageFilterWithCollection(By.xpath("//p-columnfilter[@field='stateName']"), "Finished", 3);
        app.getUiboClientHelper().verifyClientPageFilter("createdAt", "21.01.2022");
        app.getUiboClientHelper().verifyClientPageFilter("approvedAt", "30.08.2021");
    }

    @Test
    public void testRolesBOUserClientPageTabSupervisorRequestsApprove() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToSupervisorRequestsTab();
        app.getUiboHelper().performContextClickFromTable(requestId);

        if(app.getUiboHelper().isElementActiveFromContextMenu(1)){
            app.getUiboClientHelper().rejectSupervisor();
            app.getUiboHelper().performContextClickFromTable(requestId);
        }

        String actualPopupText = app.getUiboClientHelper().approveSupervisorAndGetTextFromPopUp();

        assertEquals(actualPopupText, "Are you sure want to approve supervision request #"+requestId+"");
    }

    @Test
    public void testRolesBOUserClientPageTabSupervisorRequestsReject() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToSupervisorRequestsTab();
        app.getUiboHelper().performContextClickFromTable(requestId);

        if(app.getUiboHelper().isElementActiveFromContextMenu(0)){
            app.getUiboClientHelper().approveSupervisor();
            app.getUiboHelper().performContextClickFromTable(requestId);
        }

        String actualPopupText = app.getUiboClientHelper().rejectSupervisorAndGetTextFromPopUp();

        assertEquals(actualPopupText, "Are you sure want to reject supervision request #"+requestId+"");
    }

    @Test(enabled = false)
    public void testRolesBOUserClientPageTabSupervisorRequestsUploadProofOfRelationship() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToSupervisorRequestsTab();
        app.getUiboHelper().performContextClickFromTable(requestId);
        app.getUiboHelper().click(By.xpath("//li //span[contains(text(), 'Upload ‘Proof of relationship’')]"));
        app.getUiboHelper().uploadFile(By.cssSelector("input[type='file']"), "C:/Users/pa.burinsky/Desktop/4.jpg");
        app.getUiboHelper().click(By.cssSelector("app-button[ng-reflect-label='Send']"));
    }
}