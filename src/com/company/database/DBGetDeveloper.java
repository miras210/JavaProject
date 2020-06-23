package com.company.database;

import com.company.entities.Developer;
import com.company.enums.JobTitle;
import com.company.enums.Levels;
import com.company.enums.Types;

import java.sql.*;

public class DBGetDeveloper {
    private static Connection con = DBConnect.getInstance().getCon();

    public static Developer getDeveloper(int id, String name) {
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM programmers WHERE programmer_id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            int dev_type_id = 0;
            int dev_level_id = 0;
            String prog_lang = "";
            while(rs.next()) {
                dev_type_id = rs.getInt(4);
                dev_level_id = rs.getInt(5);
                prog_lang = rs.getString(3);
            }
            Types type = null;
            Levels level = null;
            switch (DBFunctions.getFromId("type", "devtype", "developer_type_id", dev_type_id)) {
                case "BACKEND":
                    type = Types.BACKEND;
                    break;
                case "FRONTEND":
                    type = Types.FRONTEND;
                    break;
            }
            switch (DBFunctions.getFromId("level", "devlevel", "developer_level_id", dev_level_id)) {
                case "JUNIOR":
                    level = Levels.JUNIOR;
                    break;
                case "MIDDLE":
                    level = Levels.MIDDLE;
                    break;
                case "SENIOR":
                    level = Levels.SENIOR;
                    break;
                case "TEAM_LEAD":
                    level = Levels.TEAM_LEAD;
                    break;
            }
            Developer dev = new Developer(name, JobTitle.DEVELOPER, prog_lang, type, level);

            return dev;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
