package tests.uiTests.bo.boClient;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class RolesBOUserClientPageSendStatementsButtonTests extends UITestBase {
    String phone = "380980316499";
    String clientId = "29818";
    String forgotPhone = "380685448615";


    @Test
    public void testRolesBOUserClientPageSendStatementsButtonAllStatementsAndDefaultEmail() throws InterruptedException {
        gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        gotoSearchPage();
        search("id", clientId, phone);
        goToClientPage(phone);
        click(By.xpath("//app-button[@ng-reflect-label='Send statements']"));

        click(By.id("formly_3_multi-select_statementRequestList_0"));

        click(By.cssSelector("div[role='checkbox']"));

        click(By.cssSelector("span.p-multiselect-close-icon"));

        click(By.cssSelector("p-button[label='Send']"));

        waitFor(By.xpath("//div[contains(text(), 'Statements were sent successfully')]"));
    }
}
