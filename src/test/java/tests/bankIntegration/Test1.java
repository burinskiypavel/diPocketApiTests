package tests.bankIntegration;

import base.UITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class Test1 extends UITestBase {

    @Test
    public void test() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app","c:/windows/system32/calc.exe"); //если хотим сразу запускать какую-либо программу
        cap.setCapability("launchDelay","5"); //задержка после запуска программы
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9999"),cap); //на этом порту по умолчанию висит Winium драйвер

        WebElement window = driver.findElement(By.className("CalcName"));
        WebElement menu = driver.findElement(By.id("MenuBar"));
//        menu.findElement(By.id("Item 1")).click();
//        menu.findElement(By.id("Item 304")).click();
//        menu.findElement(By.id("Item 1")).click();
//        menu.findElement(By.id("Item 305")).click();

        driver.findElement(By.id("132")).click();
    }
}
