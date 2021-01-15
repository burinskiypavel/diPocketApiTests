package base;

import appmanager.ApplicationManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void beforeClass() {
        app.initStart();
    }

    @BeforeTest
    public void setUp(){
        app.init();
    }

    //    public void deleteClientFromDB2() throws SQLException, ClassNotFoundException {
//        //Connection con = DriverManager.getConnection(dbUrl,username,password);
//        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";
//        //Database Username
//        String username = "Dipocket";
//        String password = "c67";
//        //Querry to Execute
//        String query = "BEGIN\n" +
//                "PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'DIPOCKET',p_Phone=>'380685448615');\n" +
//                "END;";
//
//        String query2 = "commit";
//
//        Class.forName("oracle.jdbc.driver.OracleDriver");
//
//        //Create Connection to DB
//        Connection con = DriverManager.getConnection(dbUrl, username, password);
//
//        //Create Statement Object
//        Statement stmt = con.createStatement();
//
//        // Execute the SQL Query. Store results in ResultSet
//        ResultSet rs= stmt.executeQuery(query);
//        ResultSet rs2= stmt.executeQuery(query2);
//
//        // closing DB Connection
//        con.close();
//    }

}