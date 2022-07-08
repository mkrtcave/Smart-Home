package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;
import cz.cvut.fel.omo.events.StormEvent;

public class Computer extends Appliance {

    /**
     * Constructor
     *
     * @param name name of computer
     * @param room room where computer is located
     */
    public Computer(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.COMPUTER);
        this.setUsageTime(3);
    }

    /**
     * Handles given event - turns computer off
     *
     * @param event event to be handled by computer
     */
    @Override
    public void handleEvent(StormEvent event) {
        this.setState(new OffState());
        event.addAffectedSubscriber(this);
    }

    @Override
    protected void calculateConsumption(){
        if(this.getState().getClass() == IdleState.class){
            this.setConsumptionOfElectricity(5);
        }
        if(this.getState().getClass() == OnState.class){
            this.setConsumptionOfElectricity(10);
        }
        if(this.getState().getClass() == OffState.class){
            this.setConsumptionOfElectricity(2);
        }
    }
}
