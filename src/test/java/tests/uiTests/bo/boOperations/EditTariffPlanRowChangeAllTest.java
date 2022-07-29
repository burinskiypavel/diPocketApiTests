package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class EditTariffPlanRowChangeAllTest extends UITestBase {


    @Test
    public void testEditTariffPlanRowChangeAll() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoFeeTariffPlanTab();
        app.getUiboHelper().selectFromDropDown("name", "United Kingdom - standard");
        Thread.sleep(1000);
        app.getUiboHelper().selectDropDownFilter("ruleName", "Apple Pay bonus");

        WebElement pencil = driver.findElements(By.xpath("//button[@icon='pi pi-pencil']")).get(1);
        pencil.click();

        app.getUiboHelper().selectDropDownFromMultipleElements(By.xpath("//p-dropdown[@ng-reflect-model='Apple Pay bonus']"), 1,"Fee for Face to Face");

        app.getUiboHelper().selectDropDownFromMultipleElements(By.xpath("//p-dropdown[@ng-reflect-model='GBP']"), 0,"EUR");

        WebElement row = driver.findElement(By.xpath("//tr[2]"));

        WebElement feePercentCell = row.findElements(By.xpath("//p-celleditor //input")).get(3);
        feePercentCell.clear();
        feePercentCell.sendKeys("1");

        app.getUiboHelper().selectDropDownFromMultipleElements(By.xpath("//p-dropdown[@ng-reflect-model='GBP']"), 0,"EUR");

        WebElement minFeeAmountCell = row.findElements(By.xpath("//p-celleditor //input")).get(5);
        minFeeAmountCell.clear();
        minFeeAmountCell.sendKeys("2");


        WebElement maxFeeAmountCell = row.findElements(By.xpath("//p-celleditor //input")).get(6);
        maxFeeAmountCell.clear();
        maxFeeAmountCell.sendKeys("1");


        WebElement flatFeeAmountCell = row.findElements(By.xpath("//p-celleditor //input")).get(7);
        flatFeeAmountCell.clear();
        flatFeeAmountCell.sendKeys("1");

        click(By.xpath("//button[@ng-reflect-icon='pi pi-check']"));
    }
}
