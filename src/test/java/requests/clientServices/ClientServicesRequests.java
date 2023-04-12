package requests.clientServices;

import appmanager.DBHelper;
import appmanager.HelperBase;
import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.pojo.client.CheckboxContainer;
import com.cs.dipocketback.pojo.registration.AttachedCard;
import com.cs.dipocketback.pojo.registration.RegSavepointData;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.cs.dipocketback.pojo.client.CheckboxType.ELECTRONIC_COMMUNICATION;
import static com.cs.dipocketback.pojo.client.CheckboxType.TERMS_AND_CONDITIONS_PL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.testng.Assert.assertEquals;

public class ClientServicesRequests {
    DBHelper dbHelper = new DBHelper();
    Gson gson = new Gson();

    public RequestSpecification requestSpecClientServices = given()
            .log().uri().log().headers().log().body()
            //.basePath("/ClientServices")
            //.baseUri(HelperBase.prop.getProperty("mobile.test.base.url"))
            .contentType("application/json");

    public RequestSpecification requestSpecDipocketHomePage = given()
            .log().uri().log().headers().log().body()
            .header("site", Site.DIPOCKET.toString())
            .header("deviceuuid", "380980316499-AutoTest-Login");

    public Response  clientServices_v1_homePage_AutintificateMobileApp(String phone, String pass, String json, int expectedStatusCode) {
        Response res = given()
                .spec(requestSpecDipocketHomePage)
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .auth().preemptive().basic(phone, pass)
                .contentType("application/json")
                .body(json)
                .when()
                .post( "homePage/authenticateMobileApp");
        res.then().log().all()
                .statusCode(expectedStatusCode);
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                //.body("errCode", equalTo("DIP-00591"));
        return res;
    }

    public Response clientServices_v1_tile_getMessages2(String cliSessionId, String phone, String pass){
        Response response =  given()
                .spec(requestSpecDipocketHomePage)
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .auth().preemptive().basic(phone, pass)
                .header("clisessionid", ""+cliSessionId+"")
                .when()
                .get("tile/getMessages2");
        response.then().log().all().statusCode(200);
        return response;
    }

    public String clientServices_v1_clientProfile_paymentDetails_test(String authLogin, String authPass, String cliSessionId) {
        String response = given()
                .spec(requestSpecClientServices)
                .baseUri(HelperBase.prop.getProperty("mobile.test.base.url"))
                .header("clisessionid", cliSessionId)
                .auth().basic(authLogin, authPass)
                .get("clientProfile/paymentDetails")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public Response сlientServices_v1_references_availableCountries(String urlEnv, int langId) {
        Response response = given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .queryParam("langID", langId)
                .when()
                .get( "references/availableCountries");
        response.then().log().all();
        response.then().statusCode(200);
                return response;
    }

    public Response clientServices_v1_references_languages(String urlEnv, String site){
        Response response = given()
                .spec(requestSpecClientServices)
                .header("site", site)
                .baseUri(urlEnv)
                .when()
                .get("references/languages");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public Response clientServices_v1_references_appConfig(String urlEnv, String platform, String version, String langCode){
        Response response = given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .queryParam("platform", platform)
                .queryParam("version", version)
                .queryParam("langCode", langCode)
                .when()
                .get("references/appConfig");
        response.then().log().all()
                .statusCode(200);
                return response;
    }

    public Response сlientServices_v1_userRegistration_loadSavePointData2(String urlEnv, String devUUID) {
        Response response = given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .queryParam("devUUID", devUUID)
                .when()
                .get("userRegistration/loadSavePointData2");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public void clientServices_v1_userRegistration_sendSMSCodeForPhone(String urlEnv, int langId, String phoneNumber, String json){
        given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .header("site", HelperBase.prop.getProperty("mobile.site"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"))
                .queryParam("langID", langId)
                .queryParam("phoneNum", phoneNumber)
                .body(json)
                .when()
                .post("userRegistration/sendSMSCodeForPhone")
                .then().log().all()
                .statusCode(200);
    }

    public Response сlientServices_v1_references_verifyPhone(String urlEnv, String phoneNumber)  {
        Response response = given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .queryParam("phone", phoneNumber)
                .when()
                .get("references/verifyPhone");
        response.then().log().all()
                .statusCode(200);
                return response;
    }

    public Response сlientServices_v1_references_topCountries(String urlEnv, int langId) {
        Response res = given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .queryParam("langID", langId)
                .when()
                .get("references/topCountries");
        res.then().log().all();
        int statusCode = res.getStatusCode();
        assertEquals(statusCode, 200);
        return res;
    }

    public void clientServices_v1_userRegistration_registrationSavePoint2(String urlEnv, String json) {
        given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .body(json)
                .when()
                .put("userRegistration/registrationSavePoint2")
                .then().log().all()
                .statusCode(200);
    }

    public Response clientServices_v1_userRegistration_checkPhoneAndLoadSavePoint(String urlEnv, int langId, String phoneNumber, String smsCode) {
        Response response = given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .queryParam("langID", langId)
                .queryParam("phoneNum", phoneNumber)
                .queryParam("code", smsCode)
                .when()
                .get("userRegistration/checkPhoneAndLoadSavePoint");
        response.then().log().all()
                .statusCode(200);
        return response;
    }

    public void clientServices_v1_userRegistration_clientImage(String urlEnv, String json) {
        given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .body(json)
                .when()
                .put("userRegistration/clientImage")
                .then().log().all()
                .statusCode(200);
    }

    public Response clientServices_v1_references_questions(String urlEnv, int langId, int countryId) {
        Response response = given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .queryParam("langID", langId)
                .queryParam("countryId", countryId)
                .when()
                .get("references/questions");
        response.then().log().all()
                .statusCode(200);
                return response;
    }

    public void clientServices_v1_userRegistration_sendTermsAndConditions(String urlEnv, String deviceUUID) {
        given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .queryParam("deviceUUID", deviceUUID)
                .when()
                .put("userRegistration/sendTermsAndConditions")
                .then().log().all()
                .statusCode(200);
    }

    public Response clientServices_v1_userRegistration_registerNewClient2(String urlEnv, String json){
        Response response =given()
                .spec(requestSpecClientServices)
                .baseUri(urlEnv)
                .body(json)
                .when()
                .post("userRegistration/registerNewClient2");
        response.then().log().all()
                .statusCode(200);
        return response;
    }
}