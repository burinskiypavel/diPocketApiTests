package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewRoleTest extends UITestBase {
    String roleID = "testqa1";
    String login = "PAVELB";
    String pass = "D5kHO7a";

    @Test
    public void testBOUserRolesCBOAddNewRole() throws InterruptedException, SQLException, ClassNotFoundException {
        if(app.getDbHelper().isRoleExistInDB(roleID)){
            gotoBOSiteAndLoginWithCBOUserRole(login, pass);
            gotoBOUsersPage();
            gotoRolesTab();
            selectRoleFromDropDown(roleID);
            deleteRole();
        }

        gotoBOSiteAndLoginWithCBOUserRole(login, pass);
        gotoBOUsersPage();
        gotoRolesTab();
        addRole(roleID, "testqa2");
        selectRoleFromDropDown(roleID);

        clickCheckbox(By.cssSelector("div[role='checkbox']"));
        click(By.cssSelector("app-button[label='Update']"));
        waitFor(By.xpath("//div[contains(text(), 'User role changed successfully')]"));

        assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role changed successfully')]")));
        deleteRole();
    }
}