package appmanager;

import java.sql.*;

public class DBHelper extends HelperBase {
    public String getSMSCodeFromDB(String number) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        //String query = "select * from VERIFYPHONECODE where PHONE = '"+number+"' and SITE = 'DIPOCKET'";
        String query = "select * from VERIFYCODE where SRCID  = 'DIPOCKET:"+number+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String smsCode = null;
        while (rs.next()){
            String numberFromDB = rs.getString(1);
            smsCode = rs.getString(2);

            System. out.println("phone: " + numberFromDB+" smsCode: "+smsCode);
        }
        con.close();
        return smsCode;
    }

    public String getSMSCodeFromDBTelenor(String number) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        //String query = "select * from VERIFYPHONECODE where PHONE = '"+number+"' and SITE = 'TELENOR'";
        String query = "select * from VERIFYCODE where SRCID  = 'TELENOR:"+number+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String smsCode = null;
        while (rs.next()){
            if(rs.isFirst()){
                String numberFromDB = rs.getString(1);
                smsCode = rs.getString(2);

                System. out.println("phone: " + numberFromDB+" smsCode: "+smsCode);
            }

        }
        con.close();
        return smsCode;
    }

    public void deleteClientFromDB(String number) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'DIPOCKET',p_Phone=>'"+number+"')}");
        myCall.executeUpdate();

        Statement stmt = connection.createStatement();

        ResultSet rs2= stmt.executeQuery(query2);

        connection.close();
    }

    public void deleteClientFromDBTelenor(String number) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'TELENOR',p_Phone=>'"+number+"')}");
        myCall.executeUpdate();

        Statement stmt = connection.createStatement();

        ResultSet rs2= stmt.executeQuery(query2);

        connection.close();
    }

    public String getClientDeviceFromDB(String number, String uuid) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select ID from CLIENTDEVICE\n" +
                "where uuid = '"+uuid+"'\n" +
                "and clientid = (select id from client where MAINPHONE = '"+number+"' and site = 'DIPOCKET')";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String clientDevice = null;
        while (rs.next()){
            clientDevice = rs.getString(1);

            System. out.println("Client device: " +clientDevice);
        }
        con.close();
        return clientDevice;
    }

    public String getLoginSMSFromDB(String number, String uuid) throws ClassNotFoundException, SQLException {
        String clienDevice = getClientDeviceFromDB(number, uuid);

        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select CODE from VERIFYCODE where SRCID = '"+clienDevice+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String smsLoginCode = null;
        while (rs.next()){
            smsLoginCode = rs.getString(1);

            System. out.println("smsLoginCode: " +smsLoginCode);
        }
        con.close();
        return smsLoginCode;
    }

    public void deleteClientDeviceFromDB(String clientDevice) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "delete from clientdevice where uuid = '"+clientDevice+"'";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);
        con.close();
    }

    public String getTelenorStateIdFromDB() throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select t.*, t.rowid from CIB_OUT_TRAN t\n" +
                "where BENEFNAME = 'QA Test'\n" +
                "order by id desc";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String stateId = null;
        while (rs.next()){
            if(rs.isFirst()){
                String id = rs.getString(1);
                String tranId = rs.getString(2);
                stateId = rs.getString(3);

                System. out.println("id: " + id+" tranId: " + tranId + " stateId: " + stateId);
            }

        }
        con.close();
        return stateId;
    }

    public void activateClientFromDBTelenor(String phone) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "update client set stateid = 1 where MAINPHONE = '"+phone+"' and site = 'TELENOR'";
        String commit = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        stmt.executeQuery(query);

        stmt.executeQuery(commit);
        con.close();
    }

    public void blockClientFromDBTelenor(String phone) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "update client set stateid = -1 where MAINPHONE = '"+phone+"' and site = 'TELENOR'";
        String commit = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        stmt.executeQuery(query);

        stmt.executeQuery(commit);
        con.close();
    }

    public void unblockClientFromBOFromDBTelenor() throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKB_CLIENTPROFILE.UNBLOCKCLIENT(p_Username=>'DIPCBO1',p_ClientID=>31751,p_UnblockReason=>'test',p_TicketID=>null)}");
        myCall.executeUpdate();

        Statement stmt = connection.createStatement();

        ResultSet rs2= stmt.executeQuery(query2);

        connection.close();
    }
}
