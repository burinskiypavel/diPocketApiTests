package requests.clientServices;

import appmanager.DBHelper;
import appmanager.HelperBase;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ClientServicesRequests {
    DBHelper dbHelper = new DBHelper();
    Gson gson = new Gson();

    public RequestSpecification requestSpecClientServices = given()
            .log().uri().log().headers().log().body()
            .basePath("/ClientServices")
            .contentType("application/json");

//    public RequestSpecification requestSpecClientServicesTest = given()
//            .log().uri().log().headers().log().body()
//            .basePath("/ClientServices")
//            .contentType("application/json");

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