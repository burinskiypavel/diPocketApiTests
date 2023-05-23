package tests.uiTests.bo.boClient;

import base.UITestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static appmanager.HelperBase.prop;

public class RolesBOUserClientPageUploadDocsButtonTests extends UITestBase {
    String phone = "380685448615";

    @Test
    public void testRolesBOUserClientPageUploadDocsButtonUploadPhotoID() throws InterruptedException, SQLException, ClassNotFoundException {
        String clientId = app.getDbHelper().getClientIdFromDB(prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoSearchPage();
        app.getUiboHelper().search("id", clientId);
        app.getUiboClientHelper().goToClientPage(phone);
        app.getUiboTicketHelper().uploadDoc("PhotoID", "files/bo/images/self.jpg");
    }
}