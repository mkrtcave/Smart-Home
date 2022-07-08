package cz.cvut.fel.omo.building.building_equipment.sports_equipment;

public class Bike extends SportsEquipment {
    /**
     * Constructor
     * Sets SportsEquipmentType, usageTime
     *
     * @param name name of the bike
     */
    public Bike(String name) {
        super(name, SportsEquipmentType.BICYCLE);
        this.setUsageTime(3);
    }
}
