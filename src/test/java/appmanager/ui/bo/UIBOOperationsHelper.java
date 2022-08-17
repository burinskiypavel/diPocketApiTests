package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import padeObjects.bo.boOperations.BOOperationsBankTransfersPage;

import java.util.ArrayList;
import java.util.List;

public class UIBOOperationsHelper extends UIHelperBase {

    public UIBOOperationsHelper(WebDriver driver) {
        super(driver);
    }

    public void pressCheckOperation(){
        BOOperationsBankTransfersPage boOperationsBankTransfersPage = new BOOperationsBankTransfersPage(driver);
        boOperationsBankTransfersPage.pressCheckOperation();
    }

    public void verifyOperationRevertForTheBankTransfersWithStateError() throws InterruptedException {
        WebElement table = findElement(By.cssSelector("div.transactions table"));
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

            click(By.xpath("//td[@ng-reflect-text='"+currentId+"']"));
            Thread.sleep(1500);
            click(By.xpath("//p-button[@label='Check operation']"));

            Thread.sleep(1000);
            if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Revert']"))){
                System.out.println("Curent id with Revert button " + i +"_ " +  currentId);
                click(By.xpath("//app-button[@ng-reflect-label='Revert']"));
                type(By.xpath("//app-input[@ng-reflect-name='errorMessage'] //input"), "test");
                Thread.sleep(1500);
                click(By.xpath("//app-revert-modal //p-button[@ng-reflect-label='Revert']"));
                waitFor(By.xpath("//*[contains(text(), 'Message')]"));

                break;
            }
            else {
                continue;
            }

        }
    }

    public void verifyOperationSendAgaintForTheBankTransfersWithStateError() throws InterruptedException {
        WebElement table = findElement(By.cssSelector("div.transactions table"));
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

            click(By.xpath("//td[@ng-reflect-text='"+currentId+"']"));
            Thread.sleep(1500);
            click(By.xpath("//p-button[@label='Check operation']"));

            Thread.sleep(1000);
            if(isElementPresent(By.xpath("//app-button[@ng-reflect-label='Send again']"))){
                System.out.println("Curent id with Send again button " + i +"_ " +  currentId);
                click(By.xpath("//app-button[@ng-reflect-label='Send again']"));
                type(By.xpath("//app-input[@ng-reflect-name='errorMessage'] //input"), "test");
                Thread.sleep(1500);
                click(By.xpath("//app-revert-modal //p-button[@ng-reflect-label='Send again']"));
                waitFor(By.xpath("//*[contains(text(), 'Message')]"));

                break;
            }
            else {
                continue;
            }

        }
    }
}