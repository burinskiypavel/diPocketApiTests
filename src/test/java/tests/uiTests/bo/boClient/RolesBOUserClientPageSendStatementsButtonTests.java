package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class RolesBOUserClientPageSendStatementsButtonTests extends UITestBase {
    String phone = "380634413376";
    String clientId = "33217";
    String forgotPhone = "380685448615";


    @Test
    public void testRolesBOUserClientPageSendStatementsButton() throws InterruptedException, SQLException, ClassNotFoundException {
        //String clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, forgotPhone);
        goToClientPage(forgotPhone);
        click(By.xpath("//app-button[@ng-reflect-label='Change credentials']"));
        changeCredentialsChagePhoneNumber("38098316499");

        waitFor(By.xpath("//div[contains(text(), 'Credentials was changed successfully')]"));
    }
}
