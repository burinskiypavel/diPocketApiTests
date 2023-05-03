package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import padeObjects.bo.boUsers.AddNewRolePage;
import padeObjects.bo.boUsers.BOUserHomePage;
import padeObjects.bo.boUsers.DeleteRolePage;

import static org.testng.Assert.assertFalse;

public class UIBOUserHelper extends UIHelperBase {
    AddNewRolePage addNewRolePage = new AddNewRolePage(driver);
    DeleteRolePage deleteRolePage = new DeleteRolePage(driver);
    BOUserHomePage boUserHomePage = new BOUserHomePage(driver);

    public UIBOUserHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoRolesTab() {
        click(By.id("p-tabpanel-3-label"));
    }

    public void deleteRole() {
        click(By.cssSelector("p-button[label='Delete']"));
        //click(By.cssSelector("button[type='Submit']"));
        click(deleteRolePage.submitBtn);
        waitFor(By.xpath("//div[contains(text(), 'User role removed successfully')]"));
    }

    public void addRole(String roleID, String roleName) throws InterruptedException {
        click(By.cssSelector("p-button[label='+ Add']"));
        waitForSeveralItems(new String[]{"Role ID:", "Role name:", "Add Role"});
        //type(By.cssSelector("input[id*=input_roleId]"), roleID);
        type(addNewRolePage.roleIDInput, roleID);
        //type(By.cssSelector("input[id*=input_roleName]"), roleName);
        type(addNewRolePage.roleNameInput, roleName);
        Thread.sleep(500);
        //click(By.cssSelector("p-button[ng-reflect-label='Confirm']"));
        click(addNewRolePage.confirmBtn);
        waitFor(By.xpath("//*[contains(text(), 'User role added successfully')]"));
    }

    public void pressResetPassword() {
        //click(By.cssSelector("div.buttons-wrap p-button[ng-reflect-label='Reset password']"));
        click(boUserHomePage.resetPasswordBtn);
        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to reset password and send new one?')]"));
    }

    public void pressBlockUser() {
        click(boUserHomePage.blockUserBtn);
        //click(By.cssSelector("div.buttons-wrap p-button[ng-reflect-label='Block user']"));
        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to block user')]"));
    }

    public void selectRoleFromDropDown(final String name) {
        click(By.cssSelector("p-dropdown[placeholder='Role']"));
        waitFor(By.cssSelector("li[aria-label='" + name + "']"));
        click(By.cssSelector("li[aria-label='" + name + "']"));
        waitFor(By.cssSelector("div[role='checkbox']"));
    }

    public void selectFromSelectAddNewUserPage(String select, String text) {
        click(By.cssSelector("app-select-async[ng-reflect-name='" + select + "']"));
        waitFor(By.xpath("//ul[@role='listbox'] //span[contains(text(), '" + text + "')]"));
        click(By.xpath("//ul[@role='listbox'] //span[contains(text(), '" + text + "')]"));
    }

    public void fillBOUserFieldsInPopup(String firstname, String lastname, String phone, String email, String username) {
        type(By.cssSelector("app-input[ng-reflect-name='firstName'] input[type='text']"), firstname);
        type(By.cssSelector("app-input[ng-reflect-name='lastName'] input[type='text']"), lastname);
        type(By.cssSelector("app-input-number[ng-reflect-name='phone'] input.p-inputtext"), phone);
        type(By.cssSelector("app-input[ng-reflect-name='email'] input[type='text']"), email);
        type(By.cssSelector("app-input[ng-reflect-name='username'] input[type='text']"), username);
    }

    public void gotoAllUsersTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'All users')]"));
    }

    public void searchAndSelectBOUser(String tabPanel, String filter, String text) throws InterruptedException {
        searchBOUser(tabPanel, filter, text);
        selectBOUser(text);
    }

    public void searchBOUser(String tabPanel, String filter, String text) {
        type(By.cssSelector("p-tabpanel[header='" + tabPanel + "'] p-columnfilter[ng-reflect-field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }

    public void selectBOUser(String text) throws InterruptedException {
        click(By.cssSelector("p-tabpanel[header='All users'] td span[ng-reflect-text='" + text + "']"));
        Thread.sleep(500);
    }

    public void editUserRole(String roleName) throws InterruptedException {
        click(By.cssSelector("p-button[label='Edit']"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), roleName);
        Thread.sleep(500);
        click(By.cssSelector("div[role='dialog'] p-button[ng-reflect-label='Confirm']"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Edit']")));
    }

    public void editUser(String firsname) throws InterruptedException {
        Thread.sleep(700);
        type(By.cssSelector("input[id*='input_firstName']"), firsname);
        Thread.sleep(1500);
        moveToElement(By.cssSelector("p-button[ng-reflect-label='Confirm']"));
        click(By.cssSelector("p-button[ng-reflect-label='Confirm']"));
        waitFor(By.xpath("//*[contains(text(), 'User updated successfully')]"));
    }

    public void unblockUser() {
        //click(By.cssSelector("p-button[ng-reflect-label='Unblock user']"));
        click(boUserHomePage.unblockUserBtn);
        click(By.cssSelector("p-button[ng-reflect-label='Confirm']"));
        waitFor(By.xpath("//*[contains(text(), 'User unblocked successfully')]"));
    }

    public void blockUser(String blockReason) throws InterruptedException {
        //click(By.cssSelector("div.buttons-wrap p-button[ng-reflect-label='Block user']"));
        click(boUserHomePage.blockUserBtn);
        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to block user')]"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), blockReason);
        Thread.sleep(1000);
        click(By.cssSelector("div[role='dialog'] p-button[ng-reflect-label='Confirm']"));
        waitFor(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitFor(By.cssSelector("td span[ng-reflect-text='Blocked']"));
    }

    public void closePopUpAndVirifyPopUpClosing() {
        closePopUp();
        verifyPopupClosing();
    }

    public void verifyPopupClosing() {
        waitForInvisibilityOfElement(By.cssSelector("div[role='dialog']"));
        assertFalse(isElementPresent(By.cssSelector("div[role='dialog']")));
    }
}