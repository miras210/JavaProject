package com.company.database;

import com.company.entities.Company;
import com.company.entities.Developer;
import com.company.entities.Employee;
import com.company.entities.Project;
import com.company.enums.JobTitle;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBAddEmployee {
    private static Connection con = DBConnect.getInstance().getCon();
    public static int addEmployee(Company c, Project p, Employee emp) {
        try {
            int proj_id = DBFunctions.getId("project_id", "projects", "project_name", p.getProjectName());
            int employee_job;
            String job_title = emp.getJobTitle() == JobTitle.MANAGER ? "MANAGER" : "DEVELOPER";
            employee_job = DBFunctions.getId("job_id", "jobs", "job_title", job_title);
            PreparedStatement stmt = con.prepareStatement("INSERT INTO employees(employee_name, employee_job, employee_project, salary) VALUES (?, ?, ?, ?)");
            stmt.setString(1, emp.getName());
            stmt.setInt(2, employee_job);
            stmt.setInt(3, proj_id);
            stmt.setInt(4, emp.getSalary());
            stmt.executeUpdate();

            if (emp.getJobTitle() == JobTitle.DEVELOPER) {
                DBAddDeveloper.addDeveloper((Developer)emp);
            }

            stmt = con.prepareStatement("UPDATE projects SET project_cost = project_cost + ? WHERE project_name=?");
            stmt.setInt(1, emp.getSalary());
            stmt.setString(2, p.getProjectName());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
