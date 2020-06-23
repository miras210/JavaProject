package com.company.database;

import com.company.entities.Developer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBAddDeveloper {
    private static Connection con = DBConnect.getInstance().getCon();
    public static int addDeveloper(Developer thisEmp) {
        try {
            int emp_id = DBFunctions.getId("employee_id", "employees", "employee_name", thisEmp.getName());
            String type = "";
            String level = "";
            switch(thisEmp.getType()) {
                case FRONTEND:
                    type = "FRONTEND";
                    break;
                case BACKEND:
                    type = "BACKEND";
                    break;
            }

            switch (thisEmp.getLevel()) {
                case JUNIOR:
                    level = "JUNIOR";
                    break;
                case MIDDLE:
                    level = "MIDDLE";
                    break;
                case SENIOR:
                    level = "SENIOR";
                    break;
                case TEAM_LEAD:
                    level = "TEAM_LEAD";
                    break;
            }

            int type_id = DBFunctions.getId("developer_type_id", "devtype", "type", type);
            int level_id = DBFunctions.getId("developer_level_id", "devlevel", "level", level);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO programmers(programmer_id, programming_lang, developer_type_id, developer_level_id) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, emp_id);
            stmt.setString(2, thisEmp.getProgrammingLanguage());
            stmt.setInt(3, type_id);
            stmt.setInt(4, level_id);
            stmt.executeUpdate();

            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
