package appmanager;

import com.cs.dipocketback.base.data.Site;
import com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.bo.User_roles;
import model.bo.boClient.Account_client;
import model.bo.boServices.Client_clientId_update;
import org.testng.Assert;
import requests.bo.BORequests;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class BOHelper extends HelperBase {
    BORequests boRequests = new BORequests();
    int ticketId = 0;
    String actualTypeName = null;
    String actualClientId = null;
    String clientStateName = null;
    int currencyId = 978;
    int countryId = 826;
    Client_clientId_update client_clientId_update = new Client_clientId_update();
    Gson gson = new Gson();

    public int takeSDDTicketFromTest(String cookie, String sms, String clientId, String date) {
        int count = 0;
        for(int i = 0; i < 27; i++) {
            count++;
            Response res = boRequests.boServices_v1_ticket_take_test(cookie, sms);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");
            actualClientId = js.getString("clientId");
            clientStateName = js.getString("clientStateName");

            if(actualTypeName.equals("SDD check") && actualClientId.equals(clientId)){
                break;
            }

            approveBlockedFDDTickets_test(cookie, sms);
            updateAndApproveSDDTicket_test(cookie, sms, actualClientId, ticketId);

            if(!actualTypeName.equals("SDD check") || !actualClientId.equals(clientId)){
                boRequests.boServices_v1_ticket_ticketId_postpone_test(cookie, ticketId, date, sms);
            }

            Response res2 = boRequests.boServices_v1_ticket_take_test(cookie, sms);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        System.out.println("count: " + count);

        assertEquals(actualTypeName, "SDD check");
        return  ticketId;
    }

    public int takeFDDTicketFromTest(String cookie, String sms, String clientId, String date) {
        int count = 0;
        for(int i = 0; i < 27; i++) {
            count++;
            Response res = boRequests.boServices_v1_ticket_take_test(cookie, sms);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");
            actualClientId = js.getString("clientId");

            if(actualTypeName.equals("FDD check") && actualClientId.equals(clientId)){
                break;
            }

            if(!actualTypeName.equals("FDD check") || !actualClientId.equals(clientId)){
                boRequests.boServices_v1_ticket_ticketId_postpone_test(cookie, ticketId, date, sms);
            }

            Response res2 = boRequests.boServices_v1_ticket_take_test(cookie, sms);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        System.out.println("count: " + count);

        assertEquals(actualTypeName, "FDD check");
        return  ticketId;
    }

    public int takeCardholderNameChangeTicket_dev(String cookie, String date) {
        int count = 0;
        for (int i = 0; i < 27; i++) {
            count++;
            Response res = boRequests.boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");
            actualClientId = js.getString("clientId");
            clientStateName = js.getString("clientStateName");

            if (actualTypeName.equals("Cardholder name change") && clientStateName.equals("Active")) {
                break;
            }

            approveFDDBlockedTickets_dev(cookie, actualClientId, ticketId);
            updateAndApproveSDDBlockedTicket_dev(cookie, actualClientId, ticketId);

            if (!actualTypeName.equals("Cardholder name change")) {
                boRequests.boServices_v1_ticket_ticketId_postpone(cookie, ticketId, date);
            }

            if(actualTypeName.equals("Supervision") && clientStateName.equals("Blocked")){
                boRequests.boServices_v1_ticket_ticketId_postpone(cookie, ticketId, date);
            }

            Response res2 = boRequests.boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        System.out.println("count: " + count);
        assertEquals(actualTypeName, "Cardholder name change");
        return  ticketId;
    }

    public int takeSupervisionTicket_dev(String cookie, String date) {
        for(int i = 0; i < 25; i++) {
            Response res = boRequests.boServices_v1_ticket_take(cookie);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");
            actualClientId = js.getString("clientId");
            clientStateName = js.getString("clientStateName");

            if(actualTypeName.equals("Supervision") && clientStateName.equals("Active")){
                break;
            }

            approveFDDBlockedTickets_dev(cookie, actualClientId, ticketId);
            updateAndApproveSDDBlockedTicket_dev(cookie, actualClientId, ticketId);

            if(!actualTypeName.equals("Supervision")){
                boRequests.boServices_v1_ticket_ticketId_postpone(cookie, ticketId, date);
            }

            if(actualTypeName.equals("Supervision") && clientStateName.equals("Blocked")){
                boRequests.boServices_v1_ticket_ticketId_postpone(cookie, ticketId, date);
            }

            Response res2 = boRequests.boServices_v1_ticket_take(cookie);
            String response2 = res2.then().extract().response().asString();

            JsonPath js2 = new JsonPath(response2);
            ticketId = js2.getInt("id");
            actualTypeName = js2.getString("typeName");
        }

        assertEquals(actualTypeName, "Supervision");
        return ticketId;
    }

    public void approveFDDBlockedTickets_dev(String cookie, String actualClientId, int ticketId) {
        if(actualTypeName.equals("FDD check") && clientStateName.equals("Blocked")){
            given()
                    .log().uri().log().headers().log().body()
                    .baseUri("https://support.dipocket.dev")
                    .basePath("BOServices")
                    .contentType("application/json")
                    .pathParam("clientId", actualClientId)
                    .header("bo-auth-token", 123456)
                    .queryParam("ticketId", ticketId)
                    .cookie(cookie)
                    .post("/v1/client/{clientId}/approveFDD")
                    .then().log().all()
                    .statusCode(200);
        }
    }

    public void approveBlockedFDDTickets_test(String cookie, String sms) {
        if(actualTypeName.equals("FDD check") && clientStateName.equals("Blocked")){
            given()
                    .log().uri().log().headers().log().body()
                    .baseUri("https://support.dipocket.site")
                    .basePath("BOServices")
                    .contentType("application/json")
                    .pathParam("clientId", actualClientId)
                    .header("bo-auth-token", sms)
                    .queryParam("ticketId", ticketId)
                    .cookie(cookie)
                    .post("/v1/client/{clientId}/approveFDD")
                    .then().log().all()
                    .statusCode(200);
        }
    }

    public void updateAndApproveSDDTicket_test(String cookie, String sms, String actualClientId, int ticketId) {
        if(actualTypeName.equals("SDD check") && clientStateName.equals("Blocked")){
            //client_clientId_update.setId(Integer.parseInt(clientId));
            client_clientId_update.setMainPhone(380685448615l);
            //client_clientId_update.setFirstName("Pavel");
            //client_clientId_update.setLastName("Burinsky");
            //client_clientId_update.setBirthDate("04.09.1992");
            //client_clientId_update.setEmail("testdipocket@gmail.com");
            client_clientId_update.setEmailIsVerified(false);
            client_clientId_update.setStateId(1);
            client_clientId_update.setStateName("Active");
            client_clientId_update.setCurrencyId(currencyId);
            client_clientId_update.setCurrencyCode("PLN");
            client_clientId_update.setLangId(4);
            client_clientId_update.setLangCode("eng");
            client_clientId_update.setLangName("English");
            client_clientId_update.setPhotoIdTypeId(1);
            client_clientId_update.setPhotoIdTypeName("Passport");
            client_clientId_update.setPhotoIdNo(234234324324l);
            client_clientId_update.setPhotoIdCountryId(countryId);
            client_clientId_update.setPhotoIdCountryName("Poland");
            client_clientId_update.setGender("M");
            client_clientId_update.setDdStatus("PSDD");
            client_clientId_update.setCardHolderName("Pavel Burinsky");
            client_clientId_update.setIdentifyCode(13124244234l);
            client_clientId_update.setClientType("I");
            client_clientId_update.setSite(Site.DIPOCKET.toString());
            client_clientId_update.setRegisteredAddrAsMail(true);
            client_clientId_update.setResidenceCountryId(countryId);
            client_clientId_update.setFeeTariffPlanId(1);
            client_clientId_update.setFeeTariffPlanName("EUR - standard");
            client_clientId_update.setAge(30);
            client_clientId_update.setMigrated(false);
            client_clientId_update.setSkippedReg(false);
            String json = gson.toJson(client_clientId_update);

            given()
                    .log().uri().log().headers().log().body()
                    //.config(configTimeout)
                    .baseUri("https://support.dipocket.site")
                    .basePath("BOServices")
                    .contentType("application/json")
                    .pathParam("clientId", actualClientId)
                    .header("bo-auth-token", sms)
                    .cookie(cookie)
                    .when()
                    .body(json)
                    .post("/v1/client/{clientId}/update")
                    .then().log().all()
                    .statusCode(200);

            given()
                    .log().uri().log().headers().log().body()
                    //.config(configTimeout)
                    .baseUri("https://support.dipocket.site")
                    .basePath("BOServices")
                    .contentType("application/json")
                    .pathParam("clientId", actualClientId)
                    .header("bo-auth-token", sms)
                    .queryParam("ticketId", ticketId)
                    .cookie(cookie)
                    .post("/v1/client/{clientId}/approveSDD")
                    .then().log().all()
                    .statusCode(200);
        }
    }

    public void updateAndApproveSDDBlockedTicket_dev(String cookie, String actualClientId, int ticketId) {
        if(actualTypeName.equals("SDD check") && clientStateName.equals("Blocked")){
            //client_clientId_update.setId(Integer.parseInt(String.valueOf(clientId)));
            //client_clientId_update.setMainPhone(380685448615l);
            //client_clientId_update.setFirstName("Pavel");
            //client_clientId_update.setLastName("Burinsky");
            //client_clientId_update.setBirthDate("04.09.1992");
            client_clientId_update.setEmailIsVerified(false);
            client_clientId_update.setStateId(1);
            client_clientId_update.setStateName("Active");
            client_clientId_update.setCurrencyId(currencyId);
            client_clientId_update.setCurrencyCode("PLN");
            client_clientId_update.setLangId(1);
            client_clientId_update.setLangCode("eng");
            client_clientId_update.setLangName("English");
            client_clientId_update.setPhotoIdTypeId(1);
            client_clientId_update.setPhotoIdTypeName("Passport");
            client_clientId_update.setPhotoIdNo(234234324324l);
            client_clientId_update.setPhotoIdCountryId(countryId);
            client_clientId_update.setPhotoIdCountryName("Poland");
            client_clientId_update.setGender("M");
            client_clientId_update.setDdStatus("PSDD");
            client_clientId_update.setCardHolderName("Pavel Burinsky");
            client_clientId_update.setIdentifyCode(13124244234l);
            client_clientId_update.setClientType("I");
            client_clientId_update.setSite(Site.DIPOCKET.toString());
            client_clientId_update.setRegisteredAddrAsMail(true);
            client_clientId_update.setResidenceCountryId(countryId);
            client_clientId_update.setFeeTariffPlanId(1);
            client_clientId_update.setFeeTariffPlanName("EUR - standard");
            //client_clientId_update.setAge(30);
            client_clientId_update.setMigrated(false);
            client_clientId_update.setSkippedReg(false);
            String json = gson.toJson(client_clientId_update);

            given()
                    .log().uri().log().headers().log().body()
                    //.config(configTimeout)
                    .baseUri("https://support.dipocket.dev")
                    .basePath("BOServices")
                    .contentType("application/json")
                    .pathParam("clientId", actualClientId)
                    .header("bo-auth-token", 123456)
                    .cookie(cookie)
                    .when()
                    .body(json)
                    .post("/v1/client/{clientId}/update")
                    .then().log().all()
                    .statusCode(200);

            given()
                    .log().uri().log().headers().log().body()
                    //.config(configTimeout)
                    .baseUri("https://support.dipocket.dev")
                    .basePath("BOServices")
                    .contentType("application/json")
                    .pathParam("clientId", actualClientId)
                    .header("bo-auth-token", 123456)
                    .queryParam("ticketId", ticketId)
                    .cookie(cookie)
                    .post("/v1/client/{clientId}/approveSDD")
                    .then().log().all()
                    .statusCode(200);
        }
    }

    public void checkUserRolesId(User_roles[] user_roles, String id) {
        for(int i = 0; i < user_roles.length; i++){
            int length = user_roles.length-1;
            System.out.println(user_roles[i].getId());
            if(user_roles[i].getId().equals(id)){
                System.out.println("Actual: " + user_roles[i].getId() + " Expected: " + id);
                Assert.assertEquals(user_roles[i].getId(), id);
                break;
            } if(length == i){
                Assert.fail(id + " is not visible");
            }
        }
    }

    public boolean isUserRolesIdExist(User_roles[] user_roles, String id) {
        boolean bool = false;
        for(int i = 0; i < user_roles.length; i++){
            int length = user_roles.length-1;
            System.out.println(user_roles[i].getId());
            if(user_roles[i].getId().equals(id)){
                System.out.println("Actual: " + user_roles[i].getId() + " Expected: " + id);
                //Assert.assertEquals(user_roles[i].getId(), id);
                bool = true;
                break;
            } if(length == i){
                 bool = false;
            }
        }
        return bool;
    }

    public boolean isUserRolesNameExist(User_roles[] user_roles, String name) {
        boolean bool = false;
        for(int i = 0; i < user_roles.length; i++){
            int length = user_roles.length-1;
            System.out.println(user_roles[i].getName());
            if(user_roles[i].getName().equals(name)){
                System.out.println("Actual: " + user_roles[i].getName() + " Expected: " + name);
                //Assert.assertEquals(user_roles[i].getId(), id);
                bool = true;
                break;
            } if(length == i){
                bool = false;
            }
        }
        return bool;
    }

    public static void checkUserRolesName(User_roles[] user_roles, String name) {
        for(int i = 0; i < user_roles.length; i++){
            int length = user_roles.length-1;
            System.out.println(user_roles[i].getName());
            if(user_roles[i].getName().equals(name)){
                System.out.println("Actual: " + user_roles[i].getName() + " Expected: " + name);
                Assert.assertEquals(user_roles[i].getName(), name);
                break;
            } if(length == i){
                Assert.fail(name + " is not visible");
            }
        }
    }

    public boolean isAccountClientIdExist(Account_client[] account_clients, int id){
        boolean bool = false;
        for(int i = 0; i < account_clients.length; i++){
            int length = account_clients.length-1;
            System.out.println(account_clients[i].getId());
            if(account_clients[i].getId() == id){
                System.out.println("Actual: " + account_clients[i].getId() + " Expected: " + id);
                //Assert.assertEquals(user_roles[i].getId(), id);
                bool = true;
                break;
            } if(length == i){
                bool = false;
            }
        }
        return bool;
    }

    public int getLastIdFromResponse(Response res) {
        JsonPath jsonPathEvaluator = res.jsonPath();
        List<Integer> id = jsonPathEvaluator.get("id");
        int size = id.size() - 1;
        int lastId = id.get(size);
        return lastId;
    }

//    public boolean isAccountClientAccountNameExist(Account_client[] account_clients, String name){
//        boolean bool = false;
//        String a = "AccountName";
//        for(int i = 0; i < account_clients.length; i++){
//            int length = account_clients.length-1;
//            System.out.println(account_clients[i].getId());
//            if(account_clients[i].getAccountName().equals(name)){
//                System.out.println("Actual: " + account_clients[i].getAccountName() + " Expected: " + name);
//                //Assert.assertEquals(user_roles[i].getId(), id);
//                bool = true;
//                break;
//            } if(length == i){
//                bool = false;
//            }
//        }
//        return bool;
//    }
//
//    public static boolean isAccountClientAccountNameExist2(Runnable f1, Account_client[] account_clients, String name){
//        boolean bool = false;
//        //f1.run();
//        for(int i = 0; i < account_clients.length; i++){
//            int length = account_clients.length-1;
//            System.out.println(account_clients[i].getAccountName());
//            if(account_clients[i].getAccountName().equals(name)){
//                System.out.println("Actual: " + account_clients[i].getAccountName() + " Expected: " + name);
//                //Assert.assertEquals(user_roles[i].getId(), id);
//                bool = true;
//                break;
//            } if(length == i){
//                bool = false;
//            }
//        }
//        return bool;
//    }
//
//    @FunctionalInterface
//    public interface BiFunction<T, U, R> {
//
//        R apply(T t, U u);
//
//    }
//
//
//    public static void funcR(Runnable f1) {
//        f1.run();
//    }
//
//    public static void f() {
//        System.out.println("123");
//    }
//
//
//    public static long sum(long a, long b) {
//        return a + b;
//    }
//
//    private static void func(BiFunction<Long, Long, Long> f1) {
//        System.out.println(f1.apply(1L, 2L));
//    }
//
//    public static void main(String[] args) {
//        func(BOHelper::sum);
//    }
//
//    public boolean isAccountClientAccountNameExist3(Account_client[] account_clients, String name){
//        boolean bool = false;
//        for(int i = 0; i < account_clients.length; i++){
//            int length = account_clients.length-1;
//            System.out.println(account_clients[i].getAccountName());
//            if(account_clients[i].getAccountName().equals(name)){
//                System.out.println("Actual: " + account_clients[i].getAccountName() + " Expected: " + name);
//                //Assert.assertEquals(user_roles[i].getId(), id);
//                bool = true;
//                break;
//            } if(length == i){
//                bool = false;
//            }
//        }
//
//        System.out.println(BOHelper.
//                mergeThings("Hello ", "World!", BOHelper::appendStrings));
//        return bool;
//    }
//
//    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
//        return merger.apply(a, b);
//    }
}
