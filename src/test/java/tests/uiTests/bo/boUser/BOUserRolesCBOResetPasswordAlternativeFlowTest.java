package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.testng.annotations.Test;

public class BOUserRolesCBOResetPasswordAlternativeFlowTest extends UITestBase {

    @Test
    public void testBOUserRolesCBOResetPasswordAlternativeFlow() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoBOUsersPage();
        app.getUiboUserHelper().gotoAllUsersTab();
        app.getUiboUserHelper().searchAndSelectBOUser("All users", "username", "PAVELB");
        app.getUiboUserHelper().pressResetPassword();
        app.getUiboUserHelper().closePopUpAndVirifyPopUpClosing();
    }
}