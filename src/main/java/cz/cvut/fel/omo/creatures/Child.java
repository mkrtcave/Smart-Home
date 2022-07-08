package cz.cvut.fel.omo.creatures;

import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.config.Constants;
import cz.cvut.fel.omo.creatures.enums.PersonType;
import cz.cvut.fel.omo.creatures.stateMachine.WaitingState;
import cz.cvut.fel.omo.events.BabyRepackEvent;

import java.util.Random;

public class Child extends Person {

    /**
     * Constructor
     *
     * @param name the name of child
     * @param room the room where child is located
     */
    public Child(String name, Room room){
        super(name, room);
        this.setPersonType(PersonType.CHILD);
    }

    /**
     * Updates child
     * changes its states
     * can generate new BabyRepackEvent
     */
    @Override
    public void tick(){
        if (this.timeLeftDoingSomething > 0){
            this.timeLeftDoingSomething--;
        }
        if (this.timeLeftDoingSomething == 0){
            this.setState(new WaitingState());
            if (this.getRoom() == null){
                this.setRoom(this.getRandomRoom());
            }
        }
        if (this.state.getClass() == WaitingState.class){
            Random random = new Random();
            int randomInt = random.nextInt(Constants.CHILD_NEEDS_REPACK_PROBABILITY.getValue());

            if (randomInt == 0){
                this.controller.addBabyRepackEvent(new BabyRepackEvent(this));
            }else{
                this.generateRandomAction();
            }
        }
    }
}
