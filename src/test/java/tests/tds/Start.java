package tests.tds;

import com.beust.jcommander.internal.Lists;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import java.util.List;

public class Start {
    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add("C:\\Users\\pa.burinsky\\Documents\\diPocketApiTests3\\testng3.xml");
        testng.setTestSuites(suites);
        testng.run();
    }
}
