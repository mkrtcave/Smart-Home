package cz.cvut.fel.omo.events;

public class LowTemperatureEvent extends Event{
    /**
     * Constructor
     * sets type of event
     *
     * @param sourceSubscriber source of the event
     */
    public LowTemperatureEvent(EventSubscriber sourceSubscriber) {
        super(EventType.LOW_TEMPERATURE, sourceSubscriber);
    }
}
