package cz.cvut.fel.omo.building.building_equipment.sports_equipment;

import cz.cvut.fel.omo.building.BuildingComponent;
import cz.cvut.fel.omo.events.EventSubscriber;

public abstract class SportsEquipment extends BuildingComponent implements EventSubscriber {
    private final String name;
    private SportsEquipmentType type;

    private boolean available = true;
    private int usageTime;
    private int usageTimeLeft = 0;


    /**
     * Constructor
     *
     * @param name name of the SportsEquipment
     * @param type EquipmentType
     */
    public SportsEquipment(String name, SportsEquipmentType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Updates SportsEquipment state based on usage time
     */
    @Override
    public void tick(){
        if (this.usageTimeLeft>0){
            this.usageTimeLeft--;
        }
        if(this.usageTimeLeft == 0){
            this.setAvailable(true);
        }
    }

    public SportsEquipmentType getType() {
        return type;
    }

    public void setType(SportsEquipmentType type) {
        this.type = type;
    }

    public int getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(int usageTime) {
        this.usageTime = usageTime;
    }

    public void setUsageTimeLeft(int usageTimeLeft) {
        this.usageTimeLeft = usageTimeLeft;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }
}
