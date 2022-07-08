package cz.cvut.fel.omo.events;

public class BabyRepackEvent extends Event{
    /**
     * Constructor
     * sets type of event
     *
     * @param sourceSubscriber source of the event
     */
    public BabyRepackEvent(EventSubscriber sourceSubscriber) {
        super(EventType.BABY_REPACK, sourceSubscriber);
    }
}
