package com.company.developer_creation;

public class MiddleDeveloper extends JuniorDeveloper implements DeveloperLevel {
    @Override
    public String developInLevel() {
        return super.developInLevel() + " Also implementing middle developer stuff.";
    }

}
