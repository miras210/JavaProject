package com.company.entities;

import java.util.ArrayList;

public class Project implements Working {
    private String projectName;
    private int projectCost;
    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public Project(String projectName, int projectCost) {
        this.projectName = projectName;
        this.projectCost = projectCost;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectCost() {
        return projectCost;
    }

    public void setProjectCost(int projectCost) {
        this.projectCost = projectCost;
    }

    public void addEmployee(Employee e) {
        employees.add(e);
        projectCost += e.getSalary();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void getProjectEmployees() {
        for (Employee e : employees) {
            System.out.print("---" + e.getName() + ": salary = " + e.getSalary() + ", ");
            e.work();
        }
    }

    @Override
    public void work() {
        System.out.println(getProjectName() + ": cost = " + getProjectCost() + ", list of employees:");
        getProjectEmployees();
    }
}
