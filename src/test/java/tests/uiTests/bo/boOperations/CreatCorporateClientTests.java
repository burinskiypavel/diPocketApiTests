package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreatCorporateClientTests extends UITestBase {

    @Test
    public void testOpeningAPageForCreatingACorporateClient() throws InterruptedException, SQLException, ClassNotFoundException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin2, app.CBOuserPass2);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoCreatCorporateClientTab();

    }
}