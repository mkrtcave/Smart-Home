package cz.cvut.fel.omo.events;

public class StormEvent extends Event{
    /**
     * Constructor
     * sets type of event
     *
     * @param sourceSubscriber source of the event
     */
    public StormEvent(EventSubscriber sourceSubscriber) {
        super(EventType.STORM, sourceSubscriber);
    }
}
