package com.company.database;

import com.company.entities.Employee;
import com.company.entities.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBGetProject {
    private static Connection con = DBConnect.getInstance().getCon();

    public static Project getProject(String proj_name) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT project_cost FROM projects WHERE project_name = ?");
            stmt.setString(1, proj_name);
            ResultSet rs = stmt.executeQuery();
            int proj_cost = 0;
            while(rs.next()) {
                proj_cost = rs.getInt(1);
            }
            Project p = new Project(proj_name, proj_cost);
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Project getProjectInfo(String proj_name) {
        try {
            Project p = getProject(proj_name);
            PreparedStatement stmt = con.prepareStatement("SELECT employee_name FROM employees WHERE employee_project = ?");
            stmt.setInt(1, DBFunctions.getId("project_id", "projects", "project_name", proj_name));
            ResultSet rs = stmt.executeQuery();
            Employee emp;
            while(rs.next()) {
                emp = DBGetEmployee.getEmployee(rs.getString(1)).getKey();
                p.addEmployee(emp);
            }

            Project p2 = getProject(proj_name);
            p.setProjectCost(p2.getProjectCost());
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
