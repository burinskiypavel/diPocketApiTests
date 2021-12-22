package tests.uiTests.bo.boUser;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BOUserRolesCBORolesTableTest extends UITestBase {

    @Test
    public void testBOUserRolesCBORolesTable() throws InterruptedException {
        gotoBOSiteAndLoginWithCBOUserRole("Viktoria", "kWmaB0s");
        click(By.xpath("//p[contains(text(), 'BO Users')]"));
        click(By.id("p-tabpanel-2-label"));

        assertTrue(isTabActiveAndSelected(By.xpath("//a[@id='p-tabpanel-2-label'][@aria-selected='true']")));
        assertTrue(isPageOpen(By.xpath("//div[@id='p-tabpanel-2'][@aria-hidden='false']")));

        click(By.cssSelector("p-dropdown[placeholder='Role']"));
        click(By.cssSelector("li[aria-label='1']"));

        assertTrue(isButtonEnabled(By.cssSelector("app-button[label='Edit")));
        assertTrue(isButtonEnabled(By.cssSelector("app-button[label='Delete")));

        assertFalse(!areElementsPresent(new String[]{"//th[contains(text(), 'Code')]",
                "//th[contains(text(), 'Name')]", "//th[contains(text(), 'Description')]",
                "//th[contains(text(), 'Checked')]", }));

        assertTrue(isButtonEnabled(By.cssSelector("app-button[label='Update']")));
    }
}
