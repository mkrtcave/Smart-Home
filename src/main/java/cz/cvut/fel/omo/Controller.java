package cz.cvut.fel.omo;


import cz.cvut.fel.omo.building.House;
import cz.cvut.fel.omo.creatures.Child;
import cz.cvut.fel.omo.creatures.Person;
import cz.cvut.fel.omo.creatures.stateMachine.WaitingState;
import cz.cvut.fel.omo.events.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static cz.cvut.fel.omo.config.Constants.ACTIVE_HOURS_A_DAY;

public class Controller {
    private static Controller INSTANCE;

    private House house;
    private int daysCount;

    private ArrayList<EventSubscriber> subscribers = new ArrayList<>();
    private ArrayList<Event> allEvents = new ArrayList<>();

    private Queue<BabyRepackEvent> babyRepackEvents = new LinkedList<>();
    private Queue<DeviceBrokenEvent> deviceBrokenEvents = new LinkedList<>();
    private Queue<FeedPetEvent> feedPetEvents = new LinkedList<>();
    private Queue<LowTemperatureEvent> lowTemperatureEvents = new LinkedList<>();
    private Queue<StormEvent> stormEvents = new LinkedList<>();
    private Queue<StrongWindEvent> strongWindEvents = new LinkedList<>();


    private Controller() {
    }

    /**
     * Singleton pattern
     * returns instance of Controller
     *
     * @param house house configuration where we run simulation
     * @param daysCount number of days the simulation is running
     * @return instance of Controller
     */
    public synchronized static Controller getInstance(House house, int daysCount){
        if (INSTANCE == null){
            INSTANCE = new Controller();

        }
        if (INSTANCE.getHouse() == null){

            INSTANCE.setHouse(house);
            INSTANCE.setDaysCount(daysCount);
        }
        return INSTANCE;
    }

    /**
     * Singleton pattern
     * returns instance of Controller
     *
     * @return instance of Controller
     */
    public synchronized static Controller getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }

    /**
     * Starts simulation
     * handles all activities in house
     * updates all actors in house
     */
    public void start(){
        int totalHours = this.daysCount * ACTIVE_HOURS_A_DAY.getValue();
        this.setAllEventSubscribers();

        while(totalHours > 0){

            this.tickAllSubscribers();

            this.getCorrectBabyRepackEvent(this.babyRepackEvents);
            this.babyRepackEvents.forEach(b -> this.allSubscribersHandleEvent(this.babyRepackEvents.peek()));

            this.getCorrectDeviceBrokenEvent(this.deviceBrokenEvents);
            this.deviceBrokenEvents.forEach(d -> this.allSubscribersHandleEvent(this.deviceBrokenEvents.peek()));

            this.getCorrectFeedPetEvent(this.feedPetEvents);
            this.feedPetEvents.forEach(d -> this.allSubscribersHandleEvent(this.feedPetEvents.peek()));

            this.getCorrectLowTemperatureEvent(this.lowTemperatureEvents);
            this.lowTemperatureEvents.forEach(d -> this.allSubscribersHandleEvent(this.lowTemperatureEvents.peek()));

            this.getCorrectStormEvent(this.stormEvents);
            this.stormEvents.forEach(d -> this.allSubscribersHandleEvent(this.stormEvents.peek()));

            this.getCorrectStrongWindEvent(this.strongWindEvents);
            this.strongWindEvents.forEach(d -> this.allSubscribersHandleEvent(this.strongWindEvents.peek()));

            totalHours--;
        }
    }

    private void tickAllSubscribers(){
        for (EventSubscriber s : this.subscribers){
            s.tick();
        }
    }

    private void allSubscribersHandleEvent(BabyRepackEvent event){
        if (event == null){
            return;
        }
        //chainOfResponsibility
        for(EventSubscriber subscriber : this.subscribers){
            if (subscriber instanceof Person){
                Person person = (Person) subscriber;
                if (person.getState().getClass() == WaitingState.class){
                    Child child = (Child) event.getSourceSubscriber();
                    if ((child.getRoom() == null) || person.getRoom().equals(child.getRoom())){
                        person.handleEvent(event);
                        return;
                    }
                }
            }
        }
        for(EventSubscriber subscriber : this.subscribers){
            if (subscriber instanceof Person) {
                Person person = (Person) subscriber;
                if (person.getState().getClass() == WaitingState.class) {
                    Child child = (Child) event.getSourceSubscriber();
                    if ((child.getRoom() == null) || person.getRoom().getFloor().equals(child.getRoom().getFloor())) {
                        person.handleEvent(event);
                        return;
                    }
                }
            }
        }
        this.subscribers.forEach(s -> s.handleEvent(event));
    }

    private void allSubscribersHandleEvent(DeviceBrokenEvent event){
        this.subscribers.forEach(s -> s.handleEvent(event));
    }

    private void allSubscribersHandleEvent(FeedPetEvent event){
        this.subscribers.forEach(s -> s.handleEvent(event));
    }

    private void allSubscribersHandleEvent(LowTemperatureEvent event){
        this.subscribers.forEach(s -> s.handleEvent(event));
    }

    private void allSubscribersHandleEvent(StormEvent event){
        this.subscribers.forEach(s -> s.handleEvent(event));
    }

    private void allSubscribersHandleEvent(StrongWindEvent event){
        this.subscribers.forEach(s -> s.handleEvent(event));
    }

    private void setAllEventSubscribers(){
        this.subscribers.addAll(this.house.getPeople());
        this.subscribers.addAll(this.house.getPets());
        this.subscribers.addAll(this.house.getAppliances());
        this.subscribers.addAll(this.house.getSportsEquipment());
    }

    /**
     * Adds event to correct queue and to list of all events
     *
     * @param event BabyRepackEvent to add
     */
    public void addBabyRepackEvent(BabyRepackEvent event){
        this.babyRepackEvents.add(event);
        this.allEvents.add(event);
    }

    /**
     * Adds event to correct queue and to list of all events
     *
     * @param event DeviceBrokenEvent to add
     */
    public void addDeviceBrokenEvent(DeviceBrokenEvent event){
        this.deviceBrokenEvents.add(event);
        this.allEvents.add(event);
    }

    /**
     * Adds event to correct queue and to list of all events
     *
     * @param event FeedPetEvent to add
     */
    public void addFeedPetEvent(FeedPetEvent event){
        this.feedPetEvents.add(event);
        this.allEvents.add(event);}

    /**
     * Adds event to correct queue and to list of all events
     *
     * @param event LowTemperatureEvent to add
     */
    public void addLowTemperatureEvent(LowTemperatureEvent event){
        this.lowTemperatureEvents.add(event);
        this.allEvents.add(event);
    }

    /**
     * Adds event to correct queue and to list of all events
     *
     * @param event StormEvent to add
     */
    public void addStormEvent(StormEvent event){
        this.stormEvents.add(event);
        this.allEvents.add(event);
    }

    /**
     * Adds event to correct queue and to list of all events
     *
     * @param event StrongWindEvent to add
     */
    public void addStrongWindEvent(StrongWindEvent event){
        this.strongWindEvents.add(event);
        this.allEvents.add(event);
    }

    private void getCorrectBabyRepackEvent(Queue<BabyRepackEvent> events){
        while(events.peek() != null && events.peek().getAffectedSubscribers().size() > 0){
            events.poll();
        }
    }

    private void getCorrectDeviceBrokenEvent(Queue<DeviceBrokenEvent> events){
        while(events.peek() != null && events.peek().getAffectedSubscribers().size() > 0){
            events.poll();
        }
    }

    private void getCorrectFeedPetEvent(Queue<FeedPetEvent> events){
        while(events.peek() != null && events.peek().getAffectedSubscribers().size() > 0){
            events.poll();
        }
    }

    private void getCorrectLowTemperatureEvent(Queue<LowTemperatureEvent> events){
        while(events.peek() != null && events.peek().getAffectedSubscribers().size() > 0){
            events.poll();
        }
    }

    private void getCorrectStormEvent(Queue<StormEvent> events){
        while(events.peek() != null && events.peek().getAffectedSubscribers().size() > 0){
            events.poll();
        }
    }

    private void getCorrectStrongWindEvent(Queue<StrongWindEvent> events){
        while(events.peek() != null && events.peek().getAffectedSubscribers().size() > 0){
            events.poll();
        }
    }


    public House getHouse() {
        return this.house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    public ArrayList<Event> getAllEvents() {
        return allEvents;
    }
}
