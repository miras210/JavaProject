package com.company.developer_creation;

public class TeamLead extends SeniorDeveloper implements DeveloperLevel {
    @Override
    public String developInLevel() {
        return super.developInLevel() + " Finally, I'm leading the project team.";
    }

}
