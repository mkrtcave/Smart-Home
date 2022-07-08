package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;
import cz.cvut.fel.omo.events.StormEvent;

public class Television extends Appliance {

    /**
     * Constructor
     *
     * @param name name of Television
     * @param room room where Television is located
     */
    public Television(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.TELEVISION);
        this.setUsageTime(3);
    }

    /**
     * Handles given event - turns Television off
     *
     * @param event event to be handled by Television
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
            this.setConsumptionOfElectricity(15);
        }
        if(this.getState().getClass() == OffState.class){
            this.setConsumptionOfElectricity(5);
        }
    }
}
