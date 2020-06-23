package com.company.entities;

import com.company.enums.JobTitle;

public abstract class Employee implements Working {
    private String name;
    private JobTitle jobTitle;
    private int salary;

    public Employee(String name, JobTitle jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    protected void setSalary(int salary) {
        this.salary = salary;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public abstract void work();
}
