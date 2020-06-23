package com.company.developer_creation;

import com.company.developer_creation.DeveloperType;

public class BackendDeveloper implements DeveloperType {
    @Override
    public String developType() {
        return "I'm developing back end side of the project.";
    }
}
