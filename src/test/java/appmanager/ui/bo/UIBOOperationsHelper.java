package appmanager.ui.bo;

import appmanager.UIHelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import padeObjects.bo.boOperations.BOOperationsBankTransfersPage;
import padeObjects.bo.boOperations.BOOperationsCreateCorporateClientFirstPage;
import padeObjects.bo.boOperations.BOOperationsCreateCorporateClientForthPage;
import padeObjects.bo.boOperations.BOOperationsCreateCorporateClientSecondPage;

import java.util.ArrayList;
import java.util.List;

public class UIBOOperationsHelper extends UIHelperBase {

    public UIBOOperationsHelper(WebDriver driver) {
        super(driver);
    }

    public void selectDropDownFilter(String dropdown, String dropdownItem) {
        click(By.xpath("//p-columnfilter[@field='" + dropdown + "']"));
        waitFor(By.cssSelector("p-dropdownitem[ng-reflect-label='" + dropdownItem + "']"));
        click(By.cssSelector("p-dropdownitem[ng-reflect-label='" + dropdownItem + "']"));
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

    public void gotoOperations() {
        click(By.cssSelector("div[ng-reflect-router-link='operations']"));
        waitFor(By.xpath("//a[@role='tab'] //span[contains(text(), 'Fee tariff plan')]"));
    }

    public void gotoFeeTariffPlanTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Fee tariff plan')]"));
    }

    public void gotoCreateCorporateClientTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Create corporate client')]"));
    }

    public void gotoLimitPlanTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Limit plan')]"));
    }

    public void gotoResetSMSCounterTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Reset SMS counter')]"));
    }

    public void gotoBankTransfersTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'Bank transfers')]"));
    }

    public void gotoGPSWSIDCheckTab() {
        click(By.xpath("//a[@role='tab'] //span[contains(text(), 'GPS WSID check')]"));
    }

    public void searchForPeriod(String from, String till) throws InterruptedException {
        selectFromDropDown(By.xpath("//app-search-by-period //p-dropdown[@optionlabel='value']"), "For period");
        type(By.xpath("//p-calendar[@placeholder='From'] //input"), from);
        type(By.xpath("//p-calendar[@placeholder='Till'] //input"), till);
        click(By.xpath("//p-button[@label='Search']"));
    }

    public void selectsTransfer(By locator) {
        click(locator);
    }

    public void selectFeeTariffPlanAndSelectRuleFilterInTheTable(String feeTariffPlan, String rule) throws InterruptedException {
        selectFromDropDown("name", feeTariffPlan);
        Thread.sleep(1000);
        selectDropDownFilter("ruleName", rule);
    }

    public void addRowInTariffPlan(String rule, String feePercent, String currency, String feeCurrency, String minFeeAmount, String maxFeeAmount, String flatFeeAmount) throws InterruptedException {
        fillTheFieldsForAddRowInTariffPlan(rule, feePercent, currency, feeCurrency, minFeeAmount, maxFeeAmount, flatFeeAmount);
        Thread.sleep(1000);
        click(By.xpath("//p-button[@label='Add']"));
        waitFor(By.xpath("//*[contains(text(), 'Tariff plan has been successfully added')]"));
    }

    public void fillTheFieldsForAddRowInTariffPlan(String rule, String feePercent, String currency, String feeCurrency, String minFeeAmount, String maxFeeAmount, String flatFeeAmount) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='+ Add row']"));
        waitFor(By.cssSelector("p-dropdown[id*='select_ruleId_0']"));
        selectFromDropDown(By.cssSelector("p-dropdown[id*='select_ruleId_0']"), rule);
        type(By.cssSelector("p-inputnumber[id*='input-number_feePercent_3'] input"), feePercent);
        type(By.cssSelector("p-inputnumber[id*='input-number_minFeeAmount_5'] input"), minFeeAmount);
        type(By.cssSelector("p-inputnumber[id*='input-number_maxFeeAmount_6'] input"), maxFeeAmount);
        type(By.cssSelector("p-inputnumber[id*='input-number_flatFeeAmount_4'] input"), flatFeeAmount);
        selectFromDropDown(By.cssSelector("p-dropdown[id*='select_currencyId_1']"), currency);
        selectFromDropDown(By.cssSelector("p-dropdown[id*='select_feeCurrencyId_2']"), feeCurrency);
    }

    public void addTarifPlan(String id, String name) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Add tariff plan']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='id'] //input"), id);
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Add']"));
    }

    public void deleteTarifPlan(String name) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Delete tariff plan']"));
        waitFor(By.xpath("//app-delete-tariff-plan-modal //*[contains(text(), '"+name+"')]"));
        Thread.sleep(1200);
        click(By.xpath("//p-button[@ng-reflect-label='Delete']"));
    }

    public void duplicateTarifPlan(String id, String name) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Duplicate tariff plan']"));
        type(By.cssSelector("p-inputnumber[id*='input-number_newFeeTariffPlanId'] input"), id);
        type(By.cssSelector("input[id*='input_feeTariffPlanName']"), name);
        Thread.sleep(1200);
        click(By.xpath("//p-button[@ng-reflect-label='Confirm']"));
    }

    public void pressPencilEditButton(int index) {
        WebElement pencil = driver.findElements(By.xpath("//button[@icon='pi pi-pencil']")).get(index);
        pencil.click();
    }

    public void pressPencilEditButton(By locator) {
        driver.findElement(locator).click();
    }

    public void editTariffPlanRow(String rule, String currency, String feePercent, String feeCurrency, String minFeeAmount, String maxFeeAmount, String flatFeeAmount) throws InterruptedException {
        selectFromDropDown(By.xpath("//app-fee-tariff-plan-tab //tbody //td[2] //p-dropdown"), rule);
        selectFromDropDown(By.xpath("//app-fee-tariff-plan-tab //tbody //td[4] //p-dropdown"), currency);
        type(By.xpath("//app-fee-tariff-plan-tab //tbody //td[5] //input"), feePercent);
        selectFromDropDown(By.xpath("//app-fee-tariff-plan-tab //tbody //td[6] //p-dropdown"), feeCurrency);
        type(By.xpath("//app-fee-tariff-plan-tab //tbody //td[7] //input"), minFeeAmount);
        type(By.xpath("//app-fee-tariff-plan-tab //tbody //td[8] //input"), maxFeeAmount);
        type(By.xpath("//app-fee-tariff-plan-tab //tbody //td[9] //input"), flatFeeAmount);
        click(By.xpath("//button[@ng-reflect-icon='pi pi-check']"));
        waitFor(By.xpath("//*[contains(text(), 'Row added successfully')]"));
    }

    public void deleteRow(int index) {
        List<WebElement> elements = driver.findElements(By.xpath("//button[@ng-reflect-icon='pi pi-trash']"));
        WebElement element = elements.get(index);
        element.click();
        waitFor(By.xpath("//*[contains(text(), 'Row deleted successfully')]"));
    }

    public void deleteRow(By locator, int index) {
        List<WebElement> elements = driver.findElements(locator);
        WebElement element = elements.get(index);
        element.click();
        waitFor(By.xpath("//*[contains(text(), 'Row deleted successfully')]"));
    }

    public void selectLimitPlan(String limitPlan) throws InterruptedException {
        selectFromDropDown(By.xpath("//div[@class='dropdowns'] //p-dropdown[@optionlabel='name']"), limitPlan);
    }

    public void addRowInLimitPlan(String limitAmount, String group, String type) throws InterruptedException {
        click(By.xpath("//app-limit-plan-tab //p-button[@ng-reflect-label='+ Add row']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='limitAmount'] //input"), limitAmount);
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='tranGroupId']"), group);
        selectFromDropDown(By.xpath("//app-select-async[@ng-reflect-name='typeId']"), type);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Add']"));
        waitFor(By.xpath("//*[contains(text(), 'Limit plan has been successfully added')]"));
    }

    public void editLimitPlanRow(String group, String type, String amount) throws InterruptedException {
        selectFromDropDown(By.xpath("//app-limit-plan-tab //tbody //td[2] //p-dropdown"), group);
        selectFromDropDown(By.xpath("//app-limit-plan-tab //tbody //td[3] //p-dropdown"), type);
        typeWithSeveralClear(By.xpath("//app-limit-plan-tab //tbody //td[4] //input"), amount);
        click(By.xpath("//button[@ng-reflect-icon='pi pi-check']"));

        waitFor(By.xpath("//*[contains(text(), 'Row added successfully')]"));
    }

    public void pressXCancelButton(By locator) {
        click(locator);
    }

    public void duplicateLimitPlan(String id, String name) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Duplicate limit plan']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='id'] //input"), id);
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Duplicate']"));
    }

    public void renameLimitPlan(String name) {
        click(By.xpath("//p-button[@ng-reflect-label='Rename limit plan']"));
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        click(By.xpath("//p-button[@ng-reflect-label='Rename']"));
    }

    public void deleteLimitPlan() throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Delete limit plan']"));
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Delete']"));
    }

    public void addLimitPlan(String id, String name) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Add limit plan']"));
        type(By.xpath("//app-input-number[@ng-reflect-name='id'] //input"), id);
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), name);
        Thread.sleep(1500);
        click(By.xpath("//p-button[@ng-reflect-label='Add']"));
        waitFor(By.xpath("//*[contains(text(), 'Tariff limit added successfully')]"));
    }

    public void renameTariffPlan(String newName) throws InterruptedException {
        click(By.xpath("//p-button[@ng-reflect-label='Rename tariff plan']"));
        waitFor(By.xpath("//app-input[@ng-reflect-name='name'] //input"));
        type(By.xpath("//app-input[@ng-reflect-name='name'] //input"), newName);
        Thread.sleep(1000);
        click(By.xpath("//p-button[@ng-reflect-label='Rename']"));
        waitFor(By.xpath("//div[contains(text(), 'Tariff plan renamed successfully')]"));
    }

    public void setState(String error) throws InterruptedException {
        selectFromDropDown(By.xpath("//p-columnfilter[@field='stateName']"), error);
    }

    public void setClientType(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.clientTypeDropdown, item);
    }

    public void setCompanyName(String text) {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        BOOperationsCreateCorporateClientFirstPage.setCompanyName(text);
    }

    public void setIdentificationCode(String code) {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        BOOperationsCreateCorporateClientFirstPage.setIdentificationCode(code);
    }

    public void setSite(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.clientSiteDropDown, item);
    }

    public void setLanguage(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.languageDropDown, item);
    }

    public void setCurrency(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.currencyDropdown, item);
    }

    public void setDueDiligenceStatus(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.dueDiligenceStatusDropdown, item);
    }

    public void setFeeTariffPlan(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.feeTariffPlanDropdown, item);
    }

    public void setCardProgramByDefault(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.cardProgramByDefaultDropdown, item);
    }

    public void setOperationsLimitPlan(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.operLimitPlanDropdown, item);
    }

    public void setTransactionsLimitPlan(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.transactionsLimitPlanDropdown, item);
    }

    public void setCountryOfContract(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        selectFromDropDown(BOOperationsCreateCorporateClientFirstPage.countryOfContractDropdown, item);
    }

    public void pressNext() {
        BOOperationsCreateCorporateClientFirstPage BOOperationsCreateCorporateClientFirstPage = new BOOperationsCreateCorporateClientFirstPage(driver);
        BOOperationsCreateCorporateClientFirstPage.pressNext();
    }

    public void creationOfACorporateClientFillingInTheDataOfTheFirstPage(String clientType, String companyName, String identificationCode, String site, String language, String currency, String dueDiligenceStatus, String feeTariffPlan, String cardProgramByDefault, String operationsLimitPlan, String transactionsLimitPlan, String countryOfContract) throws InterruptedException {
        setClientType(clientType);
        setCompanyName(companyName);
        setIdentificationCode(identificationCode);
        setSite(site);
        setLanguage(language);
        setCurrency(currency);
        setDueDiligenceStatus(dueDiligenceStatus);
        setFeeTariffPlan(feeTariffPlan);
        setCardProgramByDefault(cardProgramByDefault);
        setOperationsLimitPlan(operationsLimitPlan);
        setTransactionsLimitPlan(transactionsLimitPlan);
        setCountryOfContract(countryOfContract);
        Thread.sleep(1500);
        pressNext();
        waitFor(By.cssSelector("app-input[ng-reflect-name='city']"));
    }

    public void setCountry(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientSecondPage boOperationsCreateCorporateClientSecondPage = new BOOperationsCreateCorporateClientSecondPage(driver);
        selectFromDropDown(boOperationsCreateCorporateClientSecondPage.countryDropdown, item);
    }

    public void setPostalCode(String text) throws InterruptedException {
        BOOperationsCreateCorporateClientSecondPage boOperationsCreateCorporateClientSecondPage = new BOOperationsCreateCorporateClientSecondPage(driver);
        boOperationsCreateCorporateClientSecondPage.setPostalCode(text);
    }

    public void setCity(String text) {
        BOOperationsCreateCorporateClientSecondPage boOperationsCreateCorporateClientSecondPage = new BOOperationsCreateCorporateClientSecondPage(driver);
        boOperationsCreateCorporateClientSecondPage.setCity(text);
    }

    public void setAddress(String text) {
        BOOperationsCreateCorporateClientSecondPage boOperationsCreateCorporateClientSecondPage = new BOOperationsCreateCorporateClientSecondPage(driver);
        boOperationsCreateCorporateClientSecondPage.setAddress(text);
    }

    public void setAddressLine2(String text) {
        BOOperationsCreateCorporateClientSecondPage boOperationsCreateCorporateClientSecondPage = new BOOperationsCreateCorporateClientSecondPage(driver);
        boOperationsCreateCorporateClientSecondPage.setAddressLine2(text);
    }

    public void clickUseThisAsMailingCheckbox() {
        BOOperationsCreateCorporateClientSecondPage boOperationsCreateCorporateClientSecondPage = new BOOperationsCreateCorporateClientSecondPage(driver);
        boOperationsCreateCorporateClientSecondPage.clickUseThisAsMailingCheckbox();
    }

    public void creationOfACorporateClientFillingInTheDataOfTheSecondPage(String country, String postalCode, String city, String address, String addressLine2, boolean checkbox, String state) throws InterruptedException {
        setCountry(country);
        setPostalCode(postalCode);
        setCity(city);
        setAddress(address);
        setAddressLine2(addressLine2);
        if(checkbox){
            clickUseThisAsMailingCheckbox();
        }

        if(!state.equals("")){
            type(By.xpath("//app-input[@ng-reflect-name='state'] //input"), state);
            Thread.sleep(1500);
            pressNext();
        } else {
            Thread.sleep(1500);
            pressNext();
            waitFor(By.cssSelector("app-input[ng-reflect-name='city']"));
        }
    }

    public void creationOfACorporateClientFillingInTheDataOfTheThirdPage(String country, String postalCode, String city, String address, String addressLine2, boolean checkbox) throws InterruptedException {
        setCountry(country);
        setPostalCode(postalCode);
        setCity(city);
        setAddress(address);
        setAddressLine2(addressLine2);
        if(checkbox){
            clickUseThisAsMailingCheckbox();
        }
        Thread.sleep(1500);
        pressNext();
        waitFor(By.cssSelector("app-input[ng-reflect-name='accName']"));
    }

    public void setAccountName(String text) {
        BOOperationsCreateCorporateClientForthPage boOperationsCreateCorporateClientForthPage = new BOOperationsCreateCorporateClientForthPage(driver);
        boOperationsCreateCorporateClientForthPage.setAccountName(text);
    }

    public void setAccountType(String item) throws InterruptedException {
        BOOperationsCreateCorporateClientForthPage boOperationsCreateCorporateClientForthPage = new BOOperationsCreateCorporateClientForthPage(driver);
        selectFromDropDown(boOperationsCreateCorporateClientForthPage.accountType, item);
    }

    public void pressNext4Page() {
        BOOperationsCreateCorporateClientForthPage boOperationsCreateCorporateClientForthPage = new BOOperationsCreateCorporateClientForthPage(driver);
        boOperationsCreateCorporateClientForthPage.pressNext();
    }

    public void creationOfACorporateClientFillingInTheDataOfTheFourthPage(String accountName, String accountType) throws InterruptedException {
        setAccountName(accountName);
        setAccountType(accountType);
    }

    public void setNoAccount() throws InterruptedException {
        waitForElementToBeClickable(By.xpath("//p-radiobutton[@ng-reflect-label='No account']"));
        Thread.sleep(500);
        click(By.xpath("//p-radiobutton[@ng-reflect-label='No account']"));
    }

    public void createCorporateClientWithMessage(final String message) {
        click(By.xpath("//app-create-corporate-client //p-button[@ng-reflect-label='Create']"));
        waitFor(By.xpath("//*[contains(text(), '" + message + "')]"));
        waitFor(By.xpath("//app-client-button-block //span[contains(text(), 'Search')]"));
    }

    public void verifyInvisibilityOfTheFieldsOnFourthPageAfterSetNoAccount() {
        waitForInvisibilityOfElement(By.xpath("//app-input[@ng-reflect-name='accName'] //input"));
    }
}