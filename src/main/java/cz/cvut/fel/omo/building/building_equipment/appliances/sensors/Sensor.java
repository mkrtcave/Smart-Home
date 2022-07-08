package cz.cvut.fel.omo.building.building_equipment.appliances.sensors;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;
import cz.cvut.fel.omo.building.building_equipment.appliances.ApplianceType;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;

import java.util.Random;

public abstract class Sensor extends Appliance {

    private final Random random = new Random();

    /**
     * Constructor
     *
     * @param name name of sensor
     * @param room room where sensor is located
     */
    public Sensor(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.SENSOR);
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

    /**
     * returns Random class
     *
     * @return Random class
     */
    public Random getRandom() {
        return random;
    }
}
