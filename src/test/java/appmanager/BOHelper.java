package appmanager;

import model.bo.User_roles;
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

    public void checkUserRolesName(User_roles[] user_roles, String name) {
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
}
