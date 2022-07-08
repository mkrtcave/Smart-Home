package cz.cvut.fel.omo.creatures;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.config.Constants;
import cz.cvut.fel.omo.events.EventSubscriber;
import cz.cvut.fel.omo.events.FeedPetEvent;

import java.util.Random;


public class Pet implements EventSubscriber {

    Random random = new Random();

    private final String name;
    private final Room room;
    private int hunger = random.nextInt(Constants.PET_HUNGER.getValue());

    /**
     * @param name Pets name
     * @param room Room where pet is located
     */
    public Pet(String name, Room room){
        this.name = name;
        this.room = room;
    }

    public String getName() {
        return name;
    }

    /**
     * Updates pet
     * increases its hunger
     * can generate event FeedPetEvent
     */
    @Override
    public void tick() {
        if (hunger < Constants.PET_HUNGER.getValue()){
            hunger++;
        }
        if (hunger == Constants.PET_HUNGER.getValue()){
            this.requireFood();
            this.setHunger(0);
        }
    }

    private void requireFood(){
        this.controller.addFeedPetEvent(new FeedPetEvent(this));
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public Room getRoom() {
        return room;
    }
}
