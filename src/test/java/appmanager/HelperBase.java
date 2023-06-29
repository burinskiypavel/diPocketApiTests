package appmanager;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

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
            input = new FileInputStream("/Work/DiPocket/API/ApiTests/config2.properties");
            prop.load(input);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return prop;
    }

    public static String cutText(String text, int begin, int end){
        String cutText = text.substring(begin, end);
        return cutText;
    }

    public static String cutText(String text, int begin){
        String cutText = text.substring(begin);
        return cutText;
    }

    public String generateRandomString(int amount){
        String randomString =  RandomStringUtils.random(amount, true, true);
        return randomString;
    }

    public void storeDataToTheFile(String path, String text){
        try(FileWriter writer = new FileWriter(path, false))
        {
            writer.write(text);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public String getDateFromFileDef(String path) {
        String table = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {

            String line;
            while ((line = br.readLine()) != null) {
                table = line;
                //table.add("\r\n");


                //StringBuilder result = new StringBuilder();
                //  result.append('\n').append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return table;
    }

    public static String readFileReturnString(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String data = null;
            String d;
            while ((d = br.readLine()) != null) {
                data = d;
            }
            return data;
        }
    }
}