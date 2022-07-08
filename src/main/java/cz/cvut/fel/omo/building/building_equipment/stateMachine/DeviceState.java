package cz.cvut.fel.omo.building.building_equipment.stateMachine;

import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;


public interface DeviceState {

    /**
     * Sets appliance state to the next in order
     *
     * @param appliance Appliance on which we change state
     */
    void next(Appliance appliance);

    /**
     * Sets appliance state to the previous in order
     *
     * @param appliance Appliance on which we change state
     */
    void prev(Appliance appliance);

    /**
     * Prints status
     *
     * @return String status
     */
    String printStatus();
}
