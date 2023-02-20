package tests.bankIntegration;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DipocketConfigurations extends TestBase {
    List<String> actualSites = new ArrayList<>();

    @Test(priority = 1)
    public void test_verifySiteDipocket() throws SQLException, ClassNotFoundException {
        actualSites = app.getDbHelper().getSiteFromLHV_EE_MASTERSITE_FromTestDB(Site.DIPOCKET.toString());
        assertEquals(actualSites, Arrays.asList("DIPOCKET", "DIPOCKET", "DIPOCKET", "DIPOCKET"));
    }
}