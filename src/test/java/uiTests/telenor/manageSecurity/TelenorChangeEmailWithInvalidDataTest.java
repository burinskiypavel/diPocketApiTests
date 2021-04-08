package uiTests.telenor.manageSecurity;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TelenorChangeEmailWithInvalidDataTest extends UITestBase {
    String smsCode = "111111"; //app.generateRandomNumber(6);

    @DataProvider
    public Iterator<Object[]> changeEmailWithInvalidData(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"vikarez@"});
        list.add(new Object[] {"vika20gmail."});
        list.add(new Object[] {"vika4.com"});
        return list.iterator();
    }

    @Test(dataProvider = "changeEmailWithInvalidData")
    public void testChangeEmailWithInvalidData(String email) throws InterruptedException {
        if(isElementPresent(By.id("email"))){
            type(By.id("email"), email);
            pressConfirm(By.cssSelector("button[data-dpwa-action='email-verify']"));
            String hexColor = getColorOfElement(By.id("email"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

        navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
        gotoManageSecurityPage();
        gotoChangeEmail();
        type(By.id("email"), email);
        pressConfirm(By.cssSelector("button[data-dpwa-action='email-verify']"));
        String hexColor = getColorOfElement(By.id("email"), "border-color");

        assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }
}