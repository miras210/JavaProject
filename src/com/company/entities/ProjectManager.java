package com.company.entities;

import com.company.enums.JobTitle;
import com.company.salary_stuff.PMSalary;

public class ProjectManager extends Employee {
    private static int PMSalary = new PMSalary().salary();
    public ProjectManager(String name, JobTitle jobTitle) {
        super(name, jobTitle);
        setSalary(PMSalary);
    }

    @Override
    public void work() {
        System.out.println("I'm responsible for managing the project");
    }
}
