package cz.cvut.fel.omo.building.building_equipment.stateMachine;

import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;

public class IdleState implements DeviceState{

    /**
     * Sets appliance state to the next in order
     *
     * @param appliance Appliance on which we change state
     */
    @Override
    public void next(Appliance appliance) {
        appliance.setState(new OnState());
    }

    /**
     * Sets appliance state to the previous in order
     *
     * @param appliance Appliance on which we change state
     */
    @Override
    public void prev(Appliance appliance) {
        appliance.setState(new OffState());
    }

    /**
     * Prints status
     *
     * @return String status
     */
    @Override
    public String printStatus() {
        return "Available";
    }
    
}
