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
    List<String> actualrow = new ArrayList<>();

    @Test(priority = 1)
    public void test_verifySiteDipocketRowWithMasterACCIDSiteCountryIdCurrencyIdFromLHV_EE_MASTERSITE() throws SQLException, ClassNotFoundException {
        actualrow = app.getDbHelper().getRowWithMasterACCID_Site_CountryId_CurrencyId_FromLHV_EE_MASTERSITE_FromTestDB(Site.DIPOCKET.toString(), 1);
        assertEquals(actualrow, Arrays.asList("1", "DIPOCKET", "440", "978", null));
    }
    @Test(priority = 2)
    public void test_verifySiteDipocketRowWithMasterACCIDSiteCountryIdCurrencyIdFromLHV_EE_MASTERSITE_2() throws SQLException, ClassNotFoundException {
        actualrow = app.getDbHelper().getRowWithMasterACCID_Site_CountryId_CurrencyId_FromLHV_EE_MASTERSITE_FromTestDB(Site.DIPOCKET.toString(), 2);
        assertEquals(actualrow, Arrays.asList("2", "DIPOCKET", "440", "826", null));
    }

    @Test(priority = 3)
    public void test_verifySiteDipocketRowWithMasterACCIDSiteCountryIdCurrencyIdFromLHV_EE_MASTERSITE_3() throws SQLException, ClassNotFoundException {
        actualrow = app.getDbHelper().getRowWithMasterACCID_Site_CountryId_CurrencyId_FromLHV_EE_MASTERSITE_FromTestDB(Site.DIPOCKET.toString(), 3);
        assertEquals(actualrow, Arrays.asList("3", "DIPOCKET", "826", "978", null));
    }

    @Test(priority = 4)
    public void test_verifySiteDipocketRowWithMasterACCIDSiteCountryIdCurrencyIdFromLHV_EE_MASTERSITE_4() throws SQLException, ClassNotFoundException {
        actualrow = app.getDbHelper().getRowWithMasterACCID_Site_CountryId_CurrencyId_FromLHV_EE_MASTERSITE_FromTestDB(Site.DIPOCKET.toString(), 4);
        assertEquals(actualrow, Arrays.asList("4", "DIPOCKET", "826", "826", null));
    }
}