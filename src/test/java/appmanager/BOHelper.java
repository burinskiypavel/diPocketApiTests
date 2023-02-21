package appmanager;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.bo.User_roles;
import model.bo.boClient.Account_client;
import org.testng.Assert;
import requests.bo.BORequests;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class BOHelper extends HelperBase {

    BORequests boRequests = new BORequests();
    int ticketId = 0;
    String actualTypeName = null;
    String actualClientId = null;

    public int takeSDDTicketFromTest(String cookie, String sms, String clientId, String date) {
        //int ticketId = 0;
        //String actualTypeName = null;
        //String actualClientId = null;

        int count = 0;
        for(int i = 0; i < 27; i++) {
            count++;
            Response res = boRequests.boServices_v1_ticket_take_test(cookie, sms);
            String response = res.then().extract().response().asString();

            JsonPath js = new JsonPath(response);
            ticketId = js.getInt("id");
            actualTypeName = js.getString("typeName");
            actualClientId = js.getString("clientId");

            if(actualTypeName.equals("SDD check") && actualClientId.equals(clientId)){
                break;
            }

            if(!actualTypeName.equals("SDD check")){
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

            if(!actualTypeName.equals("FDD check")){
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
