import java.sql.*;

public class BaseTest {

    public String getSMSCodeFromDB(String number) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";
        String username = "Dipocket";
        String password = "c67";
        //Querry to Execute
        String query = "select * from VERIFYPHONECODE where PHONE = '"+number+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        String smsCode = null;
        while (rs.next()){
            String numberFromDB = rs.getString(1);
            smsCode = rs.getString(2);

            System. out.println(numberFromDB+"  "+smsCode);
        }
        // closing DB Connection
        con.close();
        return smsCode;
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

    public void deleteClientFromDB(String number) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";

        //Database Username
        String username = "Dipocket";
        String password = "c67";

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'DIPOCKET',p_Phone=>'"+number+"')}");
        myCall.executeUpdate();

        //Create Statement Object
        Statement stmt = connection.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs2= stmt.executeQuery(query2);

        // closing DB Connection
        connection.close();
    }

    public String getClientDeviceFromDB(String number) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";
        String username = "Dipocket";
        String password = "c67";
        //Querry to Execute
        String query = "select ID from CLIENTDEVICE\n" +
                "where uuid = 'eGy9q-lDQBGKz-bgdz1U6q'\n" +
                "and clientid = (select id from client where MAINPHONE = '"+number+"' and site = 'DIPOCKET')";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        String clientDevice = null;
        while (rs.next()){
            clientDevice = rs.getString(1);

            System. out.println("Client device: " +clientDevice);
        }
        // closing DB Connection
        con.close();
        return clientDevice;
    }

    public String getLoginSMSFromDB(String number) throws ClassNotFoundException, SQLException {
        String clienDevice = getClientDeviceFromDB(number);

        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";
        String username = "Dipocket";
        String password = "c67";
        //Querry to Execute
        String query = "select CODE from VERIFYCODE where SRCID = '"+clienDevice+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        String smsLoginCode = null;
        while (rs.next()){
            smsLoginCode = rs.getString(1);

            System. out.println("smsLoginCode: " +smsLoginCode);
        }
        // closing DB Connection
        con.close();
        return smsLoginCode;
    }
}
