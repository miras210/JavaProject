package com.company.entities;

import com.company.developer_creation.AbstractDeveloperFactory;
import com.company.enums.JobTitle;
import com.company.enums.Levels;
import com.company.enums.Types;
import com.company.salary_stuff.SalaryStrategy;

import java.lang.reflect.Type;

public class Developer extends Employee {
    private String programmingLanguage;
    private AbstractDeveloperFactory devFactory;
    private Types type;
    private Levels level;

    public Developer(String name, JobTitle jobTitle, String programmingLanguage, Types type, Levels level) {
        super(name, jobTitle);
        this.programmingLanguage = programmingLanguage;
        devFactory = new AbstractDeveloperFactory(type, level);
        setSalary(SalaryStrategy.getSalary(type, level));
        this.level = level;
        this.type = type;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public Types getType() {
        return type;
    }

    public Levels getLevel() {
        return level;
    }

    @Override
    public void work() {
        System.out.print("I'm using " + programmingLanguage + ". ");
        devFactory.work();
    }
}
