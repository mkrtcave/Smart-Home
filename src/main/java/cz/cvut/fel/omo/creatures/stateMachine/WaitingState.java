package cz.cvut.fel.omo.creatures.stateMachine;

import cz.cvut.fel.omo.creatures.Person;

public class WaitingState implements PersonState {

    /**
     * Sets Person state to the next in order
     *
     * @param person Person on who we change state
     */
    @Override
    public void next(Person person) {
        person.setState(new WorkingState());
    }

    /**
     * Sets Person state to the previous in order
     *
     * @param person Person on who we change state
     */
    @Override
    public void prev(Person person) {
        person.setState(new RelaxingState());
    }

    /**
     * Prints status
     */
    @Override
    public void printStatus() {
        System.out.println("Wait");
    }
}
