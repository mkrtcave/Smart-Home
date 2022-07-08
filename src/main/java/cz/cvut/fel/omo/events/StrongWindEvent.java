package cz.cvut.fel.omo.events;

public class StrongWindEvent extends Event{
    /**
     * Constructor
     * sets type of event
     *
     * @param sourceSubscriber source of the event
     */
    public StrongWindEvent(EventSubscriber sourceSubscriber) {
        super(EventType.STRONG_WIND, sourceSubscriber);
    }
}
