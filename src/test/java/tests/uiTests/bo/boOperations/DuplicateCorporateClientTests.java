package tests.uiTests.bo.boOperations;

import base.UITestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DuplicateCorporateClientTests extends UITestBase {
    String id = "34359";

    @Test
    public void testDuplicateCorporateClient() throws InterruptedException {
        app.getUiboOperationsHelper().initDuplicateCorporateClient(app.CBOuserLogin2, app.CBOuserPass2, id);
        app.getUiboOperationsHelper().pressCopyButton();

        app.getUiboOperationsHelper().setCountryOfContract("United Kingdom");
        Thread.sleep(700);
        app.getUiboOperationsHelper().pressNext();
        app.getUiboOperationsHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='city']"));

        app.getUiboOperationsHelper().pressNext();
        app.getUiboOperationsHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='accName']"));

        app.getUiboOperationsHelper().setAccountName("Test corp account");
        app.getUiboOperationsHelper().setAccountType("Regular");
        app.getUiboOperationsHelper().setCountryOfContract("United Kingdom");
        Thread.sleep(700);
        app.getUiboHelper().clickWithJS(By.xpath("//p-button[@ng-reflect-label='Next']"));

        app.getUiboHelper().waitFor(By.xpath("//app-create-corporate-client //p-button[@ng-reflect-label='Create']"));

        //List<String> actualText = app.getUiboHelper().getActualText(By.xpath("//app-confirmation-step //tbody //tr"));
        //List<String> expectedText = app.getUiboHelper().getDateFromFile("files/bo/boOperations/duplicateCorporateClient.txt");

        //assertEquals(actualText, expectedText, "5 page data");

        app.getUiboOperationsHelper().createCorporateClientWithMessage("Corporate client was created successfully");
        app.getUiboHelper().waitFor(By.xpath("//app-corp-client-info //div[3] //p"));

        List<String> actualClientDetails = app.getUiboHelper().getActualText(By.xpath("//app-corp-client-info //div[3] //p"));
        List<String> expectedClientDetails = app.getUiboHelper().getDateFromFile("files/bo/boOperations/duplicateCorporateClientClientDitails.txt");

        assertEquals(actualClientDetails, expectedClientDetails, "client datails page");
    }

    @Test
    public void testDuplicationOfCorporateClientDataWithoutAccount() throws InterruptedException {
        app.getUiboOperationsHelper().initDuplicateCorporateClient(app.CBOuserLogin2, app.CBOuserPass2, id);
        app.getUiboOperationsHelper().pressCopyButton();

        app.getUiboOperationsHelper().setCountryOfContract("United Kingdom");
        Thread.sleep(700);
        app.getUiboOperationsHelper().pressNext();
        app.getUiboOperationsHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='city']"));

        app.getUiboOperationsHelper().pressNext();
        app.getUiboOperationsHelper().waitFor(By.cssSelector("app-input[ng-reflect-name='accName']"));

        app.getUiboOperationsHelper().setNoAccount();
        app.getUiboOperationsHelper().verifyInvisibilityOfTheFieldsOnFourthPageAfterSetNoAccount();
        app.getUiboHelper().clickWithJS(By.xpath("//p-button[@ng-reflect-label='Next']"));
        app.getUiboHelper().waitFor(By.xpath("//app-create-corporate-client //p-button[@ng-reflect-label='Create']"));

        app.getUiboOperationsHelper().createCorporateClientWithMessage("Corporate client was created successfully");
        app.getUiboHelper().waitFor(By.xpath("//app-corp-client-info //div[3] //p"));

        List<String> actualClientDetails = app.getUiboHelper().getActualText(By.xpath("//app-corp-client-info //div[3] //p"));
        List<String> expectedClientDetails = app.getUiboHelper().getDateFromFile("files/bo/boOperations/duplicateCorporateClientClientWithoutAccountDitails.txt");

        assertEquals(actualClientDetails, expectedClientDetails, "client datails page");
    }
}