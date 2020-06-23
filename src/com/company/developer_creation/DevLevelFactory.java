package com.company.developer_creation;

import com.company.enums.Levels;

public class DevLevelFactory {
    public static DeveloperLevel createDevLevel(Levels level) {
        DeveloperLevel devLvl = null;
        switch(level) {
            case JUNIOR:
                devLvl = new JuniorDeveloper();
                break;
            case MIDDLE:
                devLvl = new MiddleDeveloper();
                break;
            case SENIOR:
                devLvl = new SeniorDeveloper();
                break;
            case TEAM_LEAD:
                devLvl = new TeamLead();
                break;
        }
        return devLvl;
    }
}
