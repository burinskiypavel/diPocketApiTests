package requests.bo;

import appmanager.HelperBase;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.bo.boClient.Supervisor_reqList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.testng.Assert.assertFalse;

public class BORequests {

    public RequestSpecification requestSpecBO = given()
            .log().uri().log().headers().log().body()
            .basePath("BOServices")
            .header("bo-auth-token", "123456")
            .contentType("application/json");


    public String boServices_v1_auth_authentication(String login, String pass, String expectedUsername) {
        String cookie = null;

        Response responseCode = given()
                .log().uri().log().headers()
                .auth().preemptive().basic(login, pass)
                .contentType("application/json")
                .queryParam("smsCounter", 1)
                .when()
                .post( "/v1/auth/genSecureCodeWithCounter");
        cookie = responseCode.getHeader("Set-Cookie");
        responseCode.then().log().all()
                .statusCode(200);

        Response response = given()
                .log().uri().log().headers()
                .auth().preemptive().basic(login, pass)
                .cookie(cookie)
                .header("bo-auth-token", "123456")
                .contentType("application/json")
                .when()
                .post( "/v1/auth/authentication");
        //cookie = response.getHeader("Set-Cookie");
        response.then().log().all()
                .statusCode(200)
                .body("firstName", notNullValue(),
                        "lastName", notNullValue(),
                        "roleId", notNullValue(),
                        "stateId", notNullValue(),
                        "stateName", notNullValue(),
                        "username", notNullValue(),
                        "phone", notNullValue(),
                        //"corpClientId", notNullValue(),
                        "email", notNullValue(),
                        "site", notNullValue(),
                        "username", equalTo(expectedUsername));
        return cookie;
    }

    public void boServices_v1_ticket_states(String cookie) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get("/v1/ticket/states")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(10, 50, 100, -10),
                        "name", hasItems("Open", "In progress", "Closed", "Rejected"));
    }

    public void boServices_v1_ticket_types(String cookie) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get("/v1/ticket/types")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(402, 700, 100, 200, 300, 310, 320),
                        "name", hasItems("PhotoID change", "Client restriction", "SDD check", "FDD check", "PIN incorrect (3)", "PIN change", "Secret answer incorrect (2)"));
    }

    public void boServices_v1_tran_states(String cookie) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get("/v1/tran/states")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(-100, -60, -50, -10, 0, 10, 30),
                        "name", hasItems("Error", "Reversed", "Reversing", "Cancelled", "Processing", "Hidden", "Pending"));
    }


    public void boServices_v1_account_other_client_33217(String cookie, int clientId){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/account/other/client/"+clientId+"")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(104447),
                            "clientId", hasItem(clientId),
                            "cardName", hasItem("Test"),
                            "created", hasItem("2022-01-12"),
                            "maskedPan", hasItem("555585******9888"),
                            "accountStateName", hasItem("Closed"));
    }

    public Response boServices_v1_account_other_client_(String cookie, int clientId){
        Response res = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/account/other/client/"+clientId+"");

                res.then().log().all().statusCode(200);
                return res;
    }

    public void boServices_v1_account_client_33217(String cookie, int clientId) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/account/client/"+clientId+"")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(102690),
                        "accountName", hasItem("Bbh"),
                        "clientId", hasItem(clientId),
                        "ccyId", hasItem(826),
                        "ccyCode", hasItem("GBP"),
                        "restAmount", hasItem(0),
                        "stateId", hasItem(-100),
                        "stateName", hasItem("Closed"),
                        "typeId", hasItem(1),
                        "created", hasItem("2021-10-12"),
                        "accStateNameExt", hasItem("Closed"),
                        "clientIdOwner", hasItem(33217),
                        "owner", hasItem(true),
                        "shared", hasItem(false));
    }

    public Response boServices_v1_account_client_(String cookie, int clientId) {
        Response res = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/account/client/"+clientId+"");

                res.then().log().all().statusCode(200);
                return res;
//                .body("id", hasItem(102690),
//                        "accountName", hasItem("Bbh"),
//                        "clientId", hasItem(clientId),
//                        "ccyId", hasItem(826),
//                        "ccyCode", hasItem("GBP"),
//                        "restAmount", hasItem(0),
//                        "stateId", hasItem(-100),
//                        "stateName", hasItem("Closed"),
//                        "typeId", hasItem(1),
//                        "created", hasItem("2021-10-12"),
//                        "accStateNameExt", hasItem("Closed"),
//                        "clientIdOwner", hasItem(33217),
//                        "owner", hasItem(true),
//                        "shared", hasItem(false));
    }

    public void boServices_v1_client_33217_paymentDetails(String cookie, int clientId) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+clientId+"/paymentDetails")
                .then().log().all()
                .statusCode(200)
                .body("paymentType", hasItem(3),
                        "currencyId", hasItem(756),
                        "currencyCode", hasItem("CHF"),
                        "accountName", hasItem("Nona Qwerty"),
                        "bankId", hasItem("WBKPPLPP"),
                        "accountNo", (notNullValue()),
                        "address", hasItem("Address44 - 11111 City - Ukraine"),
                        "bankName", hasItem("Santander Bank Polska SA - al. Jana Pawla II 17 - 00-854 Warsaw Poland"));

        //        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.paymentType == 3}.paymentType", 3));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.currencyId == 985}.currencyId", 985));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.currencyCode == 'PLN'}.currencyCode", "PLN"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.accountName == 'Nona Qwerty'}.accountName", "Nona Qwerty"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.bankId == 'WBKPPLPP'}.bankId", "WBKPPLPP"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.accountNo == 'PL16109000047335800000085124'}.accountNo", "PL16109000047335800000085124"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.address == 'Address44 - 11111 City - Ukraine'}.address", "Address44 - 11111 City - Ukraine"));
//        assertTrue(app.getJsonHelper().isElementPresentInJson(res, "find {it.bankName == 'Santander Bank Polska SA - al. Jana Pawla II 17 - 00-854 Warsaw Poland'}.bankName", "Santander Bank Polska SA - al. Jana Pawla II 17 - 00-854 Warsaw Poland"));

    }

    public Response boServices_v1_client_paymentDetails(String cookie, int clientId) {
        Response res = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get("/v1/client/" + clientId + "/paymentDetails");

        res.then().log().all().statusCode(200);
        return res;
    }


        public void boServices_v1_client_availCurrencies(String cookie){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/client/availCurrencies")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(975, 756, 978),
                        "code", hasItems("BGN", "CHF", "EUR"),
                        "symbol", hasItems("Fr", "€"));
    }

    public void boServices_v1_client_33217_address(String cookie, int clientId){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"/address")
                .then().log().all()
                .statusCode(200)
                .body("clientId", hasItem(clientId),
                        "city", hasItem("City"),
                        "streetLine1", hasItem("Address"),
                        "zip", hasItem("11-11"),
                        "typeId", hasItem(0),
                        "countryId", hasItem(40),
                        "code", hasItem("AT"),
                        "countryName", hasItem("Austria"),
                        "restricted", hasItem(false));
    }

    public Response boServices_v1_client_address(String cookie, int clientId){
        Response res = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"/address");

                res.then().log().all().statusCode(200);
                return res;
    }

    public void boServices_v1_clientImage_33217_docHistory(String cookie, int clientId){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/clientImage/33217/docHistory")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(17467),
                        "clientId", hasItem(clientId),
                        "typeId", hasItem(7),
                        "imageInBase64", hasItem(notNullValue()),
                        "added", hasItem("2022-05-02"),
                        "stateId", hasItem(-10),
                        "stateName", hasItem("Rejected"));
    }

    public Response boServices_v1_clientImage_docHistory(String cookie, int clientId){
        Response res =given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/clientImage/"+clientId+"/docHistory");

                res.then().log().all().statusCode(200);
                return res;
    }

    public void boServices_v1_client_states(String cookie){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                //.header("bo-auth-token", "123456")
                .cookie(cookie)
                .when()
                .get( "/v1/client/states")
                .then().log().all().statusCode(200)
                .body("id", hasItems(-200, -150, -100, -1, 0, 1),
                        "name", hasItems("Archived", "Forgotten", "Banned", "Blocked", "Savepoint", "Active"));
    }

    public void boServices_v1_client_33217(String cookie, int clientId){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"")
                .then().log().all()
                .statusCode(200)
                .body("email", equalTo("vikarez20@gmail.com"),
                        "id", equalTo(clientId),
                        "mainPhone", equalTo("380634413376"),
                        "firstName", equalTo("Nona"),
                        "lastName", equalTo("Qwerty"),
                        "stateName", equalTo("Active"));
    }

    public Response boServices_v1_client_(String cookie, int clientId){
        Response response = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/client/"+ clientId +"");
        response.then().log().all().statusCode(200);
        return response;
    }

    public void boServices_v1_client_search(String cookie, String by, String value, String expectedFirstName, String expectedLastName, String expectedMainPhone, String expectedEmail, String expectedSite){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                //.header("bo-auth-token", "123456")
                .body("{\n" +
                        "  \"" + by + "\" : \""+value+"\"\n" +
                        "}")
                .when()
                .post( "/v1/client/search")
                .then().log().all()
                .statusCode(200)
                .body("firstName", hasItem(expectedFirstName),
                        "lastName", hasItem(expectedLastName),
                        "mainPhone", hasItem(expectedMainPhone),
                        "email", hasItem(expectedEmail),
                        "site", hasItem(expectedSite));
    }

    public void boServices_v1_client_search(String cookie, String by, String value, String expectedFirstName, String expectedLastName, String expectedMainPhone, String expectedEmail, String expectedSite, long expectedBirthDate){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                //.header("bo-auth-token", "123456")
                .body("{\n" +
                        "  \"" + by + "\" : \""+value+"\"\n" +
                        "}")
                .when()
                .post( "/v1/client/search")
                .then().log().all()
                .statusCode(200)
                .body("firstName", hasItem(expectedFirstName),
                        "lastName", hasItem(expectedLastName),
                        "mainPhone", hasItem(expectedMainPhone),
                        "email", hasItem(expectedEmail),
                        "site", hasItem(expectedSite),
                        "birthDate", hasItem(expectedBirthDate));
    }

    public void boServices_v1_client_search(String cookie, int clientId, String expectedFirstName, String expectedLastName, String expectedMainPhone, String expectedEmail, String expectedSite){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                //.header("bo-auth-token", "123456")
                .body("{\n" +
                        "  \"id\" : "+clientId+"\n" +
                        "}")
                .when()
                .post( "/v1/client/search")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItem(clientId),
                        "firstName", hasItem(expectedFirstName),
                        "lastName", hasItem(expectedLastName),
                        "mainPhone", hasItem(expectedMainPhone),
                        "email", hasItem(expectedEmail),
                        "site", hasItem(expectedSite));
    }

    public void boServices_v1_supervisor_33217_reqList(String cookie, int clientId){
        Response res = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/supervisor/"+clientId+"/reqList");
        res.then().log().all().statusCode(200);
        Supervisor_reqList[] supervisor_reqLists = res.as(Supervisor_reqList[].class);
        assertThat(supervisor_reqLists[0].getReqId(), equalTo(2676));
        assertThat(supervisor_reqLists[0].getClientId(), equalTo(clientId));
        assertThat(supervisor_reqLists[0].getRole(), equalTo("Child"));
        assertThat(supervisor_reqLists[0].getrClientPhone(), equalTo("380638918373"));
        assertThat(supervisor_reqLists[0].getrFullName(), equalTo("Vika Qwerty"));
        assertThat(supervisor_reqLists[0].getStateId(), equalTo(- 100));
        assertThat(supervisor_reqLists[0].getStateName(), equalTo("Finished"));
        assertFalse(supervisor_reqLists[0].getCreatedAt().isEmpty());
        assertFalse(supervisor_reqLists[0].getApprovedAt().isEmpty());
    }

    public Response boServices_v1_supervisor_reqList(String cookie, int clientId){
        Response res = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/supervisor/"+clientId+"/reqList");
        res.then().log().all().statusCode(200);
        return res;
    }

    public void boServices_v1_clientImage_docTypes(String cookie) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/clientImage/docTypes")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
                        "sName", hasItems("Selfie", "PhotoID", "Proof of address", "Smiling Selfie", "PhotoID Back", "Second ID", "Proof of relationship", "Avatar (Large)", "Avatar (Medium)", "Avatar (Small)", "Residence Permit/Visa Type D"));
    }

    public void boServices_v1_clientImage_uploadDoc(String cookie, int clientId, int typeId, String image) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .body("{\n" +
                        "  \"clientId\" : "+ clientId +",\n" +
                        "  \"base64data\" : \""+image+"\",\n" +
                        "  \"typeId\" : "+ typeId +"\n" +
                        "}")
                .when()
                .post( "/v1/clientImage/uploadDoc")
                .then().log().all()
                .statusCode(200);
    }

    public void boServices_v1_clientImage_uploadSelfie(String cookie, int clientId, String image1, String image2) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .body("{\n" +
                        "  \"clientId\" : "+clientId+",\n" +
                        "  \"base64Selfie1\" : \""+image1+"\",\n" +
                        "  \"base64Selfie2\" : \""+image2+"\"\n" +
                        "}")
                .when()
                .post( "/v1/clientImage/uploadSelfie")
                .then().log().all()
                .statusCode(200);
    }

    public void boServices_v1_user_roles(String cookie) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/user/roles")
                .then().log().all()
                .statusCode(200)
                .body("id", hasItems("BO", "CBO"),
                        "name", hasItems("Back officer", "Chief Back officer"));
    }

    public void boServices_v1_user_allActive (String cookie, String expectedUsername, String expectedPhone, String expectedEmail) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/user/allActive")
                .then().log().all()
                .statusCode(200)
                .body("username", hasItem(expectedUsername),
                        "phone", hasItem(expectedPhone),
                        "email", hasItem(expectedEmail));
    }

    public void boServices_v1_user_corpClients_site_SODEXO(String cookie, String expectedCompanyName, String expectedSite) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/user/corpClients/site/SODEXO")
                .then().log().all()
                .statusCode(200)
                .body("corpClientId", hasItem(notNullValue()),
                        "companyName", hasItem(expectedCompanyName),
                        "site", hasItem(expectedSite));
    }

    public void boServices_v1_user_verifyPhone(String cookie, String phone, boolean expectedValue) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .queryParam("phone", phone)
                .when()
                .get( "/v1/user/verifyPhone")
                .then().log().all()
                .statusCode(200)
                .body("value", equalTo(expectedValue));
    }

    public void boServices_v1_user_all(String cookie, String expectedUsername, String expectedFirstName, String expectedPhone, String expectedEmail) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/user/all")
                .then().log().all()
                .statusCode(200)
                .body("username", hasItem(expectedUsername),
                        "firstName", hasItem(expectedFirstName),
                        "phone", hasItem(expectedPhone),
                        "email", hasItem(expectedEmail));
    }

    public void boServices_v1_user_authenticated(String cookie, String expectedUsername, String expectedPhone, String expectedEmail) {
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                //.header("bo-auth-token", "123456")
                .when()
                .get( "/v1/user/authenticated")
                .then().log().all()
                .statusCode(200)
                .body("firstName", notNullValue(),
                        "lastName", notNullValue(),
                        "roleId", notNullValue(),
                        "stateId", notNullValue(),
                        "stateName", notNullValue(),
                        "username", notNullValue(),
                        "phone", notNullValue(),
                        //"corpClientId", notNullValue(),
                        "email", notNullValue(),
                        "site", notNullValue(),
                        "username", equalTo(expectedUsername),
                        "phone", equalTo(expectedPhone),
                        "email", equalTo(expectedEmail));
    }

    public void boServices_v1_fee_tariffPlan_create(String cookie,  int id, String name){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .queryParam("feeTariffPlanId", id)
                .queryParam("feeTariffPlanName", name)
                .when()
                .post("/v1/fee/tariffPlan/create")
                .then().log().all()
                .statusCode(200);
    }

    public void boServices_v1_fee_addTariffRule(String cookie, int tariffPlanId, int ruleId, int currencyId, int feePercent, int minFeeAmount, int maxFeeAmount, int flatFeeAmount, int feeCurrencyId){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .body("{\n" +
                        "  \"tariffPlanId\" : " + tariffPlanId + ",\n" +
                        "  \"ruleId\" : " + ruleId + ",\n" +
                        "  \"currencyId\" : " + currencyId + ",\n" +
                        "  \"feePercent\" : " + feePercent + ",\n" +
                        "  \"minFeeAmount\" : " + minFeeAmount + ",\n" +
                        "  \"maxFeeAmount\" : " + maxFeeAmount + ",\n" +
                        "  \"flatFeeAmount\" : " + flatFeeAmount + ",\n" +
                        "  \"feeCurrencyId\" : " + feeCurrencyId + "\n" +
                        "}")
                .when()
                .post( "/v1/fee/addTariffRule")
                .then().log().all()
                .statusCode(200);
    }

    public void boServices_v1_fee_deleteTariffRule(String cookie, int tarriffId){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .queryParam("tariffId", tarriffId)
                .when()
                .post( "/v1/fee/deleteTariffRule")
                .then().log().all()
                .statusCode(200);
    }

    public void boServices_v1_limit_addLimitValues(String cookie, int planId, int tranGroupId, int typeId, int baseCurrencyId, String limitLevel, final String limitAmount){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .body("{\n" +
                        "  \"planId\" : "+planId+",\n" +
                        "  \"tranGroupId\" : "+tranGroupId+",\n" +
                        "  \"typeId\" : "+typeId+",\n" +
                        "  \"baseCurrencyId\" : "+baseCurrencyId+",\n" +
                        "  \"limitLevel\" : \""+limitLevel+"\",\n" +
                        "  \"limitAmount\" : " + limitAmount + "\n" +
                        "}")
                .when()
                .post("/v1/limit/addLimitValues")
                .then().log().all()
                .statusCode(200);
    }

    public void boServices_v1_limit_delete(String cookie, int planId, int tranGroupId, int typeId, int baseCurrencyId, String limitLevel){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .body("{\n" +
                        "  \"planId\" : "+planId+",\n" +
                        "  \"tranGroupId\" : "+tranGroupId+",\n" +
                        "  \"typeId\" : "+typeId+",\n" +
                        "  \"baseCurrencyId\" : "+baseCurrencyId+",\n" +
                        "  \"limitLevel\" : \""+limitLevel+"\"\n" +
                        "}")
                .when()
                .post("/v1/limit/delete")
                .then().log().all()
                .statusCode(200);
    }

    public Response boServices_v1_limit_plans(String cookie){
        Response res = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get( "/v1/limit/plans");
         res.then().log().all()
         .statusCode(200);
         return res;
    }

    public void boServices_v1_limit_plan_create(String cookie, int limitPlanId, String limitPlanName){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .queryParam("limitPlanId", limitPlanId)
                .queryParam("limitPlanName", limitPlanName)
                .when()
                .post( "/v1/limit/plan/create")
                .then().log().all()
                .statusCode(200);
    }

    public void boServices_v1_limit_plan_delete(String cookie, int limitPlanId){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .queryParam("limitPlanId", limitPlanId)
                .when()
                .post( "/v1/limit/plan/delete")
                .then().log().all()
                .statusCode(200);
    }

    public void boServices_v1_user_pathParam(String cookie, String username, String expectedEmail, String expectedRoleId, String expectedPhone, String expectedLastName, String expectedStateName){
        given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .pathParam("username", username)
                .when()
                .get( "/v1/user/{username}")
                .then().log().all()
                .statusCode(200)
                .body("username", equalTo(username),
                        "email", equalTo(expectedEmail),
                        "roleId", equalTo(expectedRoleId),
                        "phone", equalTo(expectedPhone),
                        "lastName", equalTo(expectedLastName),
                        "stateName", equalTo(expectedStateName));
    }

    public Response  boServices_v1_ticket_take(String cookie) {
        Response response = given()
                .spec(requestSpecBO)
                .baseUri(HelperBase.prop.getProperty("bo.base.url"))
                .cookie(cookie)
                .when()
                .get("/v1/ticket/take");
        response.then().log().all().statusCode(200);
        return response;
    }
}