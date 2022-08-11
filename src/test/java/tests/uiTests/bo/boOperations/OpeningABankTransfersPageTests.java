package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OpeningABankTransfersPageTests extends UITestBase {

    @Test
    public void testOpeningABankTransfersPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoBankTransfersTab();

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//table //th[contains(text(), 'Tran id')]",
                "//table //th[contains(text(), 'State')]", "//table //th[contains(text(), 'Payer id')]",
                "//table //th[contains(text(), 'Payer')]", "//table //th[contains(text(), 'Older date')]"}), "Incorrect headers");
    }
}