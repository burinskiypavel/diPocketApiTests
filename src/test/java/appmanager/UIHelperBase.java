package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UIHelperBase {
    protected WebDriver driver;
    public WebDriverWait wait;

    public UIHelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void waitFor(By locator){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForSeveralItems(String mas []){
        wait = new WebDriverWait(driver, 25);
        for(int i = 0; i < mas.length; i++){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+mas[i]+"')]")));
        }
    }

   public void pressKeys(Keys key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    public void waitForInvisibilityOfElement(By locator) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void moveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void performContextClick(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

        public void waitForElementToBeClickable(By locator){
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getTextFromPopUp2(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator).getText();
    }

    public boolean areElementsPresent(String mas []){
        boolean bool = false;
        for(int i = 0; i < mas.length; i++){

            bool =  isElementPresent(By.xpath(mas[i]));

            if(bool == false){
                System.out.println("element is not present: " + mas[i]);
                return false;
            }
        }
        return true;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public boolean isDefault(By locator) {
        boolean bool = isElementPresent(locator);
        return bool;
    }

    public boolean isTabActiveAndSelected(By locator) {
        boolean bool = isElementPresent(locator);
        return bool;
    }

    public boolean isPageOpen(By locator) {
        boolean bool = isElementPresent(locator);
        return bool;
    }

    public boolean areButtonsPresent(String mas []){
        boolean bool = false;
        for(int i = 0; i < mas.length; i++){

            bool =  isElementPresent(By.xpath(mas[i]));

            if(bool == false){
                System.out.println("button is not present: " + mas[i]);
                return false;
            }
        }
        return true;
    }

    public boolean areElementsPresentAfterSorting(By locator){
        boolean bool;
        int size = driver.findElements(locator).size();
        if(size >= 1){
            bool = true;
        }
        else {
            bool = false;
        }
        return bool;
    }

    public void deleteTextFromTextarea(By locator) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

    public void deleteText(WebElement id) {
        id.sendKeys(Keys.CONTROL + "a");
        id.sendKeys(Keys.DELETE);
    }

    public void clickCheckbox(By locator) {
        driver.findElement(locator).click();
    }

    public String getText(By by, int index) {
        WebElement state = driver.findElements(by).get(index);
        return state.getText();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public List<String> getActualText(By locator) {
        List<String> actualElementsText = new ArrayList<>();

        List<WebElement> elements = driver.findElements(locator);

        //int count = 0;
        for(WebElement element : elements){
            String text = element.getText();

            if(text.equals("")){

            }
            else {
                actualElementsText.add(text);
                actualElementsText.add("\r\n");
            }
            //if(count == 3){
            //    break;
            //}
            //count++;
        }

        System.out.println(actualElementsText);
        return actualElementsText;
    }

    public List<String> getDateFromFile(String path) {
        List<String> table = new ArrayList<String>();
        //String fullPathToFile = "/AdminReports/QA/" + path;//QA

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {

            String line;
            while ((line = br.readLine()) != null) {
                table.add(line);
                table.add("\r\n");


                //StringBuilder result = new StringBuilder();
                //  result.append('\n').append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }

    public void closePopUp(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    public String getAttributeFromMultiple(By locator, int index) {
        return driver.findElements(locator).get(index).getAttribute("ng-reflect-text");
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public void moveToElementAction(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void uploadFile(By locator, String path) {
        WebElement fileInput = driver.findElement(locator);
        fileInput.sendKeys(path);
    }

    public void performContextClickFromTable(String text) {
        WebElement element = driver.findElement(By.cssSelector("td[ng-reflect-text='"+text+"']"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public boolean isDefault2(By locator) {
        WebElement element = driver.findElement(locator);
        boolean ariaSelected = Boolean.parseBoolean(element.getAttribute("aria-selected"));
        return ariaSelected;
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public List<String> getActualText2(By locator) {
        List<String> actualElementsText = new ArrayList<>();

        List<WebElement> elements = driver.findElements(locator);

        int count = 0;
        for(WebElement element : elements){
            String text = element.getText();

            text = text.replace("\n", " ").replace("\r", " ");

            if(text.equals("")){

            }
            else {
                actualElementsText.add(text);
                //actualElementsText.add("\r\n");
            }
            if(count == 3){
                break;
            }
            count++;
        }

        System.out.println(actualElementsText);
        return actualElementsText;
    }

    public List<String> getDateFromFile2(String path) {
        List<String> table = new ArrayList<String>();
        //String fullPathToFile = "/AdminReports/QA/" + path;//QA

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {

            String line;
            while ((line = br.readLine()) != null) {
                table.add(line);
                //table.add("\n");


                //StringBuilder result = new StringBuilder();
                //  result.append('\n').append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }

    public boolean isButtonEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    public boolean isPopUpClosed(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='dpwa-alert'][aria-hidden='true']")));
        if(driver.findElements(By.cssSelector("div[id='dpwa-alert'][aria-hidden='true']")).size() == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public String getAttributeValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }

    public String getColorOfElement(By locator, String cssValue) throws InterruptedException {
        Thread.sleep(2000);

        String color =  driver.findElement(locator).getCssValue(cssValue);

        System.out.println("color: " + color);
        String hex = Color.fromString(color).asHex();
        System.out.println("hex: " + hex);
        return hex;
    }

    public void waitForSeveralItems2(String mas []){
        wait = new WebDriverWait(driver, 20);
        for(int i = 0; i < mas.length; i++){
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(mas[i])));
        }
    }

    public void basicAuth(String url, String login, String password) {
        //driver.navigate().to("https://dipocket:LeprechauN@telenor-test.dipocket.org");
        driver.navigate().to("https://"+login+":"+password+"@"+url+"");
    }

    public void pressConfirm(By locator){
        driver.findElement(locator).click();
    }

    public boolean isCheckboxSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    public boolean isTabPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public void selectFromSelect(By locator, String text) {
        new Select(driver.findElement(locator)).selectByVisibleText(text);
    }

    public boolean isElementHasRedColor(By locator) {
        if(driver.findElements(locator).size() == 1){
            return true;
        } else {
            return false;
        }
    }

    public void pressBackSpace() {
        Actions actions = new Actions(driver);
        Action seriesOfActions = actions
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE)
                .build();
        seriesOfActions.perform() ;
    }

    public void closePopUpFromMultiple(By locator, int index) {
        //wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElements(locator).get(index).click();
    }

    public List<String> getActualTextAttributeValue(By locator) {
        List<String> actualElementsText = new ArrayList<>();

        List<WebElement> elements = driver.findElements(locator);

        for(WebElement element : elements){
            String text = element.getAttribute("Value");

            if(text == null){

            }
            else {
                actualElementsText.add(text);
                actualElementsText.add("\r\n");
            }
        }

        System.out.println(actualElementsText);
        return actualElementsText;
    }

    public String getTextFromPopUp() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Ok')]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='dpwa-alert'][aria-hidden='false']")));
        return driver.findElement(By.cssSelector("div.uk-modal-content")).getText();
    }
}