package requests.customerServices;

import appmanager.DBHelper;
import appmanager.HelperBase;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CustomerServicesRequests {

    DBHelper dbHelper = new DBHelper();

    public RequestSpecification requestSpecCustomerServices = given()
            .log().uri().log().headers().log().body()
            .basePath("CustomerServices")
            //.header("bo-auth-token", "123456")
            .contentType("application/json");

//    public RequestSpecification requestSpecCustomerServicesTest = given()
//            .log().uri().log().headers().log().body()
//            .basePath("CustomerServices")
//            .contentType("application/json");

    public Response customerServicesRequests_v1_client_register_(String authLogin, String authPass){
        Response res = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .when()
                //.body()
                .post( "/CustomerServices/v1/client/register");

        res.then().log().all().statusCode(200);
        return res;
    }
}
