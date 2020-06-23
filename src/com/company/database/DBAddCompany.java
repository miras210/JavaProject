
package com.company.database;

import com.company.entities.Company;
import com.company.entities.Employee;
import com.company.entities.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBAddCompany {
    private static Connection con = DBConnect.getInstance().getCon();

    public static int addFullCompany(Company c) {
        try {
            addCompany(c);

            for (Project p : c.getProjects()) {
                DBAddProject.addProject(c, p);

                for (Employee e : p.getEmployees()) {
                    DBAddEmployee.addEmployee(c, p, e);
                }
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static int addCompany(Company c) {
        try {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO company(company_name) VALUES (?)");
            stmt.setString(1, c.getCompName());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }

    }
}

