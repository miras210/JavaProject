package com.company.salary_stuff;

import com.company.enums.Levels;
import com.company.enums.Types;

public class SalaryStrategy {
    public static int getSalary(Types type, Levels level) {
        int salary = 0;
        switch (type) {
            case BACKEND:
                salary = new BackSalary().salary();
                break;
            case FRONTEND:
                salary = new FrontSalary().salary();
                break;
        }

        switch (level) {
            case JUNIOR:
                salary += new JuniorSalary().salary();
                break;
            case MIDDLE:
                salary += new MiddleSalary().salary();
                break;
            case SENIOR:
                salary += new SeniorSalary().salary();
                break;
            case TEAM_LEAD:
                salary += new TeamLeadSalary().salary();
                break;
        }
        return salary;
    }
}
