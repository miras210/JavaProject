package com.company.database;

import com.company.entities.Company;
import com.company.entities.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBAddProject {
    private static Connection con = DBConnect.getInstance().getCon();

    public static int addProject(Company c, Project p) {
        try {
            int comp_id = DBFunctions.getId("company_id", "company", "company_name", c.getCompName());
            PreparedStatement stmt = con.prepareStatement("INSERT INTO projects(project_name, project_cost, company) VALUES (?, ?, ?)");
            stmt.setString(1, p.getProjectName());
            stmt.setInt(2, p.getProjectCost());
            stmt.setInt(3, comp_id);
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }
}
