package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;

public class CDPlayer extends Appliance {

    /**
     * Constructor
     *
     * @param name name of CDPlayer
     * @param room room where CDPlayer is located
     */
    public CDPlayer(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.CD_PLAYER);
        this.setUsageTime(2);
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
