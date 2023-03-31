package requests.clientServices;

import appmanager.DBHelper;
import appmanager.HelperBase;
import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

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
}