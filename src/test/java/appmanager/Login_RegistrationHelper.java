package appmanager;

import com.cs.dipocketback.base.data.Site;
import com.cs.dipocketback.pojo.client.CheckboxContainer;
import com.cs.dipocketback.pojo.client.CheckboxType;
import com.cs.dipocketback.pojo.client.ClientAddress;
import com.cs.dipocketback.pojo.registration.AttachedCard;
import com.cs.dipocketback.pojo.registration.RegSavepointData;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class Login_RegistrationHelper extends HelperBase {
    DBHelper dbHelper = new DBHelper();
    EmailIMAPHelper emailIMAPHelper = new EmailIMAPHelper();

    public String loginDipocket(String phone, String pass, final String deviceUUID) throws ClassNotFoundException, SQLException {
        String cliSessionId = null;
        String site = "DIPOCKET";
        baseURI = HelperBase.prop.getProperty("mobile.base.url");
        basePath = "";

        dbHelper.deleteClientDeviceFromDB(deviceUUID, prop.getProperty("db.url"));

        given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(phone, pass)
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"" + deviceUUID + "\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post("homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));

        String loginSMSCode = dbHelper.getLoginSMSFromDB(phone, deviceUUID, site, prop.getProperty("db.url"));

        Response res =  given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(phone, pass)
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+deviceUUID+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all().statusCode(200);
        System.out.println("Login done");
        return cliSessionId;
    }

    public String loginDipocket_test(String phone, String pass, String deviceUUID) throws ClassNotFoundException, SQLException {
        String cliSessionId = null;
        String site = "DIPOCKET";
        //baseURI = HelperBase.prop.getProperty("mobile.test.base.url");
        basePath = "";

        dbHelper.deleteClientDeviceFromDB(deviceUUID, prop.getProperty("db.test.url"));

        given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(phone, pass)
                .baseUri(HelperBase.prop.getProperty("mobile.test.base.url"))
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"" + deviceUUID + "\",\n" +
                        "  \"appVersion\" : \"2.2.7\"\n" +
                        "}")
                .when()
                .post("homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));

        String loginSMSCode = dbHelper.getLoginSMSFromDB(phone, deviceUUID, site, prop.getProperty("db.test.url"));

        Response res =  given()
                .log().uri().log().headers().log().body()
                .auth().preemptive().basic(phone, pass)
                .baseUri(HelperBase.prop.getProperty("mobile.test.base.url"))
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+deviceUUID+"\",\n" +
                        "  \"appVersion\" : \"2.2.7\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( "homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all().statusCode(200);
        System.out.println("Login done");
        return cliSessionId;
    }

    public String loginPlayIT(String phone, String pass, final String deviceUUID) throws ClassNotFoundException, SQLException {
        String cliSessionId = null;
        String site = "PLAYIT";
        baseURI = HelperBase.prop.getProperty("mobile.base.url");
        dbHelper.deleteClientDeviceFromDB(deviceUUID, prop.getProperty("db.url"));

        given().log().uri().log().headers().log().body()
                .auth().preemptive().basic("9_" + phone, pass)
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"" + deviceUUID + "\",\n" +
                        "  \"appVersion\" : \"1.4.9\"\n" +
                        "}")
                .when()
                .post("homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                .body("errCode", equalTo("DIP-00591"));

        String loginSMSCode = dbHelper.getLoginSMSFromDB(phone, deviceUUID, "PLAYIT", prop.getProperty("db.url"));
        Response res = given().log().uri().log().headers().log().body()
                .auth().preemptive().basic("9_" + phone, pass)
                .header("deviceuuid", deviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \"" + deviceUUID + "\",\n" +
                        "  \"appVersion\" : \"1.4.9\",\n" +
                        "  \"otp\" : \"" + loginSMSCode + "\"\n" +
                        "}")
                .when()
                .post("homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println("cliSessionId " + cliSessionId);
        res.then().log().all().statusCode(200);
        return cliSessionId;
    }

    public String loginUpAndGo (String phone, String pass, String mobileLoginDeviceUUID) throws SQLException, ClassNotFoundException {
        String cliSessionId = null;
        String site = "UPANDGO";

        dbHelper.deleteClientDeviceFromDB(mobileLoginDeviceUUID, prop.getProperty("db.url"));
        given().log().uri().log().headers().log().body()
                .auth().preemptive().basic("10_" + phone, pass)
                .header("deviceuuid", mobileLoginDeviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ mobileLoginDeviceUUID+"\",\n" +
                        "  \"appVersion\" : \"1.1.11\"\n" +
                        "}")
                .when()
                .post( HelperBase.prop.getProperty("mobile.base.url")+"homePage/authenticateMobileApp")
                .then().log().all()
                .statusCode(400)
                //.body("errDesc", equalTo("Введите код (#1) из SMS, что б подтвердить вход на этом устройстве"))
                .body("errCode", equalTo("DIP-00591"));


        String loginSMSCode = dbHelper.getLoginSMSFromDB(phone, mobileLoginDeviceUUID, site, prop.getProperty("db.url"));
        Response res =  given().log().uri().log().headers().log().body()
                .auth().preemptive().basic("10_" + phone, pass)
                .header("deviceuuid", mobileLoginDeviceUUID)
                .header("site", site)
                .contentType("application/json; charset=UTF-8")
                .body("{\n" +
                        "  \"devToken\" : \"eGy9q-lDQBGKz-bgdz1U6q:APA91bF8bT00_Cj-KVTiTSLlB-LBL8itr4LKxJVSxKJGZs3eyvHMbLZ4mZWYyo_r290PQFuKhx7mQOgAFeisGhBByoHXzQ0ANETYA-nTnDGM29zXKxcaIh47qJ7dyFQymXolPLYtmeM8\",\n" +
                        "  \"devType\" : \"android\",\n" +
                        "  \"deviceUUID\" : \""+ mobileLoginDeviceUUID+"\",\n" +
                        "  \"appVersion\" : \"1.1.11\",\n" +
                        "  \"otp\" : \""+loginSMSCode+"\"\n" +
                        "}")
                .when()
                .post( HelperBase.prop.getProperty("mobile.base.url")+"homePage/authenticateMobileApp");
        cliSessionId = res.getHeader("cliSessionId");
        System.out.println("cliSessionId " + cliSessionId);
        //dbHelper.storeDataToTheFile("files\\tds\\cliSessionId.txt",cliSessionId);
        res.then().log().all().statusCode(200);
        return cliSessionId;
    }

    public List<String> loginSnowAttack2(String phone, String pass) {
        List<String> collection = new ArrayList<>();

        Response res = given().log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("base.url"))
                .header("site", Site.SNOW_ATTACK.toString())
                .contentType("application/json; charset=utf-8")
                .auth().preemptive().basic("11_" + phone, pass)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("WebServices/v1/homePage/authenticateWithSca");

        res.then().log().all();

        //Cookies cookie = res.then().extract().response().getDetailedCookies();
        String cookie = res.then().extract().response().getCookie("JSESSIONID");
        collection.add(cookie);

        String cliSessionId = res.getHeader("cliSessionId");
        collection.add(cliSessionId);

        if(res.getStatusCode() != 200) {

            String responseBody = res.getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errCode = jsonPath.getString("errCode");

            if (errCode.equals("DIP-00602")) {

                given().log().uri().log().headers().log().body()
                        .baseUri(HelperBase.prop.getProperty("base.url"))
                        .header("site", Site.SNOW_ATTACK.toString())
                        .contentType("application/json; charset=utf-8")
                        .auth().preemptive().basic("11_" + phone, pass)
                        .body("{\n" +
                                "  \"mainPhone\" : \"" + phone + "\"\n" +
                                "}")
                        .when()
                        .post("WebServices/v1/security/sendSca")
                        .then().log().all()
                        .statusCode(200);
            }
        }

        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);

        assertEquals(res.getStatusCode(), 200);


//        given()
//                //.spec(requestSpecSnowAttackHomePage)
//                .log().uri().log().headers().log().body()
//                .baseUri(HelperBase.prop.getProperty("mobile.base.url"))
//                .header("site", HelperBase.prop.getProperty("mobile.site.snowAttack"))
//                //.auth().preemptive().basic(phone, pass)
//                .header("clisessionid", ""+cliSessionId+"")
//                .cookie("JSESSIONID", cookie)
//                .when()
//                .get("clientProfile/getLegalDocumentList")
//                .then().log().all()
//                .statusCode(200)
//                .body("documentList.type", hasItems("General Terms and Conditions", "Card Terms and Conditions"),
//                        "documentList.nameForClient", hasItems("Общие условия", "Условия пользования картами"),
//                        "documentList.selected", hasItems(false, false));


        return collection;
    }

    public String loginSnowAttack(String phone, String pass) {
        Response res = given().log().uri().log().headers().log().body()
                .baseUri(HelperBase.prop.getProperty("base.url"))
                .header("site", Site.SNOW_ATTACK.toString())
                .contentType("application/json; charset=utf-8")
                .auth().preemptive().basic("11_" + phone, pass)
                .header("accept", "application/json, text/json;q=0.8, text/plain;q=0.6, */*;q=0.1")
                .when()
                .post("WebServices/v1/homePage/authenticateWithSca");

        res.then().log().all();

        String cliSessionId = res.getHeader("cliSessionId");

        if(res.getStatusCode() != 200) {

            String responseBody = res.getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);
            String errCode = jsonPath.getString("errCode");

            if (errCode.equals("DIP-00602")) {

                given().log().uri().log().headers().log().body()
                        .baseUri(HelperBase.prop.getProperty("base.url"))
                        .header("site", Site.SNOW_ATTACK.toString())
                        .contentType("application/json; charset=utf-8")
                        .auth().preemptive().basic("11_" + phone, pass)
                        .body("{\n" +
                                "  \"mainPhone\" : \"" + phone + "\"\n" +
                                "}")
                        .when()
                        .post("WebServices/v1/security/sendSca")
                        .then().log().all()
                        .statusCode(200);
            }
        }

        System.out.println(res.getHeaders());
        System.out.println("cliSessionId " + cliSessionId);

        assertEquals(res.getStatusCode(), 200);

        return cliSessionId;
    }

    public void dipocketRegistration(int countryId1, int currencyId1, String terms1, String terms2, String pin, String birthDate, String phone, String email, String env) throws InterruptedException, SQLException, ClassNotFoundException {
        String envUrl = HelperBase.prop.getProperty("mobile.base.url");
        String dbEnvUrl = prop.getProperty("db.url");
        emailIMAPHelper.deleteLettersFromEmail("pop.gmail.com", email, "password1<");

        if(env.equals("dev")){
            envUrl = HelperBase.prop.getProperty("mobile.base.url");
            dbEnvUrl = prop.getProperty("db.url");
        }

        if(env.equals("test")){
            envUrl = HelperBase.prop.getProperty("mobile.test.base.url");
            dbEnvUrl = prop.getProperty("db.test.url");
        }


        String smsCode = null;
        int countryId = countryId1;
        int currencyId = currencyId1;
        String site = "DIPOCKET";
        int langId = 1;

        Gson gson = new Gson();
        ClientAddress clientAddress = new ClientAddress();
        ClientAddress regAddress = new ClientAddress();
        RegSavepointData regSavepointData2 = new RegSavepointData();

        dbHelper.deleteClientFromDB(phone, site, dbEnvUrl);
        given()
                //.spec(app.requestSpecDipocketRegistration)
                .log().uri().log().headers().log().body()
                .baseUri(envUrl)
                .header("site", HelperBase.prop.getProperty("mobile.site"))
                .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"))
                .queryParam("langID", langId)
                .when()
                .get( "references/availableCountries")
                .then().log().all()
                .statusCode(200)
                .body("countryList.code", hasItems("AU", "MK", "JP"));
                        //"countryList.name", hasItems("Австралия", "Македония", "Япония"));

            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", HelperBase.prop.getProperty("mobile.site"))
                    .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"))
                    .when()
                    .get("references/languages")
                    .then().log().all()
                    .statusCode(200);
                    //.body("languageList.name", hasItems("English", "Polski", "Русский", "Українська"));
                            //"langHash", equalTo("6f17331d1fd95282099858d04b3b7c3032bb3b654fbcfe73774b0e190eb16a08"));


            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", HelperBase.prop.getProperty("mobile.registration.deviceuuid"))
                    .when()
                    .get("references/appConfig?platform=android&version=2.2.9&langCode=rus")
                    .then().log().all()
                    .statusCode(200)
                    .body("appParams.isAccountCreationEnabled", equalTo(true));


            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .queryParam("devUUID", prop.getProperty("mobile.registration.deviceuuid"))
                    .when()
                    .get("userRegistration/loadSavePointData2")
                    .then().log().all()
                    .statusCode(200)
                    .body("isInvited", equalTo(false));


            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .queryParam("langID", langId)
                    .queryParam("phoneNum", phone)
                    .body("{\n" +
                            "  \"smsNumber\" : 1\n" +
                            "}")
                    .when()
                    .post("userRegistration/sendSMSCodeForPhone")
                    .then().log().all()
                    .statusCode(200);


            given()
                    .log().uri().log().headers().log().body()
                    .when()
                    .get("http://app.dipocket.dev:8091/sms/all")
                    .then().log().all()
                    .statusCode(200);

            String smsMessage = given()
                    .log().uri().log().headers().log().body()
                    .queryParam("phone", phone)
                    .queryParam("site", site)
                    .when()
                    .get("http://app.dipocket.dev:8091/sms/by_phone_and_site")
                    .then().log().all()
                    .statusCode(200)
                    .extract().path("message");

            String  smsFromMemCash = smsMessage.substring(6, 12);
            System.out.println("smsFromMemCash: " + smsFromMemCash);

            smsCode = dbHelper.getSMSCodeFromDB(phone, site, dbEnvUrl);
            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .queryParam("phone", phone)
                    .when()
                    .get("references/verifyPhone")
                    .then().log().all()
                    .statusCode(200)
                    .body("value", equalTo(true));


            Response res = given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .queryParam("langID", langId)
                    .when()
                    .get("references/topCountries");
            res.then().log().all();
            int statusCode = res.getStatusCode();
            assertEquals(statusCode, 200);
            res.then().body("topCountries.name", hasItems("Italy", "Germany", "Hungary"));


            clientAddress.setTypeId(0);
            regAddress.setTypeId(3);
            List<AttachedCard> attachedCardsList = new ArrayList<>();

            RegSavepointData regSavepointData = new RegSavepointData();
            regSavepointData.setDeviceUUID(HelperBase.prop.getProperty("mobile.registration.deviceuuid"));
            regSavepointData.setLangId(langId);
            regSavepointData.setMainPhone(phone);
            regSavepointData.setStepNo(1);
            regSavepointData.setRegisteredAddrAsmail(true);
            regSavepointData.setAddress(clientAddress);
            regSavepointData.setRegAddress(regAddress);
            regSavepointData.setAttachedCardsList(attachedCardsList);
            regSavepointData.setSmsCode(smsCode);
            regSavepointData.setIsSkipped(false);
            String json = gson.toJson(regSavepointData);

            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .contentType("application/json")
                    .body(json)
//                .body("{\n" +
//                        "  \"deviceUUID\" : \""+ HelperBase.prop.getProperty("mobile.registration.deviceuuid")+"\",\n" +
//                        "  \"langId\" : 4,\n" +
//                        "  \"mainPhone\" : \""+ HelperBase.prop.getProperty("mobile.registration.phoneNumber")+"\",\n" +
//                        "  \"stepNo\" : 1,\n" +
//                        "  \"registeredAddrAsmail\" : true,\n" +
//                        "  \"address\" : {\n" +
//                        "    \"typeId\" : 0\n" +
//                        "  },\n" +
//                        "  \"regAddress\" : {\n" +
//                        "    \"typeId\" : 3\n" +
//                        "  },\n" +
//                        "  \"attachedCardsList\" : [ ],\n" +
//                        "  \"smsCode\" : \"" + smsCode + "\",\n" +
//                        "  \"isSkipped\" : false,\n" +
//                        "  \"address1\" : {\n" +
//                        "    \"typeId\" : 0\n" +
//                        "  },\n" +
//                        "  \"attachedCardIds\" : [ ]\n" +
//                        "}")
                    .when()
                    .put("userRegistration/registrationSavePoint2")
                    .then().log().all()
                    .statusCode(200);


            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .queryParam("langID", langId)
                    .queryParam("phoneNum", phone)
                    .queryParam("code", smsCode)
                    .when()
                    .get("userRegistration/checkPhoneAndLoadSavePoint")
                    .then().log().all()
                    .statusCode(200)
                    .body("isInvited", equalTo(false),
                            "smsCode", equalTo(smsCode));


            clientAddress.setStreetLine1("Home");
            clientAddress.setCity("Kharkiv");
            clientAddress.setZip("30-000");
            clientAddress.setCountryId(countryId);

            regAddress.setStreetLine1("Home");
            regAddress.setCity("Kharkiv");
            regAddress.setZip("30-000");
            regAddress.setCountryId(countryId);
            List<AttachedCard> attachedCardsList2 = new ArrayList<>();

            regSavepointData2.setDeviceUUID(HelperBase.prop.getProperty("mobile.registration.deviceuuid"));
            regSavepointData2.setLangId(langId);
            regSavepointData2.setFirstName(HelperBase.prop.getProperty("mobile.registration.firstName"));
            regSavepointData2.setLastName(HelperBase.prop.getProperty("mobile.registration.lastName"));
            regSavepointData2.setMainPhone(phone);
            regSavepointData2.setCountryId(countryId);
            regSavepointData2.setCurrencyId(currencyId);
            regSavepointData2.setBirthDate(birthDate);
            //regSavepointData2.setBirthDate("1230768000000"); // less then 16
            regSavepointData2.setResidenceCountryId(countryId);
            regSavepointData2.setStepNo(2);
            regSavepointData2.setRegisteredAddrAsmail(true);
            regSavepointData2.setAddress(clientAddress);
            regSavepointData2.setRegAddress(regAddress);
            regSavepointData2.setAttachedCardsList(attachedCardsList2);
            regSavepointData2.setSmsCode(smsCode);
            regSavepointData2.setIsSkipped(false);
            String json2 = gson.toJson(regSavepointData2);
            System.out.println(json);

            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .contentType("application/json")
                    .body(json2)
//                .body("{\n" +
//                        "  \"deviceUUID\" : \""+ HelperBase.prop.getProperty("mobile.registration.deviceuuid")+"\",\n" +
//                        "  \"langId\" : 4,\n" +
//                        "  \"firstName\" : \""+ HelperBase.prop.getProperty("mobile.registration.firstName")+"\",\n" +
//                        "  \"lastName\" : \""+ HelperBase.prop.getProperty("mobile.registration.lastName")+"\",\n" +
//                        "  \"mainPhone\" : \""+ HelperBase.prop.getProperty("mobile.registration.phoneNumber")+"\",\n" +
//                        "  \"countryId\" : "+countryId+",\n" +
//                        "  \"currencyId\" : "+currencyId+",\n" +
//                        "  \"birthDate\" : \"715611173985\",\n" +
//                        "  \"residenceCountryId\" : 616,\n" +
//                        "  \"stepNo\" : 2,\n" +
//                        "  \"registeredAddrAsmail\" : true,\n" +
//                        "  \"address\" : {\n" +
//                        "    \"typeId\" : 0,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"regAddress\" : {\n" +
//                        "    \"typeId\" : 3,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"attachedCardsList\" : [ ],\n" +
//                        "  \"smsCode\" : \"" + smsCode + "\",\n" +
//                        "  \"isSkipped\" : false,\n" +
//                        "  \"address1\" : {\n" +
//                        "    \"typeId\" : 0,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"attachedCardIds\" : [ ]\n" +
//                        "}")
                    .when()
                    .put("userRegistration/registrationSavePoint2")
                    .then().log().all()
                    .statusCode(200);


            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .contentType( "application/json")
                    .body("{\n" +
                            "  \"deviceUUID\" : \""+ prop.getProperty("mobile.registration.deviceuuid")+"\",\n" +
                            "  \"langId\" : "+langId+",\n" +
                            "  \"typeId\" : 1,\n" +
                            "  \"base64Image\" : \"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\\n\"\n" +
                            "}")
                    .when()
                    .put("userRegistration/clientImage")
                    .then().log().all()
                    .statusCode(200);


            regSavepointData2.setStepNo(3);
            String json3 = gson.toJson(regSavepointData2);
            System.out.println(json3);

            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .contentType("application/json")
                    .body(json)
//                .body("{\n" +
//                        "  \"deviceUUID\" : \""+ HelperBase.prop.getProperty("mobile.registration.deviceuuid")+"\",\n" +
//                        "  \"langId\" : 4,\n" +
//                        "  \"firstName\" : \""+ HelperBase.prop.getProperty("mobile.registration.firstName")+"\",\n" +
//                        "  \"lastName\" : \""+ HelperBase.prop.getProperty("mobile.registration.lastName")+"\",\n" +
//                        "  \"mainPhone\" : \""+ HelperBase.prop.getProperty("mobile.registration.phoneNumber")+"\",\n" +
//                        "  \"countryId\" : "+countryId+",\n" +
//                        "  \"currencyId\" : "+currencyId+",\n" +
//                        "  \"birthDate\" : \"715611173985\",\n" +
//                        "  \"residenceCountryId\" : 616,\n" +
//                        "  \"stepNo\" : 3,\n" +
//                        "  \"registeredAddrAsmail\" : true,\n" +
//                        "  \"address\" : {\n" +
//                        "    \"typeId\" : 0,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"regAddress\" : {\n" +
//                        "    \"typeId\" : 3,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"attachedCardsList\" : [ ],\n" +
//                        "  \"smsCode\" : \"" + smsCode + "\",\n" +
//                        "  \"isSkipped\" : false,\n" +
//                        "  \"address1\" : {\n" +
//                        "    \"typeId\" : 0,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"attachedCardIds\" : [ ]\n" +
//                        "}")
                    .when()
                    .put("userRegistration/registrationSavePoint2")
                    .then().log().all()
                    .statusCode(200);


            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .contentType("application/json")
                    .body("{\n" +
                            "  \"deviceUUID\" : \""+ prop.getProperty("mobile.registration.deviceuuid")+"\",\n" +
                            "  \"langId\" : "+langId+",\n" +
                            "  \"typeId\" : 4,\n" +
                            "  \"base64Image\" : \"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\\nCbVUAAA6QH//2Q==\\n\"\n" +
                            "}")
                    .when()
                    .put("userRegistration/clientImage")
                    .then().log().all()
                    .statusCode(200);


            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .queryParam("langID", langId)
                    .queryParam("countryId", countryId)
                    .when()
                    .get("references/questions")
                    .then().log().all()
                    .statusCode(200)
                    .body("checkboxList.typeId[0]", equalTo(terms1),
                            "checkboxList.typeId[1]", equalTo(terms2));


            regSavepointData2.setEmail(email);
            regSavepointData2.setStepNo(4);
            String json4 = gson.toJson(regSavepointData2);
            System.out.println(json);

            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .contentType("application/json")
                    .body(json4)
//                .body("{\n" +
//                        "  \"deviceUUID\" : \""+ HelperBase.prop.getProperty("mobile.registration.deviceuuid")+"\",\n" +
//                        "  \"langId\" : 4,\n" +
//                        "  \"firstName\" : \""+ HelperBase.prop.getProperty("mobile.registration.firstName")+"\",\n" +
//                        "  \"lastName\" : \""+ HelperBase.prop.getProperty("mobile.registration.lastName")+"\",\n" +
//                        "  \"mainPhone\" : \""+ HelperBase.prop.getProperty("mobile.registration.phoneNumber")+"\",\n" +
//                        "  \"email\" : \""+ HelperBase.prop.getProperty("mobile.registration.email")+"\",\n" +
//                        "  \"countryId\" : "+countryId+",\n" +
//                        "  \"currencyId\" : "+currencyId+",\n" +
//                        "  \"birthDate\" : \"715611173985\",\n" +
//                        "  \"residenceCountryId\" : 616,\n" +
//                        "  \"stepNo\" : 4,\n" +
//                        "  \"registeredAddrAsmail\" : true,\n" +
//                        "  \"address\" : {\n" +
//                        "    \"typeId\" : 0,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"regAddress\" : {\n" +
//                        "    \"typeId\" : 3,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"attachedCardsList\" : [ ],\n" +
//                        "  \"smsCode\" : \"" + smsCode + "\",\n" +
//                        "  \"isSkipped\" : false,\n" +
//                        "  \"address1\" : {\n" +
//                        "    \"typeId\" : 0,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"attachedCardIds\" : [ ]\n" +
//                        "}")
                    .when()
                    .put("userRegistration/registrationSavePoint2")
                    .then().log().all()
                    .statusCode(200);


            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .queryParam("deviceUUID", prop.getProperty("mobile.registration.deviceuuid"))
                    .when()
                    .put("userRegistration/sendTermsAndConditions")
                    .then().log().all()
                    .statusCode(200);


            CheckboxContainer checkboxContainer1 = new CheckboxContainer();
            checkboxContainer1.setTypeId(CheckboxType.valueOf(terms1));
            checkboxContainer1.setSelected(true);

            CheckboxContainer checkboxContainer2 = new CheckboxContainer();
            checkboxContainer2.setTypeId(CheckboxType.valueOf(terms2));
            checkboxContainer2.setSelected(true);

            List<CheckboxContainer> checkboxList = new ArrayList<>();
            checkboxList.add(checkboxContainer1);
            checkboxList.add(checkboxContainer2);

            regSavepointData2.setSecAnswer("QA");
            regSavepointData2.setPin(pin);
            regSavepointData2.setCheckboxList(checkboxList);
            String json5 = gson.toJson(regSavepointData2);

            given()
                    //.spec(requestSpecDipocketRegistration)
                    .log().uri().log().headers().log().body()
                    .baseUri(envUrl)
                    .header("site", prop.getProperty("mobile.site"))
                    .header("deviceuuid", prop.getProperty("mobile.registration.deviceuuid"))
                    .contentType("application/json")
                    .body(json5)
//                .body("{\n" +
//                        "  \"deviceUUID\" : \""+ HelperBase.prop.getProperty("mobile.registration.deviceuuid")+"\",\n" +
//                        "  \"langId\" : 4,\n" +
//                        "  \"firstName\" : \""+ HelperBase.prop.getProperty("mobile.registration.firstName")+"\",\n" +
//                        "  \"lastName\" : \""+ HelperBase.prop.getProperty("mobile.registration.lastName")+"\",\n" +
//                        "  \"mainPhone\" : \""+ HelperBase.prop.getProperty("mobile.registration.phoneNumber")+"\",\n" +
//                        "  \"email\" : \""+ HelperBase.prop.getProperty("mobile.registration.email")+"\",\n" +
//                        "  \"countryId\" : "+countryId+",\n" +
//                        "  \"currencyId\" : "+currencyId+",\n" +
//                        "  \"birthDate\" : \"715611173985\",\n" +
//                        "  \"residenceCountryId\" : 616,\n" +
//                        "  \"secAnswer\" : \"QA\",\n" +
//                        "  \"pin\" : \""+ app.generateRandomString(8)+"\",\n" +
//                        "  \"stepNo\" : 4,\n" +
//                        "  \"registeredAddrAsmail\" : true,\n" +
//                        "  \"address\" : {\n" +
//                        "    \"typeId\" : 0,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"regAddress\" : {\n" +
//                        "    \"typeId\" : 3,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"attachedCardsList\" : [ ],\n" +
//                        "  \"smsCode\" : \""+smsCode+"\",\n" +
//                        "  \"isSkipped\" : false,\n" +
//                        "  \"checkboxList\" : [ {\n" +
//                        "    \"typeId\" : \"TERMS_AND_CONDITIONS_PL\",\n" +
//                        "    \"selected\" : true\n" +
//                        "  }, {\n" +
//                        "    \"typeId\" : \"ELECTRONIC_COMMUNICATION\",\n" +
//                        "    \"selected\" : true\n" +
//                        "  } ],\n" +
//                        "  \"address1\" : {\n" +
//                        "    \"typeId\" : 0,\n" +
//                        "    \"streetLine1\" : \"New Home\",\n" +
//                        "    \"streetLine2\" : \"\",\n" +
//                        "    \"city\" : \"Xxxx\",\n" +
//                        "    \"zip\" : \"30-000\",\n" +
//                        "    \"countryId\" : "+countryId+"\n" +
//                        "  },\n" +
//                        "  \"attachedCardIds\" : [ ]\n" +
//                        "}")
                    .when()
                    .post("userRegistration/registerNewClient2")
                    .then().log().all()
                    .statusCode(200)
                    .body("resultCode", equalTo(0));


            String link = EmailIMAPHelper.getLinkFromEmailAfterRegistration("pop.gmail.com", email, "password1<", "DiPocket Terms and Conditions - PLEASE DO NOT DISCARD");
            System.out.println("link_link " + link);
            given().log().uri().log().headers().log().body()
                    .when()
                    .get(link)
                    .then().log().all();
                    //.statusCode(200);
                    //.body("html.body.div.div.div.p", equalTo("Адрес электронной почты подтвержден"),
                   //         "html.body.div.div.div.h2", equalTo("Большое спасибо!"));

        int emailisverified =  dbHelper.getEMAILISVERIFIEDFromClientFromDB(phone, site, dbEnvUrl);
        assertThat(emailisverified, equalTo(1));

        System.out.println("Registration done");
    }
}