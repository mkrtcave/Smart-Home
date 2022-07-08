package cz.cvut.fel.omo.creatures.stateMachine;

import cz.cvut.fel.omo.creatures.Person;


public interface PersonState {

    /**
     * Sets Person state to the next in order
     *
     * @param person Person on who we change state
     */
    void next(Person person);

    /**
     * Sets Person state to the previous in order
     *
     * @param person Person on who we change state
     */
    void prev(Person person);

    /**
     * Prints status
     */
    void printStatus();
}
