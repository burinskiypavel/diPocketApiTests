package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LimitPlanPageTests extends UITestBase {

    @Test
    public void testOpeningALimitPlanPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoLimitPlanTab();

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//h5[contains(text(), 'Limit plan')]",
                "//h5[contains(text(), 'Limit level')]", "//h5[contains(text(), 'Base currency')]"}), "Text Verifications");

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//th[contains(text(), 'Row #')]",
                "//th[contains(text(), 'Group')]", "//th[contains(text(), 'Type')]", "//th[contains(text(), 'Amount')]"}), "Columns verifications");
    }
}
