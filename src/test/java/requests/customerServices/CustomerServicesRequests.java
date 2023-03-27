package requests.customerServices;

import appmanager.DBHelper;
import appmanager.HelperBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class CustomerServicesRequests {

    DBHelper dbHelper = new DBHelper();

    public RequestSpecification requestSpecCustomerServices = given()
            .log().uri().log().headers().log().body()
            .basePath("CustomerServices")
            .contentType("application/json");

//    public RequestSpecification requestSpecCustomerServicesTest = given()
//            .log().uri().log().headers().log().body()
//            .basePath("CustomerServices")
//            .contentType("application/json");

    public String customerServices_v1_client_register_test(String authLogin, String authPass, String json){
        String response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .when()
                .body(json)
                .post( "/v1/client/register")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public String customerServices_v1_card_create_test(String authLogin, String authPass, String json){
        String response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .when()
                .body(json)
                .post( "/v1/card/create")
                .then().log().all().statusCode(200).extract().response().asString();
        return response;
    }

    public void customerServices_v1_card_activate_test(String authLogin, String authPass, String json){
        given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .when()
                .body(json)
                .post( "/v1/card/activate")
                .then().log().all().statusCode(200);
    }

    public String customerServices_v1_account_calculateBankTransfer_SEPA_test(String authLogin, String authPass, String json){
        String response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .body(json)
                .post("/v1/account/calculateBankTransfer/SEPA")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public String customerServices_v1_account_calculateBankTransfer_SWIFT_test(String authLogin, String authPass, String json){
        String response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .body(json)
                .post("/v1/account/calculateBankTransfer/SWIFT")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public void customerServices_v1_account_bankTransfer_SEPA_test(String authLogin, String authPass, String json){
        given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .body(json)
                .post("/v1/account/bankTransfer/SEPA")
                .then().log().all()
                .statusCode(200);
    }

    public void customerServices_v1_account_bankTransfer_SWIFT_test(String authLogin, String authPass, String json){
        given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .body(json)
                .post("/v1/account/bankTransfer/SWIFT")
                .then().log().all()
                .statusCode(200);
    }
}