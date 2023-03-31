package requests.clientServices;

import appmanager.DBHelper;
import appmanager.HelperBase;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ClientServicesRequests {
    DBHelper dbHelper = new DBHelper();
    Gson gson = new Gson();

    public RequestSpecification requestSpecClientServices = given()
            .log().uri().log().headers().log().body()
            .basePath("/ClientServices")
            .contentType("application/json");

    public RequestSpecification requestSpecDipocketHomePage = given()
            .log().uri().log().headers().log().body()
            .header("site", "DIPOCKET")
            .header("deviceuuid", "380980316499-AutoTest-Login");

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

    public String clientServices_v1_clientProfile_paymentDetails(String authLogin, String authPass, String cliSessionId) {
        String response = given()
                .spec(requestSpecClientServices)
                .baseUri(HelperBase.prop.getProperty("bo.test.base.url"))
                .header("clisessionid", ""+cliSessionId+"")
                .auth().basic(authLogin, authPass)
                .get("/v1/clientProfile/paymentDetails")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }
}