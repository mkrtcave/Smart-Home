package cz.cvut.fel.omo.events;

import cz.cvut.fel.omo.Controller;

public interface EventSubscriber {

    Controller controller = Controller.getInstance();

    /**
     * Updates entity
     * represents activity in 1 hour
     */
    void tick();

    /**
     * handles given event
     *
     * @param event BabyRepackEvent to be handled
     */
    default void handleEvent(BabyRepackEvent event) {}

    /**
     * handles given event
     *
     * @param event DeviceBrokenEvent to be handled
     */
    default void handleEvent(DeviceBrokenEvent event) {}

    /**
     * handles given event
     *
     * @param event FeedPetEvent to be handled
     */
    default void handleEvent(FeedPetEvent event) {}

    /**
     * handles given event
     *
     * @param event LowTemperatureEvent to be handled
     */
    default void handleEvent(LowTemperatureEvent event) {}

    /**
     * handles given event
     *
     * @param event StrongWindEvent to be handled
     */
    default void handleEvent(StrongWindEvent event) {}

    /**
     * handles given event
     *
     * @param event StormEvent to be handled
     */
    default void handleEvent(StormEvent event) {}
}
