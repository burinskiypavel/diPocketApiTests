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
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToSupervisorRequestsTab();

        assertTrue(areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'Request id')]", "//thead //th[contains(text(), 'Role')]",
                "//thead //th[contains(text(), 'Client id')]", "//thead //th[contains(text(), 'Phone')]",
                "//thead //th[contains(text(), 'Full name')]", "//thead //th[contains(text(), 'State')]",
                "//thead //th[contains(text(), 'Created date')]", "//thead //th[contains(text(), 'Approved date')]"}));

        verifyClientPageFilter("reqId", "3079");
        verifyDropDownClientPageFilter("role", "Child");
        verifyClientPageFilter("rClientId", "33655");
        verifyClientPageFilter("rClientPhone", "380638918373");
        verifyClientPageFilter("rFullName", "Vika Qwerty");
        verifyDropDownClientPageFilterWithCollection(By.xpath("//p-columnfilter[@field='stateName']"), "Finished", 3);
        verifyClientPageFilter("createdAt", "21.01.2022");
        verifyClientPageFilter("approvedAt", "30.08.2021");
    }

    @Test
    public void testRolesBOUserClientPageTabSupervisorRequestsApprove() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToSupervisorRequestsTab();
        performContextClickFromTable(requestId);

        if(isElementActiveFromContextMenu(1)){
            rejectSupervisor();
            performContextClickFromTable(requestId);
        }

        String actualPopupText = approveSupervisorAndGetTextFromPopUp();

        assertEquals(actualPopupText, "Are you sure want to approve supervision request #"+requestId+"");
    }

    @Test
    public void testRolesBOUserClientPageTabSupervisorRequestsReject() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        goToSupervisorRequestsTab();
        performContextClickFromTable(requestId);

        if(isElementActiveFromContextMenu(0)){
            approveSupervisor();
            performContextClickFromTable(requestId);
        }

        String actualPopupText = rejectSupervisorAndGetTextFromPopUp();

        assertEquals(actualPopupText, "Are you sure want to reject supervision request #"+requestId+"");
    }
}