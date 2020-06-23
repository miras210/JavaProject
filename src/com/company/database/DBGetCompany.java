package com.company.database;

import com.company.entities.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBGetCompany {
    private static Connection con = DBConnect.getInstance().getCon();

    public static Company getCompany(String comp_name) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT company_id FROM company WHERE company_name = ?");
            stmt.setString(1, comp_name);
            ResultSet rs = stmt.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = rs.getInt(1);
            }

            stmt = con.prepareStatement("SELECT project_name FROM projects WHERE company = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Company c = new Company(comp_name);
            while (rs.next()) {
                c.addProject(DBGetProject.getProjectInfo(rs.getString(1)));
            }
            return c;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
