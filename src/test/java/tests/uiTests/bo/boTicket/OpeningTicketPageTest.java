package tests.uiTests.bo.boTicket;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OpeningTicketPageTest extends UITestBase {

    @Test
    public void testOpeningTicketPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoTakeTicket();

        app.getUiboHelper().waitFor(By.xpath("//app-client-details-info"));
        app.getUiboHelper().waitFor(By.id("takeTicketContent"));

        assertTrue(app.getUiboHelper().areButtonsPresent(new String[]{"//app-button[@ng-reflect-label='Approve']", "//app-button[@ng-reflect-label='Edit']",
                "//app-button[@ng-reflect-label='Rescan request']", "//app-button[@ng-reflect-label='Ask for']", "//app-button[@ng-reflect-label='Ask new selfie']",
        "//app-button[@ng-reflect-label='Ban']", "//app-button[@ng-reflect-label='Postpone']", "//app-button[@ng-reflect-label='Reassign']"}), "button bo tickets");
    }

    @Test
    public void  testApproveSDDTicket() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoTakeTicket();

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Edit']"));

        app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='gender']"), "M");


        app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='photoIdTypeId']"), "Passport");

        app.getUiboHelper().type(By.xpath("//app-input[@ng-reflect-name='photoIdNo'] //input"), "12345678");

        app.getUiboHelper().type(By.xpath("//app-input[@ng-reflect-name='identifyCode'] //input"), "12345678");

        app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='photoIdCountryId']"), "Poland");


        Thread.sleep(1500);
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Save']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Approve']"));


        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }

    @Test
    public void  testApproveSDDTicketWithoutGenderChoice() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithBOUserRole(app.BOuserLogin, app.BOuserPass);
        app.getUiboHelper().gotoTakeTicket();



//        if(app.getUiboHelper().areElementsPresent(new String[]{"//td[contains(text(), 'Gender')]"})){
//            WebElement table = app.getUiboHelper().findElement(By.cssSelector("div.data-table tbody"));
//            WebElement row = table.findElement(By.xpath("//tr[3]"));
//            String rows = row.getText();
//
//            WebElement td = row.findElement(By.xpath("//tr[3] //td[2]"));
//
//            String tdd = td.getText();
//            System.out.println(tdd);
//
//            app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
//
//            app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));
//
//
//            app.getUiboHelper().waitFor(By.xpath("//p[contains(text(), 'Take Ticket')]"));
//            app.getUiboHelper().click(By.xpath("//p[contains(text(), 'Take Ticket')]"));
//
//        }

//        app.getUiboHelper().click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Profile data')]"));
//
//        WebElement table = app.getUiboHelper().findElements(By.cssSelector("div.client-data tbody")).get(0);
//        WebElement row = table.findElement(By.xpath("//tr[3]"));
//        String rows = row.getText();
//
//        WebElement td = row.findElement(By.xpath("//tr[3] //td[1]"));
//
//        String tdd = td.getText();
//        System.out.println(tdd);

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Edit']"));


        //app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'All')]

        if(app.getUiboHelper().isElementPresent(By.xpath("//app-select-async[@ng-reflect-name='gender'] //span[contains(text(), 'All')]"))){
            app.getUiboHelper().click(By.cssSelector("div.p-dialog-header-icons"));
        }


        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Approve']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Impossible to approve ticket. “Gender” field should be filled')]"));

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Edit']"));
        ;

        app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='gender']"), "M");



        //app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='photoIdTypeId']"), "Passport");
        //app.getUiboHelper().type(By.xpath("//app-input[@ng-reflect-name='photoIdNo'] //input"), "12345678");
        //app.getUiboHelper().type(By.xpath("//app-input[@ng-reflect-name='identifyCode'] //input"), "12345678");
        //app.getUiboHelper().selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='photoIdCountryId']"), "Poland");

        Thread.sleep(1500);
        app.getUiboHelper().click(By.xpath("//p-button[@ng-reflect-label='Save']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));

        app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Approve']"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));

        app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Take Ticket')]"));

        assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//*[contains(text(), 'Take Ticket')]", "//*[contains(text(), 'Search')]"}));
    }
}