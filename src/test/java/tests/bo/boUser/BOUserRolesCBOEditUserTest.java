package tests.bo.boUser;

import base.TestBase;
import com.cs.dipocketback.base.data.Site;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class BOUserRolesCBOEditUserTest extends TestBase {
    String cookie = null;
    String phone = "380685448614";
    String username = "PAVELB";
    String email = "burinskiypavel@gmail.com";
    String randomFirsName = "Pavel" + app.generateRandomNumber(4);;

    @Test(priority = 1)
    public void test_BOServices_v1_auth_authentication() {
        cookie = app.getBoRequestsHelper().boServices_v1_auth_authentication(app.CBOuserLogin, app.CBOuserPass, app.CBOusername);
    }

    @Test(priority = 2)
    public void test_BOServices_v1_user_roles(){
        app.getBoRequestsHelper().boServices_v1_user_roles(cookie);
    }

    @Test(priority = 3)
    public void test_BOServices_v1_user_all(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/all")
                .then().log().all()
                .statusCode(200)
                .body("username", hasItem("S.TEUMA"),
                        "phone", hasItem("35699806131"),
                        "email", hasItem("teumas@centralbankmalta.org"));
    }

    @Test(priority = 4)
    public void test_BOServices_v1_user_PAVELB(){
        given()
                .spec(app.requestSpecBO)
                .cookie(cookie)
                .when()
                .get( "/v1/user/PAVELB")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo(username),
                        "phone", equalTo(phone),
                        "email", equalTo(email));
    }

    @Test(priority = 5)
    public void test_BOServices_v1_user_verifyPhone(){
        app.getBoRequestsHelper().boServices_v1_user_verifyPhone(cookie, phone, true);
    }

    @Test(priority = 6)
    public void test_BOServices_v1_user_corpClients_site_SODEXO(){
        app.getBoRequestsHelper().boServices_v1_user_corpClients_site_SODEXO(cookie, "Sodexo New LE", Site.SODEXO.toString());
    }

    @Test(priority = 7)
    public void test_BOServices_v1_user_update(){
        given()
                .cookie(cookie)
                .spec(app.requestSpecBO)
                .body("{\n" +
                        "  \"username\" : \""+username+"\",\n" +
                        "  \"firstName\" : \""+randomFirsName+"\",\n" +
                        "  \"lastName\" : \"Burinskiy\",\n" +
                        "  \"base64Photo\" : \"/9j/4AAQSkZJRgABAQEAeAB4AAD/2wBDAAIBAQIBAQICAgICAgICAwUDAwMDAwYEBAMFBwYHBwcGBwcICQsJCAgKCAcHCg0KCgsMDAwMBwkODw0MDgsMDAz/2wBDAQICAgMDAwYDAwYMCAcIDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAz/wAARCAHxAfQDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD5rooor8DP9oAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigBelJRRQAUUUUAFFFFABRRRQAUUUUAFFFFABW/o3xV8UeHNOS00/wASa9Y2kWdkFvqEsUaZ5OFVgBWBRTTa1RlVo06q5asU15q51P8AwvHxr/0N/ij/AMGs/wD8VR/wvHxr/wBDf4o/8Gs//wAVXLUVftJ92c/9nYT/AJ9R/wDAV/kdFqXxd8Wa1YS2t54n8Q3drOpSWGbUppI5FPUMpbBH1rnaKKlyb3N6VClSVqUVFeSsFFFFSbBRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRS9KACkoooAKKKXNACUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAC0UlFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFWbvWby/sbW1nurma2sVZbaGSVmS3DMWYIpOFBYknHUkmq1P0Jje3vBRRRSKCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigApaSigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiloASiiigAooooAKKKKACiiigAooooAKKKKACiiigAoopaAEooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKWkooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAopaSgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACijrRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAC0lFFABRS5xRQAlFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFLQAlFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFLSUUAGaKKKACiiloASiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAM0UUUAFFFFABRRRQAUUUUAFFFFABRRS5oASiiigAooozQAUUUUAFFFFABRRRQAUUUUAFFFFABRRS0AJRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFAC0lFFAC0lFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFGaKKACiiigAooooAKXFJRQAtJRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABmiiigBaKSigAooooAKKKKACiiigAooooAKKKXNABSUUUAFFFFABRR1ooAKKKKACiiigAooooAKKKKACilzSUAFFFFABRS0lAB0ooooAKKKKACiiigAooooAKKKWgBKKKKAFpKKKACiiigAooooAKKKKACiiigAooooAKWkooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKWkoAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAClzSUUAFFWP7QYWBtxHAqMyuzeUDIzLvx85yyjDnIUgHCkglQar0xK/UKKKKQwooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKWgBKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAopaKAEopaSgAooooAKKKKACiiigAopaSgAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAopaSgAooooAKKKKADrRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRUtvZTXcUzxQyyJbIJZmRCREhZUDMew3Moye7Ad6ipiunsFFFFIYUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFGaKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAClpKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKWgBKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACpbG4W0vYZXgiuUjdXaGUsElAOSrFSGwehwQeeCKiopiaurEt9cLd3s0scEVqkjs6wxFikIJyFUsWbA6DcSeOSetRUUUAlZWCiiikMKKKKACiiigAooooAKKKKACiijNABRRRQAUUUUAFFFFABRS0lABS4pKKACiiigAooooAKKKKACiiigAooooAKlgtWuIpmBjAgTewaRVJG4L8oJyxyw4GTjJxgEiPNJQJ36BRRRQMKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKM0UUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRS9KAEooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACilpKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigApTSUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRS0AJRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFGaACiiigAooooAKKKKACiiigApc0lFABRRRQAZooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACilpKACiiigAooozQAUUUUAFFFFABRRRQAUUUUAFFFFABRS4pKACiiigAoozRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFLSUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFLSUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAZooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAXNJRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRmiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooA9J/ar/AOSnaX/2J/hf/wBMGn15tRRXRi/48/V/meLw3/yKML/17h/6SgooornPaCiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP/Z\",\n" +
                        "  \"roleId\" : \"CBO\",\n" +
                        "  \"phone\" : \""+phone+"\",\n" +
                        "  \"email\" : \""+email+"\",\n" +
                        "  \"site\" : \"SODEXO\",\n" +
                        "  \"corpClientIdList\" : [ ]\n" +
                        "}")
                .when()
                .post( "/v1/user/update")
                .then().log().all()
                .statusCode(200);
    }

    @Test(priority = 8)
    public void test_BOServices_v1_user_all_() {
        app.getBoRequestsHelper().boServices_v1_user_all(cookie, username, randomFirsName, phone, email);
    }
}