package com.company.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBFunctions {
    private static Connection con = DBConnect.getInstance().getCon();

    public static int getId(String idField, String tableName, String nameField, String val) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT " + idField + " FROM "+ tableName +" WHERE "+ nameField +" = ?");
            stmt.setString(1, val);
            ResultSet rs = stmt.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }
            return id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static String getFromId(String valField, String tableName, String idField, int val) {
        String res = "";
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT " + valField + " FROM "+ tableName +" WHERE "+ idField +" = ?");
            stmt.setInt(1, val);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                res = rs.getString(1);
            }
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

}
