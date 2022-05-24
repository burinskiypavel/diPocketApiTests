package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class RolesBOUserClientPageClientIBANtabTest extends UITestBase {
    String phone = "380634413376";

    @Test
    public void testRolesBOUserClientPageClientIBANtab() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", "33217", phone);
        goToClientPage(phone);
        goToClientIBANTab();

        assertTrue(areElementsPresent(new String[]{"//table //th[contains(text(), 'Currency code')]", "//table //th[contains(text(), 'Account name')]",
        "//table //th[contains(text(), 'Bank id')]", "//table //th[contains(text(), 'Iban')]", "//table //th[contains(text(), 'Ref')]",
        "//table //th[contains(text(), 'Address')]", "//table //th[contains(text(), 'Bank Name')]"}));
    }
}