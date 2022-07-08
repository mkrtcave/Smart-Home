package cz.cvut.fel.omo.events;

import java.util.ArrayList;

public abstract class Event {

    private final EventType type;
    private final EventSubscriber sourceSubscriber;
    private ArrayList<EventSubscriber> affectedSubscribers = new ArrayList<>();

    /**
     * Constructor
     *
     * @param type the type of event
     * @param sourceSubscriber source of the event
     */
    protected Event(EventType type, EventSubscriber sourceSubscriber) {
        this.type = type;
        this.sourceSubscriber = sourceSubscriber;
    }

    public EventType getEventType(){
        return type;
    }

    public ArrayList<EventSubscriber> getAffectedSubscribers() {
        return affectedSubscribers;
    }

    public void addAffectedSubscriber(EventSubscriber affectedSubscriber) {
        this.affectedSubscribers.add(affectedSubscriber);
    }

    public EventSubscriber getSourceSubscriber() {
        return sourceSubscriber;
    }
}
