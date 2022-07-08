package cz.cvut.fel.omo.building.building_equipment.stateMachine;

import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;

public class BrokenState implements DeviceState{

    /**
     * Sets appliance state to the next in order
     *
     * @param appliance Appliance on which we change state
     */
    @Override
    public void next(Appliance appliance) {
        appliance.setState(new OffState());
    }

    /**
     * Returns error message
     *
     * @param appliance Appliance on which we change state
     */
    @Override
    public void prev(Appliance appliance) {
        System.out.println("Device is broken, there is no way take previous state");
    }

    /**
     * Prints status
     *
     * @return String status
     */
    @Override
    public String printStatus() {
        return "Broken";
    }
    
}
