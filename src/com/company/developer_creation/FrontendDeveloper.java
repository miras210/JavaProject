package com.company.developer_creation;

import com.company.developer_creation.DeveloperType;

public class FrontendDeveloper implements DeveloperType {
    @Override
    public String developType() {
        return "I'm developing front end side of the project.";
    }

}
