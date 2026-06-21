package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/childsafetys",
                    "root",
                    "mskhan@952863");

            System.out.println("Connected Successfully");

        } catch (Exception e) {

            System.out.println("ERROR OCCURRED");
            e.printStackTrace();

        }

        return con;
    }
}