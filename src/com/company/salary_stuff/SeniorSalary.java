package com.company.salary_stuff;

public class SeniorSalary extends MiddleSalary implements Salary {
    @Override
    public int salary() {
        return super.salary() + 300_000;
    }
}
