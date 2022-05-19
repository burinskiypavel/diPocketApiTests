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
            gotoBOSiteAndLoginWithCBOUserRole(login, pass);
            gotoBOUsersPage();
            gotoRolesTab();
            selectRoleFromDropDown(roleID);
            deleteRole();
            waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));
        }
        gotoBOSiteAndLoginWithCBOUserRole(login, pass);
        gotoBOUsersPage();
        gotoRolesTab();
        addRole(roleID, "a_roleName");
        selectRoleFromDropDown(roleID);
        deleteRole();
        waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));

        assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role deleted successfully')]")));
        assertFalse(app.getDbHelper().isRoleExistInDB(roleID));
    }
}