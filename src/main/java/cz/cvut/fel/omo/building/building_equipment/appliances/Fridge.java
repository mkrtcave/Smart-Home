package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;
import cz.cvut.fel.omo.events.StormEvent;

public class Fridge extends Appliance {

    /**
     * Constructor
     *
     * @param name name of Fridge
     * @param room room where Fridge is located
     */
    public Fridge(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.FRIDGE);
        this.setUsageTime(1);
    }

    /**
     * Handles given event - turns Fridge off
     *
     * @param event event to be handled by Fridge
     */
    @Override
    public void handleEvent(StormEvent event) {
        this.setState(new OffState());
        event.addAffectedSubscriber(this);
    }
    
    @Override
    protected void calculateConsumption(){
        if(this.getState().getClass() == IdleState.class){
            this.setConsumptionOfElectricity(10);
        }
        if(this.getState().getClass() == OnState.class){
            this.setConsumptionOfElectricity(20);
        }
        if(this.getState().getClass() == OffState.class){
            this.setConsumptionOfElectricity(5);
        }
    }
}
