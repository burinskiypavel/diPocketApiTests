package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageTabTicketsTest extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";

    @Test
    public void testRolesBOUserClientPageTabTickets() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboClientHelper().goToTicketsTab();
        app.getUiboHelper().waitFor(By.xpath("//thead //th[contains(text(), 'Ticket Type')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{
                "//thead //th[contains(text(), 'Ticket id')]", "//thead //th[contains(text(), 'Created')]",
                "//thead //th[contains(text(), 'Ticket Type')]", "//thead //th[contains(text(), 'User')]",
                "//thead //th[contains(text(), 'Ticket State')]", "//thead //th[contains(text(), 'Closed')]",
                "//thead //th[contains(text(), 'Last comment')]"}));


        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("app-tickets-tab p-columnfilter[ng-reflect-field='id'] input[type='text']"), "25596", "id", By.cssSelector("td[ng-reflect-text='25596']"));
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='created'] input[type='text']"), "02.02.2022", "created", By.cssSelector("td[ng-reflect-text='02.02.2022']"));
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='typeName']"), "FDD check");
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='username'] "), "EVGENYA");
        app.getUiboClientHelper().verifyDropDownClientPageFilter(By.cssSelector("app-tickets-tab p-columnfilter[ng-reflect-field='stateName'] "), "Closed");
        app.getUiboClientHelper().verifyClientPageFilter(By.cssSelector("p-columnfilter[ng-reflect-field='closed'] input[type='text']"), "07.02.2022", "closed", By.cssSelector("td[ng-reflect-text='07.02.2022']"));

        app.getUiboClientHelper().setClientPageFilter(By.cssSelector("app-tickets-tab p-columnfilter[ng-reflect-field='lastMessage'] input[type='text']"), "Ticket reassigned. Reason: test");
        assertTrue(app.getUiboHelper().areElementsPresentAfterSorting(By.xpath("//td[contains(text(), 'Ticket reassigned. Reason: test')]")));
    }
}