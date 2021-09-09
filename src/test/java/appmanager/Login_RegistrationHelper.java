package appmanager;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class Login_RegistrationHelper extends HelperBase {
    DBHelper dbHelper = new DBHelper();

    public String loginUpAndGo (String phone, String pass, String mobileLoginDeviceUUID) throws SQLException, ClassNotFoundException {
        String cliSessionId = null;
        String site = "UPANDGO";

        dbHelper.deleteClientDeviceFromDB(mobileLoginDeviceUUID);
        given().log().all()
                .auth().preemptive().basic("10_" + phone, pass)
                .header("deviceuuid", mobileLoginDeviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ mobileLoginDeviceUUID+"\",\n" +
                        "  \"appVersion\" : \"1.1.11\"\n" +
                        "}")
                .when()
                .post( HelperBase.prop.getProperty("mobile.base.url")+"homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));


        String loginSMSCode = dbHelper.getLoginSMSFromDB(phone, mobileLoginDeviceUUID, site);
        Response res =  given().log().all()
                .auth().preemptive().basic("10_" + phone, pass)
                .header("deviceuuid", mobileLoginDeviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ mobileLoginDeviceUUID+"\",\n" +
                        "  \"appVersion\" : \"1.1.11\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( HelperBase.prop.getProperty("mobile.base.url")+"homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        //dbHelper.storeDataToTheFile("files\\tds\\cliSessionId.txt",cliSessionId);
        int StatusCode = res.getStatusCode();
        assertEquals(StatusCode, 200);
        return cliSessionId;
    }
}
