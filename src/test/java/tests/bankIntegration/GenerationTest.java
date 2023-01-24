package tests.bankIntegration;

import appmanager.HelperBase;
import appmanager.Login_RegistrationHelper;
import base.TestBase;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class GenerationTest extends TestBase {
    Login_RegistrationHelper login_registrationHelper = new Login_RegistrationHelper();


    @Test
    public void testGeneration() throws SQLException, InterruptedException, ClassNotFoundException {
        login_registrationHelper.dipocketRegistration(440, 978, "TERMS_AND_CONDITIONS_PL", "ELECTRONIC_COMMUNICATION", app.generateRandomString(8), "715611173985", HelperBase.prop.getProperty("mobile.registration.phoneNumber"), HelperBase.prop.getProperty("mobile.registration.email"), "test");
    }
}