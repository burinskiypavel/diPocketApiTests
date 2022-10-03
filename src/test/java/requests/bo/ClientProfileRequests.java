package requests.bo;

import appmanager.HelperBase;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ClientProfileRequests {
    public RequestSpecification requestSpecDipocketHomePage = given()
                .log().uri().log().headers().log().body()
                .header("site", "DIPOCKET")
                .header("deviceuuid", "380980316499-AutoTest-Login");


    public void clientServices_v1_clientProfile_changeCardholderName(String cliSessionId, String phone, String pass, String newCardHolderName){
        given()
                .spec(requestSpecDipocketHomePage)
                .auth().preemptive().basic(phone, pass)
                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
                .header("clisessionid", ""+cliSessionId+"")
                .header("content-type", "application/json")
                .body("{\n" +
                        "  \"value\" : \""+newCardHolderName+"\"\n" +
                        "}")
                .when()
                .post("clientProfile/changeCardholderName")
                .then().log().all()
                .statusCode(200);
    }
}
