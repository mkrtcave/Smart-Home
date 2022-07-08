package cz.cvut.fel.omo.events;

public class FeedPetEvent extends Event{
    /**
     * Constructor
     * sets type of event
     *
     * @param sourceSubscriber source of the event
     */
    public FeedPetEvent(EventSubscriber sourceSubscriber) {
        super(EventType.FEED_PET, sourceSubscriber);
    }
}
