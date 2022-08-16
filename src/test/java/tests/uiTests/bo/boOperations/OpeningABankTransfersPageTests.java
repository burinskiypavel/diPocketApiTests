package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Test(dataProvider = "OpeningABankTransfersWithStateData")
    public void testOpeningABankTransfersWithState(String from, String till, String stateName, String file) throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoBankTransfersTab();
        app.getUiboHelper().searchForPeriod(from, till);
        app.getUiboHelper().selectFromDropDown(By.xpath("//p-columnfilter[@field='stateName']"), stateName);
        app.getUiboHelper().selectsTransfer(By.xpath("//td[@ng-reflect-text='"+stateName+"']"));

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

    @Test
    public void testOperationRevertForTheBankTransfersWithStateError() throws InterruptedException {
        app.getUiboHelper().gotoBOSiteAndLoginWithCBOUserRole(app.CBOuserLogin, app.CBOuserPass);
        app.getUiboHelper().gotoOperations();
        app.getUiboHelper().gotoBankTransfersTab();
        app.getUiboHelper().searchForPeriod("07.05.2012", "11.08.2022");
        app.getUiboHelper().selectFromDropDown(By.xpath("//p-columnfilter[@field='stateName']"), "Error");


        WebElement table = app.getUiboHelper().findElement(By.cssSelector("div.transactions table"));
        List<WebElement> webElements = table.findElements(By.xpath("//div[@class='transactions'] //table //tr //td[1]"));
        List<String> tableIdText = new ArrayList<>();

        for(WebElement element : webElements){
            System.out.println(element.getText());
            tableIdText.add(element.getText());
        }

        for (int i = 0; i< tableIdText.size(); i++){
            String currentId = tableIdText.get(i);
            System.out.println("count: " + i);
            Thread.sleep(1500);

            app.getUiboHelper().click(By.xpath("//td[@ng-reflect-text='"+currentId+"']"));
            Thread.sleep(1500);
            app.getUiboHelper().click(By.xpath("//p-button[@label='Check operation']"));

            Thread.sleep(1000);
            if(app.getUiboHelper().isElementPresent(By.xpath("//app-button[@ng-reflect-label='Revert']"))){
                System.out.println("Curent id with Revert button " + i +"_ " +  currentId);
                app.getUiboHelper().click(By.xpath("//app-button[@ng-reflect-label='Revert']"));
                app.getUiboHelper().type(By.xpath("//app-input[@ng-reflect-name='errorMessage'] //input"), "test");
                Thread.sleep(1500);
                app.getUiboHelper().click(By.xpath("//app-revert-modal //p-button[@ng-reflect-label='Revert']"));
                app.getUiboHelper().waitFor(By.xpath("//*[contains(text(), 'Message')]"));

                break;
            }
            else {
                continue;
            }

        }
    }
}