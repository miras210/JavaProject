package com.company.developer_creation;

public class SeniorDeveloper extends MiddleDeveloper implements DeveloperLevel {
    @Override
    public String developInLevel() {
        return super.developInLevel() + " Moreover, I'm hardcoding senior tasks.";
    }
}
