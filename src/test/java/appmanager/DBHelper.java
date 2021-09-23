package appmanager;

import java.sql.*;

public class DBHelper extends HelperBase {
    public String getSMSCodeFromDB(String number, final String site) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        //String query = "select * from VERIFYPHONECODE where PHONE = '"+number+"' and SITE = 'DIPOCKET'";
        String query = "select * from VERIFYCODE where SRCID  = '" + site + ":" +number+"'";

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

    public void deleteClientFromDB(String number, final String site) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'" + site + "',p_Phone=>'" +number+"')}");
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

    public String getClientDeviceFromDB(String number, String uuid, String site) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select ID from CLIENTDEVICE\n" +
                "where uuid = '"+uuid+"'\n" +
                "and clientid = (select id from client where MAINPHONE = '"+number+ "' and site = '" + site + "')";

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

    public String getLoginSMSFromDB(String number, String uuid, String site) throws ClassNotFoundException, SQLException {
        String clienDevice = getClientDeviceFromDB(number, uuid, site);

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

    public void unblockClientFromBOFromDBTelenor(String clientID) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKB_CLIENTPROFILE.UNBLOCKCLIENT(p_Username=>'DIPCBO1',p_ClientID=>" + clientID + ",p_UnblockReason=>'test',p_TicketID=>null)}");
        myCall.executeUpdate();

        Statement stmt = connection.createStatement();

        ResultSet rs2= stmt.executeQuery(query2);

        connection.close();
    }

    public void blockClientFromBOFromDBTelenor(String clientID) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKB_CLIENTPROFILE.BLOCKCLIENT(p_Username=>'DIPCBO1',p_ClientID=>" + clientID + ",p_BlockReason=>'test',p_TicketID=>null)}");
        myCall.executeUpdate();

        Statement stmt = connection.createStatement();

        ResultSet rs2= stmt.executeQuery(query2);

        connection.close();
    }

    public String getTelenorTokenFromDB() throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select t.*, t.rowid from gps_card t\n" +
                "where cardcreatedat is not null\n" +
                "order by cardcreatedat desc";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String publicToken = null;
        while (rs.next()){
            if(rs.isFirst()){
                String id = rs.getString(1);
                String stateId = rs.getString(2);
                String accountId = rs.getString(3);
                publicToken = rs.getString(14);


                System. out.println("id: " + id+" stateId: " + stateId + " accountId: " + accountId + " publicToken: " + publicToken);
                break;
            }

        }
        con.close();
        return publicToken;
    }

    public String getClientIdFromDB(String email, String site) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select ID from Client Where EMAIL = '"+email+ "' and Site = '" + site + "'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String id = null;
        while (rs.next()){
                 id = rs.getString(1);

                System. out.println("id: " + id);
                break;
        }
        con.close();
        return id;
    }

    public int getClientIdFromDB2(String email, String site) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select ID from Client Where EMAIL = '"+email+ "' and Site = '" + site + "'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        int id = 0;
        while (rs.next()){
            id = rs.getInt(1);

            System. out.println("id: " + id);
            break;
        }
        con.close();
        return id;
    }

    public String getLangIdFromDB(String email, final String site) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select LANGID from Client Where EMAIL = '"+email+ "' and Site = '" + site + "'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String langId = null;
        while (rs.next()){
            langId = rs.getString(1);

            System. out.println("langId: " + langId);
            break;
        }
        con.close();
        return langId;
    }

    public void updateClientLanguageFromDB(String email, String langId, String site) throws SQLException, ClassNotFoundException {
        String currentLangId = getLangIdFromDB(email, site);

        if(!currentLangId.equals(langId)){
            System.out.println("currentLangId and langId are not equals!");

            String id = getClientIdFromDB(email, site);

            String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            String query = "update Client set LANGID = "+langId+" where ID = "+id+ " and Site = '" + site + "'";
            String commit = "commit";

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            Statement stmt = con.createStatement();

            stmt.executeQuery(query);
            stmt.executeQuery(commit);
            con.close();
        }
        else {
            System.out.println("currentLangId and langId are equals!");
        }
    }

    public String getCurrentEmailFromDB(String email, String site) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select * from Client where email = '"+email+"' and site = '"+site+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        String currrentEmail = null;
        while (rs.next()){
            currrentEmail = rs.getString(6);

            System. out.println("email: " + currrentEmail);
            break;
        }
        con.close();
        return currrentEmail;
    }

    public void updateEmailForTelenorFromDB(String email, String site, String newEmail, String phone) throws SQLException, ClassNotFoundException {
        String currentEmail = getCurrentEmailFromDB(email, site);

        if(currentEmail.equals(email)){
            System.out.println("currentEmail and email are equals!");

            String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            String query = "update Client set EMAIL = '"+newEmail+"' where MAINPHONE = '"+phone+"'";
            String commit = "commit";

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(dbUrl, username, password);
            Statement stmt = con.createStatement();

            stmt.executeQuery(query);
            stmt.executeQuery(commit);
            con.close();
        }
        else {
            System.out.println("currentEmail and email are not equals!");
        }
    }

    public int getClientStateIDFromDBTelenor(String phone, String site) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select STATEID from client  where MAINPHONE = '"+phone+"' and site = '"+site+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        int stateID = 0;
        while (rs.next()){
            stateID = rs.getInt(1);

            System. out.println("stateID : " + stateID);
            break;
        }
        con.close();
        return stateID;
    }

    public boolean iSClientExistInDB(String phone, String site) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select * from client  where MAINPHONE = '"+phone+"' and site = '"+site+"'";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery(query);

        int id = 0;
        int mainPhone = 0;
        boolean bool = false;
        String email = null;
        while (rs.next()){
            id = rs.getInt(1);
            mainPhone = rs.getInt(5);
            email = rs.getString(6);

            //System. out.println("mainPhone : " + mainPhone);
            System. out.println("email : " + email);
            System. out.println("id : " + id);
            break;
        }
        con.close();
//        if(mainPhone == 0){
//            return bool;
//        }

        if(id > 0){
            bool = true;
            return bool;
        }
        return bool;
    }
}
