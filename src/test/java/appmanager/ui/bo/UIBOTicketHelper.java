package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import padeObjects.bo.BOHomePage;
import padeObjects.bo.boTicket.TakeTicketEditDataPage;

import java.sql.SQLException;

public class UIBOTicketHelper extends UIHelperBase {

    public UIBOTicketHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoTakeTicket() throws InterruptedException {
        click(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        //BOHomePage boHomePage = new BOHomePage(driver);
        //boHomePage.gotoTakeTicket();
        waitFor(By.id("takeTicketContent"));
    }

    public void gotoTakeTicketWithReg() throws InterruptedException, SQLException, ClassNotFoundException {
        //click(By.cssSelector("div[ng-reflect-router-link='take_ticket']"));
        BOHomePage boHomePage = new BOHomePage(driver);
        boHomePage.gotoTakeTicket();
        Thread.sleep(1500);
        //waitFor(By.id("takeTicketContent"));
    }

    public void delayTicketForOneMinute() throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Postpone']"));
        click(By.xpath("//button[@ng-reflect-icon='pi pi-calendar']"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        click(By.cssSelector("div.p-minute-picker span.pi-chevron-up"));
        pressKeys(Keys.ENTER);
        Thread.sleep(1000);
        clickWithJS(By.xpath("//app-postpone-modal //p-button[@ng-reflect-label='Postpone']"));
        waitFor(By.xpath("//div[contains(text(), 'Ticket was successfully delayed')]"));
    }

    public void setGender(String dropdownItem) throws InterruptedException {
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.clickOnGenderDropDown();
        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        try{
            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        }
    }

    public void setDocumentType(String dropdownItem) throws InterruptedException {
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.clickOnDocumentTypeDropDown();
        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        try{
            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        }
    }

    public void setDocSerialNumber(String text){
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.setDocSerialNumber(text);
    }

    public void setIDCode(String text){
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.setIDCode(text);
    }

    public void setDocCountryOfIssue(String dropdownItem) throws InterruptedException {
        TakeTicketEditDataPage takeTicketEditDataPage = new TakeTicketEditDataPage(driver);
        takeTicketEditDataPage.clickDocCountryOfIssueDropDown();
        waitFor(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        try{
            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));

        } catch (org.openqa.selenium.StaleElementReferenceException ex) {

            click(By.cssSelector("p-dropdownitem li[aria-label='" + dropdownItem + "']"));
        }
    }

    public void editAndSaveSSDTicket(String gender, String documentType, String docSerialNumber, String pesel, String docCountryOfIssue) throws InterruptedException {
        click(By.xpath("//app-button[@ng-reflect-label='Edit']"));
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='gender']"), gender);
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='photoIdTypeId']"), documentType);
        type(By.xpath("//app-input[@ng-reflect-name='photoIdNo'] //input"), docSerialNumber);
        type(By.xpath("//app-input[@ng-reflect-name='identifyCode'] //input"), pesel);
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='photoIdCountryId']"), docCountryOfIssue);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Save']"));
        waitFor(By.xpath("//*[contains(text(), 'Client data updated successfully')]"));
    }

    public void approveTicketSuccessfully() {
        click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), 'Ticket approved successfully')]"));
    }

    public void unsuccessfulApprove(final String message) {
        click(By.xpath("//app-button[@ng-reflect-label='Approve']"));
        waitFor(By.xpath("//*[contains(text(), '" + message + "')]"));
    }
}