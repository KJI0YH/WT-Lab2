package by.tc.task01.dao.creator;

import by.tc.task01.dao.creator.creators.OvenCreator;

import java.util.HashMap;
import java.util.Map;

public class ApplianceCreatorFactory {

    private static final ApplianceCreatorFactory instance = new ApplianceCreatorFactory();

    private Map<String, ApplianceCreator> creators = new HashMap<>();

    private ApplianceCreatorFactory{
        creators.put("oven", new OvenCreator());
    }
}
