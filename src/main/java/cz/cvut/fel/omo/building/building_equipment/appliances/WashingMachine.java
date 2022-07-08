package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;
import cz.cvut.fel.omo.events.StormEvent;

public class WashingMachine extends Appliance {

    /**
     * Constructor
     *
     * @param name name of WashingMachine
     * @param room room where WashingMachine is located
     */
    public WashingMachine(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.WASHING_MACHINE);
        this.setUsageTime(3);
    }

    /**
     * Handles given event - turns WashingMachine off
     *
     * @param event event to be handled by WashingMachine
     */
    @Override
    public void handleEvent(StormEvent event) {
        this.setState(new OffState());
        event.addAffectedSubscriber(this);
    }
    
    @Override
    protected void calculateConsumption(){
        if(this.getState().getClass() == IdleState.class){
            this.setConsumptionOfElectricity(15);
        }
        if(this.getState().getClass() == OnState.class){
            this.setConsumptionOfElectricity(25);
            this.setConsumptionOfWater(10);
        }
        if(this.getState().getClass() == OffState.class){
            this.setConsumptionOfElectricity(5);
        }
    }
}
