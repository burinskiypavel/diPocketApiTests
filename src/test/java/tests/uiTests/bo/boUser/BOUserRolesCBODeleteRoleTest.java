package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBODeleteRoleTest extends UITestBase {
    String roleID = "a_roleID";

    @Test
    public void testBOUserRolesCBODeleteRole() throws InterruptedException, SQLException, ClassNotFoundException {
        if(app.getDbHelper().isRoleExistInDB(roleID)){
            gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
            gotoBOUsersPage();
            gotoRolesTab();
            selectRoleFromDropDown(roleID);
            click(By.cssSelector("app-button[label='Delete']"));
            click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
            waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));
        }
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoRolesTab();
        addRole(roleID, "a_roleName");
        selectRoleFromDropDown(roleID);

        click(By.cssSelector("app-button[label='Delete']"));
        click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
        waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));

        assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role deleted successfully')]")));
        assertFalse(app.getDbHelper().isRoleExistInDB(roleID));
    }
}