package com.company.entities;

import java.util.ArrayList;

public class Company implements Working {
    private String compName;
    private ArrayList<Project> projects = new ArrayList<Project>();

    public Company(String compName) {
        this.compName = compName;
    }

    public void addProject(String projName, int projCost) {
        Project p = new Project(projName, projCost);
        projects.add(p);
    }

    public void addProject(Project p) {
        projects.add(p);
    }

    public void addEmployee(String projectName, Employee e) {
        for (Project p: projects) {
            if (p.getProjectName().equals(projectName)) {
                p.addEmployee(e);
            }
        }
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void getCompanyProjects() {
        for (Project p : projects) {
            System.out.println(p.getProjectName());
        }
    }

    @Override
    public void work() {
        System.out.println(getCompName());
        for (Project p : projects) {
            System.out.println("-" + p.getProjectName() + ": cost = " + p.getProjectCost() + ", list of employees:");
            p.getProjectEmployees();
        }
    }
}
