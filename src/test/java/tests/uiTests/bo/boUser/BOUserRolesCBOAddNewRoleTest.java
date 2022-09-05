package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOAddNewRoleTest extends UITestBase {
    String roleID = "testqa1";
    String login = app.CBOuserLogin;
    String pass = app.CBOuserPass;

    @Test
    public void testBOUserRolesCBOAddNewRole() throws InterruptedException, SQLException, ClassNotFoundException {
        if(app.getDbHelper().isRoleExistInDB(roleID)){
            app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(login, pass);
            app.getUiboHelper().gotoBOUsersPage();
            app.getUiboUserHelper().gotoRolesTab();
            app.getUiboUserHelper().selectRoleFromDropDown(roleID);
            app.getUiboUserHelper().deleteRole();
        }

        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(login, pass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoRolesTab();
        app.getUiboUserHelper().addRole(roleID, "testqa2");
        app.getUiboUserHelper().selectRoleFromDropDown(roleID);

        app.getUiboHelper().clickCheckbox(By.cssSelector("div[role='checkbox']"));
        app.getUiboHelper().click(By.cssSelector("p-button[label='Update']"));
        app.getUiboHelper().waitFor(By.xpath("//div[contains(text(), 'User role changed successfully')]"));

        assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//div[contains(text(), 'User role changed successfully')]")));
        app.getUiboUserHelper().deleteRole();
    }
}