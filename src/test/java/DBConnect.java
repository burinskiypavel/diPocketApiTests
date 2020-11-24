import org.testng.annotations.Test;

import java.sql.*;

public class DBConnect {

//    @Test
//    public void DB_Test() throws ClassNotFoundException, SQLException {
//
//        //Connection con = DriverManager.getConnection(dbUrl,username,password);
//        String dbUrl = "jdbc:mysql://54.208.87.86:3306/RBDG";
//        //Database Username
//        String username = "php";
//        String password = "jjOoan1UVZpDBA5p5YHY";
//        //Querry to Execute
//        String query = "select * from PATRON LIMIT 20;";
//
//        Class.forName("com.mysql.jdbc.Driver");
//
//        //Create Connection to DB
//        Connection con = DriverManager.getConnection(dbUrl, username, password);
//
//        //Create Statement Object
//        Statement stmt = con.createStatement();
//
//        // Execute the SQL Query. Store results in ResultSet
//        ResultSet rs= stmt.executeQuery(query);
//
//        // While Loop to iterate through all data and print results
//        while (rs.next()){
//            String myName = rs.getString(1);
//            String myAge = rs.getString(2);
//
//            System. out.println(myName+"  "+myAge);
//        }
//        // closing DB Connection
//        con.close();
//    }

    @Test(enabled = false)
    public void DB_diPocketTest() throws ClassNotFoundException, SQLException {

        //Connection con = DriverManager.getConnection(dbUrl,username,password);
        String dbUrl = "jdbc:oracle:thin:@dipocket1.intranet/dip";
        //Database Username
        String username = "Dipocket";
        String password = "c67";
        //Querry to Execute
        String query = "select * from VERIFYPHONECODE where PHONE = '380685448615'";

        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl, username, password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String number = rs.getString(1);
            String smsCode = rs.getString(2);

            System. out.println(number+"  "+smsCode);
        }
        // closing DB Connection
        con.close();
    }

//    @Test
//    public void JDBCExampelOracle() throws SQLException {
//        /* Объявление используемого типа драйвера Oracle */
//        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
//            /* Создание соединения с базой данных для программы JDBC */
//            Connection conn =
//                    DriverManager.getConnection(
//                            "jdbc:oracle:thin:@dipocket1.intranet/dip:1521:aparna","dipocket","c67");
//            Statement stmt = conn.createStatement();
//            /* Передача запроса SQL и сохранение результатов в результирующем наборе rs */
//            ResultSet rs =
//                    stmt.executeQuery("select * from client");
//            /* Доступ к содержимому результирующего набора rs по строкам в цикле while */
//            while(rs.next()){
//                int number = rs.getInt(1);
//                String name= rs.getString(2);
//               // System.out.println(number+" "+name+" "+salary);
//            }
//            /* Закрытие результирующего набора JDBC и соединения с базой данных */
//            rs.close();
//            conn.close();
//    }

//    @Test
//    public void JDBCExampelOracleTest4() throws SQLException {
//        System.out.println("-------- Oracle JDBC Connection Testing ------");
//
//        try {
//
//            Class.forName("oracle.jdbc.OracleDriver");
//
//        } catch (ClassNotFoundException e) {
//
//            System.out.println("Where is your Oracle JDBC Driver?");
//            e.printStackTrace();
//            return;
//
//        }
//
//        System.out.println("Oracle JDBC Driver Registered!");
//
//        Connection connection = null;
//
//        try {
//
//            connection = DriverManager.getConnection(
//                    "jdbc:oracle:thin:@dipocket1.intranet/dip:1521:xe", "dipocket", "c67");
//
//        } catch (SQLException e) {
//
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//            return;
//
//        }
//
//        if (connection != null) {
//            System.out.println("You made it, take control your database now!");
//        } else {
//            System.out.println("Failed to make connection!");
//        }
//    }

}
