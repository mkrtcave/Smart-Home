package cz.cvut.fel.omo.building.building_equipment.appliances.sensors;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.config.Constants;
import cz.cvut.fel.omo.events.LowTemperatureEvent;

public class TemperatureSensor extends Sensor{
    /**
     * Constructor
     *
     * @param name name of sensor
     * @param room room where sensor is located
     */
    public TemperatureSensor(String name, Room room) {
        super(name, room);
    }

    /**
     * Updates StormSensor, can generate event, adds consumption for current hour
     */
    @Override
    public void tick(){
        int randomInt = this.getRandom().nextInt(Constants.LOW_TEMPERATURE_PROBABILITY.getValue());

        if (randomInt == 0){
            this.controller.addLowTemperatureEvent(new LowTemperatureEvent(this));
        }
        this.calculateConsumption();
    }
}
