package com.company.salary_stuff;

public class MiddleSalary extends JuniorSalary implements Salary {
    @Override
    public int salary() {
        return super.salary() + 100_000;
    }
}
