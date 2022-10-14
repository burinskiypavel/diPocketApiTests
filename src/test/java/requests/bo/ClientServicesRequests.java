package requests.bo;

import appmanager.HelperBase;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class ClientServicesRequests {
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
}