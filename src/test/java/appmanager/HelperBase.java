package appmanager;

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

    public static void waiter(int sec) throws InterruptedException {
        int second = sec * 1000;
        Thread.sleep(second);
    }
}
