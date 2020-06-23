package com.company.salary_stuff;

public class TeamLeadSalary extends SeniorSalary implements Salary {
    @Override
    public int salary() {
        return super.salary() + 200_000;
    }
}
