package requests.customerServices;

import appmanager.DBHelper;
import appmanager.HelperBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.sql.SQLException;

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

    public Response customerServices_v1_card_activate_test_(String authLogin, String authPass, String json){
        Response response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .when()
                .body(json)
                .post( "/v1/card/activate");

                response.then().log().all().statusCode(200);
                return response;
    }

    public Response customerServices_v1_card_load_test(String authLogin, String authPass, String json){
        Response response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .when()
                .body(json)
                .post( "/v1/card/load");
        response.then().log().all().statusCode(200);
        return response;
    }

    public Response customerServices_v1_card_unload_test(String authLogin, String authPass, String json){
        Response response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .when()
                .body(json)
                .post( "/v1/card/unload");
        response.then().log().all().statusCode(200);
        return response;
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

    public String customerServices_v1_company_register_test(String authLogin, String authPass, String json)  {
        String response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .body(json)
                .post("/v1/company/register")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public String customerServices_v1_account_calculateBankTransfer_gbpInBritain(String authLogin, String authPass, String json){
        String response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .body(json)
                .post("/v1/account/calculateBankTransfer/gbpInBritain")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public String customerServices_v1_account_calculateBankTransfer_plnInPoland(String authLogin, String authPass, String json){
        String response = given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .body(json)
                .post("/v1/account/calculateBankTransfer/plnInPoland")
                .then().log().all()
                .statusCode(200).extract().response().asString();
        return response;
    }

    public void customerServices_v1_account_bankTransfer_plnInPoland(String authLogin, String authPass, String json){
        given()
                .spec(requestSpecCustomerServices)
                .baseUri(HelperBase.prop.getProperty("test.base.url"))
                .auth().basic(authLogin, authPass)
                .body(json)
                .post("/v1/account/bankTransfer/plnInPoland")
                .then().log().all()
                .statusCode(200);
    }
}