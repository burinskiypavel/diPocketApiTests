package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBOEditRoleTest extends UITestBase {
    String roleName = "test3";

    @Test // moved to API
    public void testBOUserRolesCBOEditRole() throws InterruptedException, SQLException, ClassNotFoundException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        gotoBOUsersPage();
        gotoRolesTab();
        selectRoleFromDropDown("1");
        editUserRole(roleName);

        assertTrue(isElementPresent(By.xpath("//div[contains(text(), 'User role edited successfully')]")));
        String roleNameDB = app.getDbHelper().getRoleNameFromDB("1");
        assertThat(roleNameDB, equalTo(roleName));
    }
}