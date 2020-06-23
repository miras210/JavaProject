package com.company.developer_creation;

import com.company.enums.Levels;
import com.company.enums.Types;

public class AbstractDeveloperFactory {
    private DeveloperLevel lvlFactory;
    private DeveloperType typeFactory;

    public AbstractDeveloperFactory(Types type, Levels level) {
        lvlFactory = DevLevelFactory.createDevLevel(level);
        typeFactory = DevTypeFactory.createDevType(type);
    }

    public void work() {
        System.out.println(lvlFactory.developInLevel() + " " + typeFactory.developType());
    }
}
