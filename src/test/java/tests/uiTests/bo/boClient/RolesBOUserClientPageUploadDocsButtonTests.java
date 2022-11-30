package tests.uiTests.bo.boClient;

import appmanager.HelperBase;
import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class RolesBOUserClientPageUploadDocsButtonTests extends UITestBase {
    String phone = "380685448615";

    @Test
    public void testRolesBOUserClientPageUploadDocsButtonUploadPhotoID() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId);
        app.getUiboClientHelper().goToClientPage(phone);

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Upload docs']"));
        app.getUiboHelper().click(By.cssSelector("app-select-async[ng-reflect-name='typeId']"));
        app.getUiboHelper().waitFor(By.cssSelector("li[aria-label='PhotoID']"));
        app.getUiboHelper().click(By.cssSelector("li[aria-label='PhotoID']"));
        app.getUiboHelper().uploadFile(By.cssSelector("p-fileupload[ng-reflect-choose-label='Browse'] input[type='file']"), "C:/Work/Files/self.jpg");
        Thread.sleep(1500);
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));

        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'Docs were uploaded successfully')]"));
    }
}