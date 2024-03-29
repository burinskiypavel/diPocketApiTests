package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class BankTransfersPageTests extends UITestBase {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testOpeningABankTransfersPage() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoBankTransfersTab();

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

    @Test(dataProvider = "OpeningABankTransfersWithStateData")
    public void testOpeningABankTransfersWithState(String from, String till, String stateName, String file) throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoBankTransfersTab();
        app.getUiboOperationsHelper().searchForPeriod(from, till);
        app.getUiboOperationsHelper().setState(stateName);
        app.getUiboOperationsHelper().selectsTransfer(By.xpath("//td[@ng-reflect-text='"+stateName+"']"));

        List<String> actualElementsText = app.getUiboHelper().getActualText(By.xpath("//app-transactions-details //table //tbody //tr"));
        List<String> expectedElementsText = app.getUiboHelper().getDateFromFile("files/bo/boOperations/"+file+"");

        assertEquals(actualElementsText, expectedElementsText);
    }

    @DataProvider
    public Iterator<Object[]> OpeningABankTransfersWithStateData(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"03.03.2019", "11.08.2022", "Error", "openingABankTransfersWithStateError.txt"});
        list.add(new Object[] {"03.03.2019", "11.08.2022", "To do", "openingABankTransfersWithStateToDo.txt"});
        list.add(new Object[] {"03.03.2019", "11.08.2022", "Processing", "openingABankTransfersWithStateProcessing.txt"});
        list.add(new Object[] {"03.03.2019", "11.08.2022", "Done", "openingABankTransfersWithStateDone.txt"});
        return list.iterator();
    }

    @Test(enabled = false)//the data for this period don't have Operation revert to test
    public void testOperationRevertForTheBankTransfersWithStateError() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoBankTransfersTab();
        app.getUiboOperationsHelper().searchForPeriod("07.05.2012", "11.08.2022");
        app.getUiboOperationsHelper().setState("Error");

        app.getUiboOperationsHelper().verifyOperationRevertForTheBankTransfersWithStateError();
    }

    @Test(enabled = false)//the data for this period don't have operation SendAgain to test
    public void testOperationSendAgainForTheBankTransfersWithStateError() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoBankTransfersTab();
        app.getUiboOperationsHelper().searchForPeriod("07.05.2012", "11.08.2022");
        app.getUiboOperationsHelper().setState("Error");

        app.getUiboOperationsHelper().verifyOperationSendAgaintForTheBankTransfersWithStateError();
    }

    @Test
    public void testNoNewOperationButtonInBankTransfer() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboOperationsHelper().gotoOperations();
        app.getUiboOperationsHelper().gotoBankTransfersTab();
        app.getUiboOperationsHelper().searchForPeriod("07.05.2012", "11.08.2022");
        app.getUiboOperationsHelper().setState("Error");
        app.getUiboOperationsHelper().selectsTransfer(By.xpath("//td[@ng-reflect-text='Error']"));
        app.getUiboOperationsHelper().pressCheckOperation();
        app.getUiboHelper().waitForInvisibilityOfElement(By.xpath("//p-button[@label='Check operation']"));

        app.getUiboHelper().verifyAmountOfButtonsOnThePage(By.cssSelector("div.action-buttons p-button"), 0);
    }
}