package com.company.database;

import com.company.entities.Developer;
import com.company.entities.Employee;
import com.company.entities.Project;
import com.company.entities.ProjectManager;
import com.company.enums.JobTitle;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBGetEmployee {
    private static Connection con = DBConnect.getInstance().getCon();

    public static Pair <Employee, String> getEmployee(String name) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM employees WHERE employee_name = ?");
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            int emp_id = 0;
            int emp_job_id = 0;
            int emp_proj_id = 0;
            while(rs.next()) {
                emp_id = rs.getInt(1);
                emp_job_id = rs.getInt(3);
                emp_proj_id = rs.getInt(4);
            }

            JobTitle job = DBFunctions.getFromId("job_title", "jobs", "job_id", emp_job_id).equals("MANAGER") ? JobTitle.MANAGER : JobTitle.DEVELOPER;
            String proj_name = DBFunctions.getFromId("project_name", "projects", "project_id", emp_proj_id);

            if (job == JobTitle.MANAGER) {
                ProjectManager pm = new ProjectManager(name, job);
                return new Pair<>(pm, proj_name);
            } else {
                Developer dev = DBGetDeveloper.getDeveloper(emp_id, name);
                return new Pair<>(dev, proj_name);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
