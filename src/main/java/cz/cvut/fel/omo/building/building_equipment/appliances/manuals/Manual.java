package cz.cvut.fel.omo.building.building_equipment.appliances.manuals;

import cz.cvut.fel.omo.building.building_equipment.appliances.ApplianceType;

import java.util.HashMap;
import java.util.Map;

public class Manual {
    private static Map<ApplianceType, Manual> types = new HashMap<>();
    private final int requiredTime = 2;

    /**
     * Constructor
     *
     * @param type ApplianceType
     */
    public Manual(ApplianceType type) {
    }


    /**
     * Lazyloading Manuals
     *
     * @param type ApplianceType
     * @return Manual class
     */
    public static Manual getManualByType(ApplianceType type){
        Manual manual;

        if (!types.containsKey(type)){
            manual = new Manual(type);
            types.put(type, manual);
        }else{
            manual = types.get(type);
        }
        return manual;
    }

    public int getRequiredTime() {
        return requiredTime;
    }
}
