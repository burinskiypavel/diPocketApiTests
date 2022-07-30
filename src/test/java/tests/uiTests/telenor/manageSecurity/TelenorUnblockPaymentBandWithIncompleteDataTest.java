package tests.uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertFalse;

public class TelenorUnblockPaymentBandWithIncompleteDataTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @DataProvider
    public Iterator<Object[]> unblockPaymentBandWithIncompleteData(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"12345678"});
        list.add(new Object[] {"12345"});
        list.add(new Object[] {""});
        return list.iterator();
    }

    @Test(dataProvider = "unblockPaymentBandWithIncompleteData")
    public void testUnblockPaymentBandWithIncompleteData(String token) throws InterruptedException {
        if(app.getUiTelenorHelper().isElementPresent(By.id("publicToken"))){
            app.getUiTelenorHelper().type(By.id("publicToken"), token);

            assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.xpath("//button[@data-dpwa-action='unblock-card']")));

        } else {

            app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
            app.getUiTelenorHelper().gotoManageSecurityPage();
            if(app.getUiTelenorHelper().isElementPresent(By.cssSelector("a[href='/en/security/block']"))){
                app.getUiTelenorHelper().blockPaymentBandTelenor("QA");
                app.getUiTelenorHelper().click(By.cssSelector("a[href='/en/security/unblock']"));
                app.getUiTelenorHelper().waitForSeveralItems(new String[]{"Card number", "Cancel", "Unblock"});
                app.getUiTelenorHelper().type(By.id("publicToken"), token);

                assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.xpath("//button[@data-dpwa-action='unblock-card']")));

            } else {

                app.getUiTelenorHelper().click(By.cssSelector("a[href='/en/security/unblock']"));
                app.getUiTelenorHelper().waitForSeveralItems(new String[]{"Card number", "Cancel", "Unblock"});
                app.getUiTelenorHelper().type(By.id("publicToken"), token);

                assertFalse(app.getUiTelenorHelper().isButtonEnabled(By.xpath("//button[@data-dpwa-action='unblock-card']")));
            }
        }
    }
}