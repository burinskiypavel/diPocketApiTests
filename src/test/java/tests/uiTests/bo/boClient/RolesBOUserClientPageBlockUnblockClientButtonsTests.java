package tests.uiTests.bo.boClient;

import appmanager.HelperBase;
import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertEquals;

public class RolesBOUserClientPageBlockUnblockClientButtonsTests extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";
    String forgotPhone = "380685448615";

    @Test(priority = 1)
    public void testRolesBOUserClientPageBlockClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unblock client']"))){
            unblockClient();
        }

        blockClient("test");
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Blocked");

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unblock client']"))){
            unblockClient();
        }
    }

    @Test(priority = 2, enabled = false) // moved to api
    public void testRolesBOUserClientPageUnblockClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Block client']"))){
            blockClient("test");
        }

        unblockClient();
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Active");
    }

    @Test(priority = 3)
    public void testRolesBOUserClientPageBanClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            unbanClient("test");
        }

        banClient("test");
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Banned");

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            unbanClient("test");
        }
    }

    @Test(priority = 4, enabled = false) // moved to api
    public void testRolesBOUserClientPageBanClientWithoutBlockingClientDevice() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            unbanClient("test");
        }

        banClientWithoutBlockingClientDevice("test");
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Banned");

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Unban client']"))){
            unbanClient("test");
        }
    }

    @Test(priority = 5, enabled = false) // moved to api
    public void testRolesBOUserClientPageUnbanClientButton() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);

        if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Ban client']"))){
            banClient("test");
        }

        unbanClient("test");
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Active");
    }

    @Test(priority = 6)
    public void testRolesBOUserClientPageChangeCredentialsButtonChangePIN() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, forgotPhone);
        goToClientPage(forgotPhone);

        click(By.xpath("//app-button[@ng-reflect-label='Change credentials']"));
        click(By.xpath("//label[contains(text(), 'Change password:')]"));
        click(By.cssSelector("app-button[ng-reflect-label='Change']"));
        waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }

    @Test(priority = 7)
    public void testRolesBOUserClientPageChangeCredentialsButtonChangeSecretAnswer() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, forgotPhone);
        goToClientPage(forgotPhone);

        click(By.xpath("//app-button[@ng-reflect-label='Change credentials']"));
        click(By.xpath("//label[contains(text(), 'Change secret answer:')]"));
        click(By.cssSelector("app-button[ng-reflect-label='Change']"));
        waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }

    @Test(priority = 8)
    public void testRolesBOUserClientPageChangeCredentialsButtonChangeChangePhoneNumber() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, forgotPhone);
        goToClientPage(forgotPhone);

        click(By.xpath("//app-button[@ng-reflect-label='Change credentials']"));
        click(By.xpath("//label[contains(text(), 'Change phone number:')]"));
        type(By.cssSelector("input[placeholder='New phone']"), "38098316499");
        click(By.cssSelector("app-button[ng-reflect-label='Change']"));
        waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }

    @Test(priority = 9)
    public void testRolesCBOUserClientPageForgetClient() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        gotoSearchPage();
        search("id", clientId, forgotPhone);
        goToClientPage(forgotPhone);
        forgetClient("test");
        String actualState = getText(By.cssSelector("p.ng-star-inserted"), 0);

        assertEquals(actualState, "State: Forgotten");
    }
}