package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnector {
    public static boolean addUser(YeetUpUser user) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://db-workshop.public-dev.zuto.cloud/bootcamp3",
                    "bootcamp3", "TelephoneWeek");

            if (con != null) {
                Statement stmt = con.createStatement();
                stmt.execute("insert into Users(forename, surname, email, password, subscribe) values("+
                        user.getForename() + ", " + user.getSurname() + ", "+ user.getEmail() + ", "+
                        user.getPassword() + ", "+ user.isSubscribe() + ", " + ")");
            }

            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
