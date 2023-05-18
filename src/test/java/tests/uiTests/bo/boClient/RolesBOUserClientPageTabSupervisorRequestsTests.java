package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
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

        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='reqId'] input"), "3079", "reqId", By.cssSelector("td span[ng-reflect-text='3079']"));
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='role']"), "Child");
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='rClientId'] input"), "35854", "rClientId", By.cssSelector("td span[ng-reflect-text='35854']"));
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='rClientPhone'] input[type='text']"), "380638918373", "rClientPhone", By.cssSelector("td span[ng-reflect-text='380638918373']"));
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='rFullName'] input[type='text']"), "Vika Qwerty", "rFullName", By.cssSelector("td span[ng-reflect-text='Vika Qwerty']"));
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.xpath("//p-tabpanel[@header='Supervisor requests'] //p-columnfilter[@ng-reflect-field='stateName']"), "Finished");
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='createdAt'] input[type='text']"), "21.01.2022", "createdAt", By.cssSelector("p-tabpanel[header='Supervisor requests'] td span[ng-reflect-text='21.01.2022']"));
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='approvedAt'] input[type='text']"), "19.01.2022", "approvedAt", By.cssSelector("td span[ng-reflect-text='19.01.2022']"));
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
        assertThat(actualPopupText, equalTo("Are you sure want to approve supervision request #"+requestId+""));
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
        assertThat(actualPopupText, equalTo("Are you sure want to reject supervision request #"+requestId+""));
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