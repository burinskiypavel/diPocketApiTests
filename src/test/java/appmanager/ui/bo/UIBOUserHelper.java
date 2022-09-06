package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIBOUserHelper extends UIHelperBase {

    public UIBOUserHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoRolesTab() {
        click(By.id("p-tabpanel-3-label"));
    }

    public void deleteRole() {
        click(By.cssSelector("p-button[label='Delete']"));
        click(By.cssSelector("app-role-delete-modal app-button[label='Delete']"));
        waitFor(By.xpath("//div[contains(text(), 'User role deleted successfully')]"));
    }

    public void addRole(String roleID, String roleName) throws InterruptedException {
        click(By.cssSelector("p-button[label='+ Add']"));
        waitForSeveralItems(new String[]{"Role ID:", "Role name:", "Add Role"});
        type(By.cssSelector("app-input[ng-reflect-name='roleId'] input[type='text']"), roleID);
        type(By.cssSelector("app-input[ng-reflect-name='roleName'] input[type='text']"), roleName);
        Thread.sleep(500);
        click(By.cssSelector("p-button[ng-reflect-label='Add']"));
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
        click(By.id("p-tabpanel-1-label"));
    }

    public void searchAndSelectBOUser(String tabPanel, String filter, String text) throws InterruptedException {
        searchBOUser(tabPanel, filter, text);
        selectBOUser(text);
    }

    public void searchBOUser(String tabPanel, String filter, String text) {
        type(By.cssSelector("p-tabpanel[header='" + tabPanel + "'] p-columnfilter[field='" + filter + "'] input[type='text']"), text);
        pressKeys(Keys.ENTER);
    }

    public void selectBOUser(String text) throws InterruptedException {
        click(By.cssSelector("p-tabpanel[header='All users'] td[ng-reflect-text='" + text + "']"));
        Thread.sleep(500);
    }

    public void editUserRole(String roleName) throws InterruptedException {
        click(By.cssSelector("p-button[label='Edit']"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), roleName);
        Thread.sleep(500);
        click(By.cssSelector("div[role='dialog'] p-button[ng-reflect-label='Edit']"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='dialog'] app-button[ng-reflect-label='Edit']")));
    }

    public void editUser(String firsname) throws InterruptedException {
        Thread.sleep(700);
        type(By.cssSelector("app-input[ng-reflect-name='firstName'] input[type='text']"), firsname);
        Thread.sleep(1500);
        click(By.cssSelector("p-button[ng-reflect-label='Edit user']"));
        waitFor(By.xpath("//*[contains(text(), 'User updated successfully')]"));
    }

    public void unblockUser() {
        click(By.cssSelector("app-button[ng-reflect-label='Unblock user']"));
        click(By.cssSelector("app-button[ng-reflect-label='Unblock']"));
        waitFor(By.xpath("//*[contains(text(), 'User unblocked successfully')]"));
    }

    public void blockUser(String blockReason) throws InterruptedException {
        click(By.cssSelector("div.buttons-wrap app-button[ng-reflect-label='Block user']"));
        waitFor(By.cssSelector("div[role='dialog']"));
        waitFor(By.xpath("//*[contains(text(), 'Are you sure want to block user')]"));
        type(By.cssSelector("div[role='dialog'] input[type='text']"), blockReason);
        Thread.sleep(1000);
        click(By.cssSelector("div[role='dialog'] p-button[ng-reflect-label='Block user']"));
        waitFor(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitForInvisibilityOfElement(By.xpath("//*[contains(text(), 'User blocked successfully')]"));
        waitFor(By.cssSelector("td[ng-reflect-text='Blocked']"));
    }
}