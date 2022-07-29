package base;

import appmanager.ApplicationManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void beforeClass() {
        app.initStart();
    }

    @BeforeTest
    public void setUp(){
        app.init();
    }

    public void printCurentThredId(){
        String className = this.getClass().getCanonicalName();
        System.out.println("Class Name: " + className + "  Current thred id: " + Thread.currentThread().getId());
    }
}