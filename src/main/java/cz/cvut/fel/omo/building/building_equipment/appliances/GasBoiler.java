package cz.cvut.fel.omo.building.building_equipment.appliances;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;
import cz.cvut.fel.omo.events.LowTemperatureEvent;


public class GasBoiler extends Appliance {

    /**
     * Constructor
     *
     * @param name name of GasBoiler
     * @param room room where GasBoiler is located
     */
    public GasBoiler(String name, Room room) {
        super(name, room);
        this.setType(ApplianceType.GAS_BOILER);
    }

    /**
     * Updates StormSensor, can generate BrokenDeviceEvent, adds consumption for current hour
     */
    @Override
    public void tick(){
        this.setState(new IdleState());

        this.setBroken();
        this.calculateConsumption();
    }

    /**
     * Handles given event - turns GasBoiler on
     *
     * @param event event to be handled by GasBoiler
     */
    @Override
    public void handleEvent(LowTemperatureEvent event){
        if (event.getAffectedSubscribers().size() < 1){
            this.setState(new OnState());
            event.addAffectedSubscriber(this);
        }
    }
    
    @Override
    protected void calculateConsumption(){
        if(this.getState().getClass() == IdleState.class){
            this.setConsumptionOfElectricity(5);
            this.setConsumptionOfGas(20);
        }
        if(this.getState().getClass() == OnState.class){
            this.setConsumptionOfElectricity(10);
            this.setConsumptionOfGas(50);
            this.setConsumptionOfWater(10);
        }
        if(this.getState().getClass() == OffState.class){
            this.setConsumptionOfElectricity(2);
            this.setConsumptionOfGas(0);
        }
    }
}
