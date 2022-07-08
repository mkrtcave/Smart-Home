package cz.cvut.fel.omo.building.building_equipment.sports_equipment;

public class Ski extends SportsEquipment {
    /**
     * Constructor
     * Sets SportsEquipmentType, usageTime
     *
     * @param name name of the ski
     */
    public Ski(String name) {
        super(name, SportsEquipmentType.SKI);
        this.setUsageTime(6);
    }
}
