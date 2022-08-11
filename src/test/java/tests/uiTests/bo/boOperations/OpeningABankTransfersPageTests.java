package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class OpeningABankTransfersPageTests extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testOpeningABankTransfersPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoBankTransfersTab();

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{"//table //th[contains(text(), 'Tran id')]",
                "//table //th[contains(text(), 'State')]", "//table //th[contains(text(), 'Payer id')]",
                "//table //th[contains(text(), 'Payer')]", "//table //th[contains(text(), 'Older date')]"}), "Incorrect headers");

        softAssert.assertTrue(app.getUiboHelper().areElementsPresent(new String[]{
                "//p-columnfilter[@field='tranId']", "//p-columnfilter[@field='stateName']",
                "//p-columnfilter[@field='payerId']", "//p-columnfilter[@field='payer']"}), "Incorrect filters");

        softAssert.assertTrue(app.getUiboHelper().isButtonEnabled(By.xpath("//p-button[@label='Search']")), "Search button is not present");
        softAssert.assertTrue(app.getUiboHelper().isElementPresent(By.xpath("//p-button[@label='Check operation'][@ng-reflect-disabled='true']")), "Button Check operation is not disabled");
        softAssert.assertAll();
    }

    @Test
    public void OpeningABankTransfersWithStateError() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoBankTransfersTab();

        app.getUiboHelper().click(By.xpath("//app-search-by-period //p-dropdown[@optionlabel='value']"));

        app.getUiboHelper().click(By.xpath("//p-dropdownitem[@ng-reflect-label='For period']"));

        app.getUiboHelper().type(By.xpath("//p-calendar[@placeholder='From'] //input"), "03.03.2019");
        app.getUiboHelper().type(By.xpath("//p-calendar[@placeholder='Till'] //input"), "11.08.2022");

        app.getUiboHelper().click(By.xpath("//p-button[@label='Search']"));

        app.getUiboHelper().click(By.xpath("//p-columnfilter[@field='stateName']"));
        app.getUiboHelper().click(By.xpath("//p-dropdownitem[@ng-reflect-label='Error']"));


        app.getUiboHelper().click(By.xpath("//td[@ng-reflect-text='Error']"));


        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//app-transactions-details //table //tbody //tr"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boOperations/OpeningABankTransfersWithStateError.txt");

        assertEquals(actualElementsText, expectedElementsText);
    }
}