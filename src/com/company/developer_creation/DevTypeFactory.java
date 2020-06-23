package com.company.developer_creation;

import com.company.enums.Types;

public class DevTypeFactory {
    public static DeveloperType createDevType(Types type) {
        DeveloperType devType = null;
        switch (type) {
            case BACKEND:
                devType = new BackendDeveloper();
                break;
            case FRONTEND:
                devType = new FrontendDeveloper();
                break;
        }
        return devType;
    }
}
