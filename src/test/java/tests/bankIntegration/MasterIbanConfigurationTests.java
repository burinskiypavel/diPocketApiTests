package tests.bankIntegration;

import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MasterIbanConfigurationTests extends TestBase {
    List<String> actualrow = new ArrayList<>();

    @Test
    public void test_masterIbanConfiguration_1row() throws SQLException, ClassNotFoundException {
        actualrow = app.getDbHelper().getMasterIBAN_FromTestDB(1);
        assertEquals(actualrow, Arrays.asList("1", "EE657700771001359322", "440"));
    }

    @Test
    public void test_masterIbanConfiguration_2row() throws SQLException, ClassNotFoundException {
        actualrow = app.getDbHelper().getMasterIBAN_FromTestDB(2);
        assertEquals(actualrow, Arrays.asList("2", "GB61LHVB04032800005804", "440"));
    }

    @Test
    public void test_masterIbanConfiguration_3row() throws SQLException, ClassNotFoundException {
        actualrow = app.getDbHelper().getMasterIBAN_FromTestDB(3);
        assertEquals(actualrow, Arrays.asList("3", "EE127700771001359306", "826"));
    }

    @Test
    public void test_masterIbanConfiguration_4row() throws SQLException, ClassNotFoundException {
        actualrow = app.getDbHelper().getMasterIBAN_FromTestDB(4);
        assertEquals(actualrow, Arrays.asList("4", "GB31LHVB04032800004986", "826"));
    }
}