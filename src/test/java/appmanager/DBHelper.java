package appmanager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DBHelper extends HelperBase {
    String nulll = null;

    public String getSMSCodeFromDB(String number, final String site, String dbEnvUrl) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ dbEnvUrl +"";
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

    public void deleteClientFromDB(String number, final String site, String envUrl) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ envUrl +"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String commit = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'" + site + "',p_Phone=>'" +number+"')}");
        myCall.executeUpdate();
        Statement stmt = connection.createStatement();
        stmt.executeQuery(commit);
        connection.close();
    }

    public void deleteClientFromDBTelenor(String number) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String commit = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKI_CLIENT.CLEARCLIENTBYPHONE(p_Site=>'TELENOR',p_Phone=>'"+number+"')}");
        myCall.executeUpdate();

        Statement stmt = connection.createStatement();
        stmt.executeQuery(commit);
        connection.close();
    }

    public String getClientDeviceFromDB(String number, String uuid, String site, String envUrl) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ envUrl +"";
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

    public String getLoginSMSFromDB(String number, String uuid, String site, String envUrl) throws ClassNotFoundException, SQLException {
        String clienDevice = getClientDeviceFromDB(number, uuid, site, envUrl);

        String dbUrl = "jdbc:oracle:thin:@"+ envUrl +"";
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

    public void deleteClientDeviceFromDB(String clientDevice, String envUrl) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ envUrl +"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query2 = "delete from clientdevice where uuid = '"+clientDevice+"'";
        String query = "DELETE FROM ClientDeviceLast WHERE LastDeviceid IN (SELECT id FROM clientdevice WHERE uuid = '"+clientDevice+"')";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        stmt.executeQuery(query2);
        stmt.executeQuery(commit);
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

    public String getClientIdFromTestDB(String email, String site) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
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
//        String currentNewEmail = getCurrentEmailFromDB(newEmail, site);
//        if(currentNewEmail.equals(newEmail)){
//            System.out.println("currentNewEmail not null!");
//
//            String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
//            String username = prop.getProperty("db.username");
//            String password = prop.getProperty("db.password");
//            String query = "update Client set EMAIL = '"+email+"' where MAINPHONE = '"+phone+"'";
//            String commit = "commit";
//
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            Connection con = DriverManager.getConnection(dbUrl, username, password);
//            Statement stmt = con.createStatement();
//
//            stmt.executeQuery(query);
//            stmt.executeQuery(commit);
//            con.close();
//        }

        String currentEmail = getCurrentEmailFromDB(email, site);

        if(email.equals(currentEmail)){
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

    public boolean isClientExistInDB(String phone, String site) throws SQLException, ClassNotFoundException {
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

    public String getRoleNameFromDB(String id) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM vb_userrole\n" +
                "WHERE ID = '" + id + "'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String roleName = null;
        while (rs.next()){
            roleName = rs.getString(2);

            System. out.println("roleName : " + roleName);
            break;
        }
        con.close();
        return roleName;
    }

    public boolean isRoleExistInDB(String roleID) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM vb_userrole\n" +
                "where ID = '" + roleID + "'";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String id = null;
        boolean bool = true;
        while (rs.next()){
            id = rs.getString(1);
            System. out.println("id : " + id);
            break;
        }
        con.close();

        if(Objects.equals(id, null)){
            bool = false;
            return bool;
        }
        return bool;
    }

    public void deleteBOUserFromDB(String user) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "delete from users where USERNAME = '" + user + "'";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        con.close();
    }

    public boolean isBOUserExistInDB(String userName) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select * from users where USERNAME = '" + userName + "'";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String usernameFromDB = null;
        boolean bool = true;
        while (rs.next()){
            usernameFromDB = rs.getString(1);
            System. out.println("usernameFromDB : " + usernameFromDB);
            break;
        }
        con.close();

        if(Objects.equals(usernameFromDB, null)){
            bool = false;
            return bool;
        }
        return bool;
    }

    public void deleteFeeTariffPlanDB(String id, final String name) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "delete from Feetariffplan where id = '" + id + "' and SNAME_ENG = '" + name + "'";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        con.close();
    }

    public String getFeeTariffPlanFromDB(String id) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select * from Feetariffplan where id = '"+id+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String feeTariffPlanName = null;
        while (rs.next()){
            feeTariffPlanName = rs.getString(2);

            System. out.println("FeeTariffPlan : " + feeTariffPlanName);
            break;
        }
        con.close();
        return feeTariffPlanName;
    }

    public void deleteLimitPlanFromDB(String id, String name) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "delete from Limitplan where ID = '" + id + "' and SNAME = '" + name + "'";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        con.close();
    }

    public String getLimitPlanFromDB(String id) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "select * from Limitplan where id = '"+id+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String LimitPlanName = null;
        while (rs.next()){
            LimitPlanName = rs.getString(2);

            System. out.println("LimitPlan : " + LimitPlanName);
            break;
        }
        con.close();
        return LimitPlanName;
    }

    public void updateClientPhoneFromDB(String phone, String id) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "update client set MAINPHONE = '"+phone+"' where ID = '"+id+"'";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        con.close();
    }

    public void updateClientEmailFromDB(String email, String id) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "update client set EMAIL = '"+email+"' where ID = '"+id+"'";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        con.close();
    }

    public String getBOLoginSMSCodeFromTestDB() throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM PUSHMSG p ORDER BY id DESC";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String message = null;
        while (rs.next()){
            message = rs.getString(12);

            System. out.println("Message : " + message);
            break;
        }
        con.close();
        return message;
    }

    public String getClientDDStatusFromTestDB(String clientId) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM CLIENT where id = '" + clientId + "'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String status = null;
        while (rs.next()){
            status = rs.getString(26);

            System. out.println("status : " + status);
            break;
        }
        con.close();
        return status;
    }

    public String getVirtualIBANFromTestDB() throws SQLException, ClassNotFoundException, InterruptedException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM LHV_EE_VIBAN_REQUEST levr ORDER BY id desc";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String vIban = null;
        int count = 0;
        while (rs.next()){
            vIban = rs.getString(3);

            while (vIban == null && count < 220){
                Thread.sleep(6000);
                rs= stmt.executeQuery(query);
                rs.next();
                vIban = rs.getString(3);
                count++;
            }

            System.out.println("count: " + count);
            System. out.println("vIban : " + vIban);
            break;
        }
        con.close();
        return vIban;
    }
    public int getLastVIbanIdFromLHV_EE_VIBAN_REQUESTFromTestDB() throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM LHV_EE_VIBAN_REQUEST levr ORDER BY id desc";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        int vIbanId = 0;
        while (rs.next()){
            vIbanId = rs.getInt(1);
            System. out.println("vIbanId : " + vIbanId);
            break;
        }
        con.close();
        return vIbanId;
    }

    public String getLastSCRIDFromLHV_EE_VIBAN_REQUESTFromTestDB() throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM LHV_EE_VIBAN_REQUEST levr ORDER BY id desc";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String srcid = null;
        while (rs.next()){
            srcid = rs.getString(7);
            System. out.println("srcid : " + srcid);
            break;
        }
        con.close();
        return srcid;
    }

    public String getvIbanStatusRequestFromTestDB() throws SQLException, ClassNotFoundException, InterruptedException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM LHV_EE_VIBAN_REQUEST levr ORDER BY id desc";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String statusRequest = null;
        int count = 0;
        while (rs.next()){
            statusRequest = rs.getString(10);

            while (statusRequest == null && count < 110){
                Thread.sleep(6000);
                rs= stmt.executeQuery(query);
                rs.next();
                statusRequest = rs.getString(10);
                count++;
            }

            System.out.println("count: " + count);
            System. out.println("statusRequest : " + statusRequest);
            break;
        }
        con.close();
        return statusRequest;
    }

    public List<String> getAllRow_FromLHV_EE_MASTERSITE_FromTestDB(String site, int indexOfRow) throws SQLException, ClassNotFoundException {
        List<String> rows = new ArrayList<>();

        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT * FROM LHV_EE_MASTERSITE lem WHERE CURRENCYID IN (978,826) and site = '"+site+"'";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String masterACCID = null;
        String columnSite = null;
        String countryId = null;
        String currencyId = null;
        int columnCount = 0;
        String columnName = null;
        String currentCollumn = null;
        int row = 0;
        while (rs.next()){
            row = rs.getRow();
            if(row != indexOfRow){
                continue;
            }
            System.out.println("row : " + row);
            //masterACCID = rs.getString(1);
            //columnSite = rs.getString(2);
            //countryId = rs.getString(3);
            //currencyId = rs.getString(4);

            ResultSetMetaData m = rs.getMetaData();
            columnCount = m.getColumnCount();
            //String s = String.valueOf(m.getScale(2));

            for(int i  = 1; i <= columnCount; i++){
                columnName = m.getColumnName(i);
                currentCollumn = rs.getString(i);

                String t = m.getColumnTypeName(i);

                System.out.println(columnName +" "+ currentCollumn);
                rows.add(currentCollumn);

            }


            //System.out.println("row : " + row);
            //System. out.println("masterACCID : " + masterACCID);
            //System. out.println("columnSite : " + columnSite);
            //System. out.println("countryId : " + countryId);
            //System. out.println("currencyId : " + currencyId);

            //rows.add(masterACCID);
            //rows.add(columnSite);
            //rows.add(countryId);
            //rows.add(currencyId);

            if(row == indexOfRow){
                break;
            }
        }
        con.close();
        return rows;
    }

    public List<String> getMasterIBAN_FromTestDB(int indexOfRow) throws SQLException, ClassNotFoundException {
        List<String> rows = new ArrayList<>();

        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "SELECT x.*,x.ROWID FROM DIPOCKET.LHV_EE_MASTERACC x";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery(query);

        String id = null;
        String account = null;
        String countryId = null;
        int row = 0;

        while (rs.next()){
            row = rs.getRow();
            if(row != indexOfRow){
                continue;
            }
            System.out.println("row : " + row);
            id = rs.getString(1);
            account = rs.getString(2);
            countryId = rs.getString(5);

            System. out.println("id : " + id);
            System. out.println("account : " + account);
            System. out.println("countryId : " + countryId);

            rows.add(id);
            rows.add(account);
            rows.add(countryId);

            if(row == indexOfRow){
                break;
            }
        }
        con.close();
        return rows;
    }

    public void createAccountFromTestDB(int clientID, int currencyId, String accountName) throws SQLException, ClassNotFoundException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        String query2 = "commit";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        CallableStatement myCall = connection.prepareCall("{call PKM_ACCOUNT.CREATEACCOUNT(?, ?, ?, ?, ?, ?, ?)}");

        myCall.registerOutParameter(1, Types.NUMERIC);
        myCall.setInt(2, clientID);
        myCall.setInt(3, currencyId);
        myCall.setString(4, accountName);
        myCall.setInt(5, 1);
        myCall.setInt(6, 1);
        myCall.setInt(7, 1);
        //myCall.setInt(2, clientID);

        myCall.executeUpdate();

        String name = myCall.getString(1);

        Statement stmt = connection.createStatement();

        ResultSet rs2= stmt.executeQuery(query2);

        connection.close();
    }

    public void updateClientIdintifyCodeFromTestDB(String idintifyCode, String id) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "update client set identifycode = "+idintifyCode+" where id = "+id+"";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        con.close();
    }

    public void updateClientCitizenshipCountryIdFromTestDB(int citizenshipcountryid, String id) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "update client set citizenshipcountryid = "+citizenshipcountryid+" where id = "+id+"";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        con.close();
    }

    public void updateAccountStateIdFromTestDB(int stateid, String clientid) throws ClassNotFoundException, SQLException {
        String dbUrl = "jdbc:oracle:thin:@"+ prop.getProperty("db.test.url")+"";
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");
        String query = "update account set stateid = "+stateid+" where clientid = "+clientid+"";
        String commit = "commit";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        stmt.executeQuery(commit);
        con.close();
    }
}