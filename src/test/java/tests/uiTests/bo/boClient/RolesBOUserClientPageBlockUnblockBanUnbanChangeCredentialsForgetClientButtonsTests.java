package tests.uiTests.bo.boClient;

import appmanager.HelperBase;
import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertEquals;

public class RolesBOUserClientPageBlockUnblockBanUnbanChangeCredentialsForgetClientButtonsTests extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";
    String forgotPhone = "380685448615";

    @Test(priority = 1)
    public void testRolesBOUserClientPageBlockClientButton() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unblock client']"))){
            app.getUiboHelper().unblockClient();
        }

        app.getUiboHelper().blockClient("test");
        String actualState = app.getUiboHelper().getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Blocked");

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unblock client']"))){
            app.getUiboHelper().unblockClient();
        }
    }

    @Test(priority = 2, enabled = false) // moved to api
    public void testRolesBOUserClientPageUnblockClientButton() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Block client']"))){
            app.getUiboHelper().blockClient("test");
        }

        app.getUiboHelper().unblockClient();
        String actualState = app.getUiboHelper().getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Active");
    }

    @Test(priority = 3)
    public void testRolesBOUserClientPageBanClientButton() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            app.getUiboHelper().unbanClient("test");
        }

        app.getUiboHelper().banClient("test");
        String actualState = app.getUiboHelper().getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Banned");

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            app.getUiboHelper().unbanClient("test");
        }
    }

    @Test(priority = 4, enabled = false) // moved to api
    public void testRolesBOUserClientPageBanClientWithoutBlockingClientDevice() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            app.getUiboHelper().unbanClient("test");
        }

        app.getUiboHelper().banClientWithoutBlockingClientDevice("test");
        String actualState = app.getUiboHelper().getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Banned");

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            app.getUiboHelper().unbanClient("test");
        }
    }

    @Test(priority = 5, enabled = false) // moved to api
    public void testRolesBOUserClientPageUnbanClientButton() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, phone);
        app.getUiboHelper().goToClientPage(phone);

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Ban client']"))){
            app.getUiboHelper().banClient("test");
        }

        app.getUiboHelper().unbanClient("test");
        String actualState = app.getUiboHelper().getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Active");
    }

    @Test(priority = 6)
    public void testRolesBOUserClientPageChangeCredentialsButtonChangePIN() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId);

        if(app.getUiboHelper().isElementPresent(By.cssSelector("td[ng-reflect-text='38098316499']"))){
            app.getUiboHelper().goToClientPage("38098316499");
            app.getUiboHelper().changeCredentialsChagePhoneNumber(forgotPhone);
            app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
            app.getUiboHelper().navigateBack();
            app.getUiboHelper().search("id", clientId);
        }

        app.getUiboHelper().goToClientPage(forgotPhone);

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Change credentials']"));
        app.getUiboHelper().click(By.xpath("//label[contains(text(), 'Change password:')]"));
        app.getUiboHelper().click(By.cssSelector("p-button[ng-reflect-label='Change']"));
        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }

    @Test(priority = 7)
    public void testRolesBOUserClientPageChangeCredentialsButtonChangeSecretAnswer() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId, forgotPhone);
        app.getUiboHelper().goToClientPage(forgotPhone);

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Change credentials']"));
        app.getUiboHelper().click(By.xpath("//label[contains(text(), 'Change secret answer:')]"));
        app.getUiboHelper().click(By.cssSelector("p-button[ng-reflect-label='Change']"));
        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }

    @Test(priority = 8)
    public void testRolesBOUserClientPageChangeCredentialsButtonChangeChangePhoneNumber() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId);

        if(app.getUiboHelper().isElementPresent(By.cssSelector("td[ng-reflect-text='38098316499']"))){
            app.getUiboHelper().goToClientPage("38098316499");
            app.getUiboHelper().changeCredentialsChagePhoneNumber(forgotPhone);
            app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
            app.getUiboHelper().navigateBack();
            app.getUiboHelper().search("id", clientId);
        }

        app.getUiboHelper().goToClientPage(forgotPhone);
        app.getUiboHelper().changeCredentialsChagePhoneNumber("38098316499");

        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));

        app.getUiboHelper().navigateBack();
        app.getUiboHelper().search("id", clientId);

        if(app.getUiboHelper().isElementPresent(By.cssSelector("td[ng-reflect-text='38098316499']"))){
            app.getUiboHelper().goToClientPage("38098316499");
            app.getUiboHelper().changeCredentialsChagePhoneNumber(forgotPhone);
            app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
            app.getUiboHelper().navigateBack();
            app.getUiboHelper().search("id", clientId);
        }
    }

    @Test(priority = 9)
    public void testRolesCBOUserClientPageForgetClient() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId);
        app.getUiboHelper().goToClientPage(forgotPhone);

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unblock client']"))){
            app.getUiboHelper().unblockClient();
        }

        app.getUiboHelper().forgetClient("test");
        String actualState = app.getUiboHelper().getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Forgotten");
    }
}