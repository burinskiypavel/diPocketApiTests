package base;

import java.io.FileInputStream;

public class ApplicationManager {
    static java.util.Properties prop = new java.util.Properties();
    static String projectPath = System.getProperty("user.dir");

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

//    public MailHelper mail(){
//        if(mailHelper == null){
//            mailHelper = new MailHelper(this);
//        }
//        return mailHelper;
//    }
}
