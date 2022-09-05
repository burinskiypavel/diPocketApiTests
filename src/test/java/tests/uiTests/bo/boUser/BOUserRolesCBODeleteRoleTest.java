package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBODeleteRoleTest extends UITestBase {
    String roleID = "a_roleID";
    String login = app.CBOuserLogin;
    String pass = app.CBOuserPass;

    @Test //moved to API
    public void testBOUserRolesCBODeleteRole() throws InterruptedException, SQLException, ClassNotFoundException {
        if(app.getDbHelper().isRoleExistInDB(roleID)){
            app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(login, pass);
            app.getUiboHelper().gotoBOUsersPage();
            app.getUiboUserHelper().gotoRolesTab();
            app.getUiboUserHelper().selectRoleFromDropDown(roleID);
            app.getUiboUserHelper().deleteRole();
            app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));
        }
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(login, pass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoRolesTab();
        app.getUiboUserHelper().addRole(roleID, "a_roleName");
        app.getUiboUserHelper().selectRoleFromDropDown(roleID);
        app.getUiboUserHelper().deleteRole();
        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));

        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//div[contains(text(), 'User role deleted successfully')]")));
        assertFalse(app.getDbHelper().isRoleExistInDB(roleID));
    }
}