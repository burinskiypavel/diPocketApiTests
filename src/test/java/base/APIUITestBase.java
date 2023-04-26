package base;

import appmanager.ApplicationManager;
import appmanager.ApplicationManagerUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class APIUITestBase {
    public WebDriver driver;
    public WebDriverWait wait;

    protected final ApplicationManager app = new ApplicationManager();
    protected final ApplicationManagerUI appUi = new ApplicationManagerUI();

    @BeforeClass
    public void beforeClass() {
        app.initStart();
    }

    @BeforeTest
    public void setUp(){
        app.init();
    }

    @BeforeClass
    public void start() {
        appUi.initStart();
        appUi.init();
    }

    @AfterClass
    public void stop(){
        appUi.closeDriver();
    }

    public void printCurentThredId(){
        String className = this.getClass().getCanonicalName();
        System.out.println("Class Name: " + className + "  Current thred id: " + Thread.currentThread().getId());
    }
}