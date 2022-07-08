package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.BuildingComponent;
import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.*;
import cz.cvut.fel.omo.config.Constants;
import cz.cvut.fel.omo.events.DeviceBrokenEvent;
import cz.cvut.fel.omo.events.EventSubscriber;

import java.util.Random;

public abstract class Appliance extends BuildingComponent implements EventSubscriber {

    private final String name;
    private Room room;
    private ApplianceType type;

    private int usageTime;
    private int usageTimeLeft = 0;

    private int consumptionOfGas = 0;
    private int consumptionOfElectricity = 0;
    private int consumptionOfWater = 0;

    private DeviceState state = new IdleState();

    /**
     * Constructor
     *
     * @param name name of appliance
     * @param room room where appliance is located
     */
    public Appliance(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    /**
     * Updates Appliance, can generate event, adds consumption for current hour
     */
    @Override
    public void tick(){
        if (usageTimeLeft>0){
            usageTimeLeft--;
        }
        if(usageTimeLeft == 0 && this.getState().getClass() == OnState.class){
            this.setState(new OffState());
        }
        this.setBroken();

        this.calculateConsumption();
    }

    protected void setBroken(){
        if (this.getState().getClass() == IdleState.class || this.getState().getClass() == OffState.class){
            Random random = new Random();
            int randomInt = random.nextInt(Constants.DEVICE_BREAK_PROBABILITY.getValue());

            if (randomInt == 0){
                this.setState(new BrokenState());
                this.controller.addDeviceBrokenEvent(new DeviceBrokenEvent(this));
            }
        }
    }

    protected abstract void calculateConsumption();

    protected void setConsumptionOfGas(int value){
        consumptionOfGas += value;
    }

    protected void setConsumptionOfElectricity(int value){
        consumptionOfElectricity += value;
    }

    protected void setConsumptionOfWater(int value){
        consumptionOfWater += value;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public DeviceState getState() {
        return state;
    }

    public void setState(DeviceState state) {
        this.state = state;
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

    public ApplianceType getType() {
        return type;
    }

    public void setType(ApplianceType type) {
        this.type = type;
    }

    public int getConsumptionOfGas() {
        return consumptionOfGas;
    }

    public int getConsumptionOfElectricity() {
        return consumptionOfElectricity;
    }

    public int getConsumptionOfWater() {
        return consumptionOfWater;
    }
}
