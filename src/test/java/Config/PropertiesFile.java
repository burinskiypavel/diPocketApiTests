package Config;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        getProperties();
        setProperties();
        getProperties();

    }

    public static void getProperties() throws IOException {

        InputStream input = new FileInputStream(projectPath+"/src/test/java/Config/config.properties");
        prop.load(input);
        String browser = prop.getProperty("browser");
        System.out.println(browser);
    }

    public static void setProperties() throws IOException {
        OutputStream output = new FileOutputStream(projectPath+"/src/test/java/Config/config.properties");
        prop.setProperty("browser", "firefox");
        prop.store(output, null);
    }
}
