package tests.uiTests.telenor.manageSecurity;

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
        if(app.getUiTelenorHelper().isElementPresent(By.id("email"))){
            app.getUiTelenorHelper().type(By.id("email"), email);
            app.getUiTelenorHelper().pressConfirm(By.cssSelector("button[data-dpwa-action='email-verify']"));
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("email"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));

        } else {

            app.getUiTelenorHelper().navigateToTelenorAndLogin2(app.telenorRegistrationPhone2, smsCode);
            app.getUiTelenorHelper().gotoManageSecurityPage();
            app.getUiTelenorHelper().gotoChangeEmail();
            app.getUiTelenorHelper().type(By.id("email"), email);
            app.getUiTelenorHelper().pressConfirm(By.cssSelector("button[data-dpwa-action='email-verify']"));
            String hexColor = app.getUiTelenorHelper().getColorOfElement(By.id("email"), "border-color");

            assertThat(hexColor, equalTo(app.hexRedColor));
        }
    }
}