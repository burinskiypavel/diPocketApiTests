package tests.bo.boClient;

import appmanager.HelperBase;
import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class RolesBOUserClientPageUploadDocsButtonTests extends TestBase {
    String cookie = null;
    String clientId = null;
    int typeId = 2;

    @Test(priority = 1)
    public void test_BOServices_v1_user_authentication() throws SQLException, ClassNotFoundException {
        clientId = app.getDbHelper().getClientIdFromDB(HelperBase.prop.getProperty("mobile.registration.email"), Site.DIPOCKET.toString());
        baseURI = app.BOURL;
        basePath = "BOServices";
        Response response = given()
                .log().uri().log().headers()
                .auth().preemptive().basic(app.BOuserLogin, app.BOuserPass)
                .contentType("application/json")
                .when()
                .post( "/v1/user/authentication");
        cookie = response.getHeader("Set-Cookie");
        response.then().log().all()
                .statusCode(200)
                .body("username", equalTo("EVGENYA"));
    }

    @Test(priority = 2)
    public void test_BOServices_v1_client_search(){
        app.getBoRequestsHelper().boServices_v1_client_search(cookie, Integer.parseInt(clientId), "Pavel", "Burinsky", "380685448615", "testdipocket@gmail.com", Site.DIPOCKET.toString());
    }

    @Test(priority = 3)
    public void test_BOServices_v1_clientImage_docTypes(){
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get( "/v1/clientImage/docTypes")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
                        "sName", hasItems("Selfie", "PhotoID", "Proof of address", "Smiling Selfie", "PhotoID Back", "Second ID", "Proof of relationship", "Avatar (Large)", "Avatar (Medium)", "Avatar (Small)", "Residence Permit/Visa Type D"));
    }


    @Test(priority = 4)
    public void test_BOServices_v1_clientImage_clientId_docs() {
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get("/v1/clientImage/" + clientId + "/docs")
                .then().log().all()
                .statusCode(200);
        //.body();
    }

    @Test(priority = 6)
    public void test_BOServices_v1_clientImage_uploadDoc(){
        given()
                .log().uri().log().headers().log().body()
                .cookie(cookie)
                .contentType("application/json")
                .body("{\n" +
                        "  \"clientId\" : "+clientId+",\n" +
                        "  \"base64data\" : \"/9j/4AAQSkZJRgABAQEAeAB4AAD/2wBDAAIBAQIBAQICAgICAgICAwUDAwMDAwYEBAMFBwYHBwcGBwcICQsJCAgKCAcHCg0KCgsMDAwMBwkODw0MDgsMDAz/2wBDAQICAgMDAwYDAwYMCAcIDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAz/wAARCAHxAfQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD5rooor8DP9oAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigBelJRRQAUUUUAFFFFABRRRQAUUUUAFFFFABW/o3xV8UeHNOS00/wASa9Y2kWdkFvqEsUaZ5OFVgBWBRTTa1RlVo06q5asU15q51P8AwvHxr/0N/ij/AMGs/wD8VR/wvHxr/wBDf4o/8Gs//wAVXLUVftJ92c/9nYT/AJ9R/wDAV/kdFqXxd8Wa1YS2t54n8Q3drOpSWGbUppI5FPUMpbBH1rnaKKlyb3N6VClSVqUVFeSsFFFFSbBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRS9KACkoooAKKKXNACUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAC0UlFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFWbvWby/sbW1nurma2sVZbaGSVmS3DMWYIpOFBYknHUkmq1P0Jje3vBRRRSKCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigApaSigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiloASiiigAooooAKKKKACiiigAooooAKKKKACiiigAoopaAEooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKWkooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAopaSgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACijrRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAC0lFFABRS5xRQAlFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFLQAlFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFLSUUAGaKKKACiiloASiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAM0UUUAFFFFABRRRQAUUUUAFFFFABRRS5oASiiigAooozQAUUUUAFFFFABRRRQAUUUUAFFFFABRRS0AJRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAC0lFFAC0lFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFGaKKACiiigAooooAKXFJRQAtJRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABmiiigBaKSigAooooAKKKKACiiigAooooAKKKXNABSUUUAFFFFABRR1ooAKKKKACiiigAooooAKKKKACilzSUAFFFFABRS0lAB0ooooAKKKKACiiigAooooAKKKWgBKKKKAFpKKKACiiigAooooAKKKKACiiigAooooAKWkooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKWkoAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAClzSUUAFFWP7QYWBtxHAqMyuzeUDIzLvx85yyjDnIUgHCkglQar0xK/UKKKKQwooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKWgBKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAopaKAEopaSgAooooAKKKKACiiigAopaSgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAopaSgAooooAKKKKADrRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRUtvZTXcUzxQyyJbIJZmRCREhZUDMew3Moye7Ad6ipiunsFFFFIYUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFGaKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAClpKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKWgBKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACpbG4W0vYZXgiuUjdXaGUsElAOSrFSGwehwQeeCKiopiaurEt9cLd3s0scEVqkjs6wxFikIJyFUsWbA6DcSeOSetRUUUAlZWCiiikMKKKKACiiigAooooAKKKKACiijNABRRRQAUUUUAFFFFABRS0lABS4pKKACiiigAooooAKKKKACiiigAooooAKlgtWuIpmBjAgTewaRVJG4L8oJyxyw4GTjJxgEiPNJQJ36BRRRQMKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKM0UUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRS9KAEooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACilpKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigApTSUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRS0AJRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFGaACiiigAooooAKKKKACiiigApc0lFABRRRQAZooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACilpKACiiigAooozQAUUUUAFFFFABRRRQAUUUUAFFFFABRS4pKACiiigAoozRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFLSUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFLSUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAZooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAXNJRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRmiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA9J/ar/AOSnaX/2J/hf/wBMGn15tRRXRi/48/V/meLw3/yKML/17h/6SgooornPaCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP/Z\",\n" +
                        "  \"typeId\" : "+typeId+"\n" +
                        "}")
                .when()
                .post( "/v1/clientImage/uploadDoc")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 7)
    public void test_BOServices_v1_clientImage_clientId_docs_() {
        given()
                .log().uri().log().headers()
                .cookie(cookie)
                .contentType("application/json")
                .when()
                .get("/v1/clientImage/" + clientId + "/docs")
                .then().log().all()
                .statusCode(200);
        //.body();
    }
}
