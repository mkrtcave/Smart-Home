package cz.cvut.fel.omo.creatures.creaturesFactory;

import cz.cvut.fel.omo.building.Floor;
import cz.cvut.fel.omo.building.House;
import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.creatures.Adult;
import cz.cvut.fel.omo.creatures.Child;
import cz.cvut.fel.omo.creatures.Person;
import cz.cvut.fel.omo.creatures.Pet;

import java.util.Random;

public class CreaturesFactory {

    private static final Random RAND = new Random();
    private final House house;

    /**
     * Constructor
     *
     * @param house House where we create creatures into
     */
    public CreaturesFactory(House house){
        this.house = house;
    }

    private Room getRandomRoom(){

        Floor floor = (Floor) house.getFloors().get(RAND.nextInt(house.getFloors().size()));

        return (Room) floor.getRooms().get(RAND.nextInt(floor.getRooms().size()));
    }

    /**
     * Creates person
     *
     * @param creatureType type of person we want to create
     * @return created person
     */
    public Person getPerson(String creatureType){
        if(creatureType == null){
            return null;
        }
        if(creatureType.equalsIgnoreCase("ADULT")){
            return new Adult("Adult" + RAND.nextInt(), this.getRandomRoom());
        }
        else if(creatureType.equalsIgnoreCase("CHILD")){
            return new Child("Child" + RAND.nextInt(), this.getRandomRoom());
        }
        return null;
    }

    /**
     * Creates pet
     *
     * @param petType type of pet we want to create - must equal PET
     * @return created pet
     */
    public Pet getPet(String petType){
        if(petType.equalsIgnoreCase("PET")){
            return new Pet("Pet" + RAND.nextInt(), this.getRandomRoom());
        }
        return null;
    }
}
