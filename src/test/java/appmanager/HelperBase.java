package appmanager;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileInputStream;

public class HelperBase {
    public static java.util.Properties prop = new java.util.Properties();
    //static java.util.Properties prop = new java.util.Properties();
    static String projectPath = System.getProperty("user.dir");
    //public String pan = null;
    //public String TDSBaseUrl = null;

    //private MailHelper mailHelper;

    public java.util.Properties loadDataFromConfigFile(){
        FileInputStream input = null;
        try {
            input = new FileInputStream("src\\test\\java\\config\\config.properties");
            prop.load(input);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return prop;
    }

    public String generateRandomString(int amount){
        String randomString =  RandomStringUtils.random(amount, true, true);
        return randomString;
    }
}
