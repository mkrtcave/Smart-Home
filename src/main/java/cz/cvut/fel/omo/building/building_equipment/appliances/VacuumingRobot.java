package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;

public class VacuumingRobot extends Appliance {

    /**
     * Constructor
     *
     * @param name name of VacuumingRobot
     * @param room room where VacuumingRobot is located
     */
    public VacuumingRobot(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.VACUUMING_ROBOT);
        this.setUsageTime(0);
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
