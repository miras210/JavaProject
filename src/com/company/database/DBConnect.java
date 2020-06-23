package com.company.database;

import java.sql.*;


//Singletone pattern
public class DBConnect {
    private static DBConnect dbcon;
    private Connection con;

    private DBConnect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javalab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static DBConnect getInstance() {
        if (dbcon == null) {
            dbcon = new DBConnect();
        }
        return dbcon;
    }

    public Connection getCon() {
        return con;
    }

}
