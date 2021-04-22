package uiTests.telenor.manageSecurity;

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
        if(isElementPresent(By.id("publicToken"))){
            type(By.id("publicToken"), token);

            assertFalse(isButtonEnabled(By.xpath("//button[@data-dpwa-action='unblock-card']")));

        } else {

            navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
            gotoManageSecurityPage();
            if(isElementPresent(By.cssSelector("a[href='/en/security/block']"))){
                blockPaymentBandTelenor("QA");
                click(By.cssSelector("a[href='/en/security/unblock']"));
                waitForSeveralItems(new String[]{"Card number", "Cancel", "Unblock"});
                type(By.id("publicToken"), token);

                assertFalse(isButtonEnabled(By.xpath("//button[@data-dpwa-action='unblock-card']")));

            } else {

                click(By.cssSelector("a[href='/en/security/unblock']"));
                waitForSeveralItems(new String[]{"Card number", "Cancel", "Unblock"});
                type(By.id("publicToken"), token);

                assertFalse(isButtonEnabled(By.xpath("//button[@data-dpwa-action='unblock-card']")));
            }
        }

    }
}