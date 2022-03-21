package appmanager;

import model.bo.User_roles;
import model.bo.boClient.Account_client;
import org.testng.Assert;

public class BOHelper extends HelperBase {

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
