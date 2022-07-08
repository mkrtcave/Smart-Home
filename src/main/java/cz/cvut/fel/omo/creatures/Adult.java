package cz.cvut.fel.omo.creatures;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.creatures.enums.PersonType;

public class Adult extends Person{

    /**
     * Constructor
     *
     * @param name the name of adult
     * @param room the room where adult is located
     */
    public Adult(String name, Room room) {
        super(name, room);
        this.setPersonType(PersonType.ADULT);
    }
}