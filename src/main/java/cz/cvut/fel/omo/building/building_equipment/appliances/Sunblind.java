package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.events.StrongWindEvent;

public class Sunblind extends Appliance {

    boolean closed = false;

    /**
     * Constructor
     *
     * @param name name of Sunblind
     * @param room room where Sunblind is located
     */
    public Sunblind(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.SUNBLIND);
        this.setState(new IdleState());
    }

    /**
     * Updates Sunblind, can generate BrokenDeviceEvent, adds consumption for current hour
     */
    @Override
    public void tick(){
        this.setClosed(false);

        this.setBroken();
        this.calculateConsumption();
    }

    @Override
    protected void calculateConsumption() {
        if(this.getState().getClass() == IdleState.class){
            this.setConsumptionOfElectricity(2);
        }
        if(this.getState().getClass() == OnState.class){
            this.setConsumptionOfElectricity(10);
        }
        if(this.getState().getClass() == OffState.class){
            this.setConsumptionOfElectricity(1);
        }
    }

    /**
     * Handles given event - turns Sunblind off
     *
     * @param event event to be handled by Sunblind
     */
    @Override
    public void handleEvent(StrongWindEvent event){
        this.setClosed(true);
        event.addAffectedSubscriber(this);
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
