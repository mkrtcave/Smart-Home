package cz.cvut.fel.omo.events;

public class DeviceBrokenEvent extends Event{
    /**
     * Constructor
     * sets type of event
     *
     * @param sourceSubscriber source of the event
     */
    public DeviceBrokenEvent(EventSubscriber sourceSubscriber) {
        super(EventType.BROKEN_DEVICE, sourceSubscriber);
    }
}
