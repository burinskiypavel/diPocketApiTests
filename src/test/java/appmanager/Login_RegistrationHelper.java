package appmanager;

import com.cs.dipocketback.base.data.Site;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.sql.SQLException;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class Login_RegistrationHelper extends HelperBase {
    DBHelper dbHelper = new DBHelper();

    public String loginDipocket(String phone, String pass, final String deviceUUID) throws ClassNotFoundException, SQLException {
        String cliSessionId = null;
        String site = "DIPOCKET";
        baseURI = HelperBase.prop.getProperty("mobile.base.url");

        dbHelper.deleteClientDeviceFromDB(deviceUUID);

        given()
                .auth().preemptive().basic(phone, pass)
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"" + deviceUUID + "\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post("homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));

        String loginSMSCode = dbHelper.getLoginSMSFromDB(phone, deviceUUID, site);

        Response res =  given()
                .auth().preemptive().basic(phone, pass)
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+deviceUUID+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        assertEquals(StatusCode, 200);
        return cliSessionId;
    }

    public String loginPlayIT(String phone, String pass, final String deviceUUID) throws ClassNotFoundException, SQLException {
        String cliSessionId = null;
        String site = "PLAYIT";
        baseURI = HelperBase.prop.getProperty("mobile.base.url");
        dbHelper.deleteClientDeviceFromDB(deviceUUID);

        given().log().all()
                .auth().preemptive().basic("9_" + phone, pass)
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"" + deviceUUID + "\",\n" +
                        "  \"appVersion\" : \"1.4.9\"\n" +
                        "}")
                .when()
                .post("homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                .body("errCode", equalTo("DIP-00591"));

        String loginSMSCode = dbHelper.getLoginSMSFromDB(phone, deviceUUID, "PLAYIT");
        Response res = given().log().all()
                .auth().preemptive().basic("9_" + phone, pass)
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"" + deviceUUID + "\",\n" +
                        "  \"appVersion\" : \"1.4.9\",\n" +
                        "  \"otp\" : \"" + loginSMSCode + "\"\n" +
                        "}")
                .when()
                .post("homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);
        int StatusCode = res.getStatusCode();
        assertEquals(StatusCode, 200);
        return cliSessionId;
    }

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

    public String loginSnowAttack(String phone, String pass) {
        Response res = given().log().uri().log().headers().log().body()
                .baseUri("https://http.dipocket.dev")
                .header("site", Site.SNOW_ATTACK.toString())
                .contentType("application/json; charset=utf-8")
                .auth().preemptive().basic("11_" + phone, pass)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("/WebServices/v1/homePage/authenticateWithSca");

        res.then().log().all();

        String cliSessionId = res.getHeader("cliSessionId");

        if(res.getStatusCode() != 200) {

            String responseBody = res.getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errCode = jsonPath.getString("errCode");

            if (errCode.equals("DIP-00602")) {

                given().log().uri().log().headers().log().body()
                        .baseUri("https://http.dipocket.dev")
                        .header("site", Site.SNOW_ATTACK.toString())
                        .contentType("application/json; charset=utf-8")
                        .auth().preemptive().basic("11_" + phone, pass)
                        .body("{\n" +
                                "  \"mainPhone\" : \"" + phone + "\"\n" +
                                "}")
                        .when()
                        .post("/WebServices/v1/security/sendSca")
                        .then().log().all()
                        .statusCode(200);
            }
        }

        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);

        assertEquals(res.getStatusCode(), 200);
        return cliSessionId;
    }
}
