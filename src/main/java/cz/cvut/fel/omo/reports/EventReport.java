package cz.cvut.fel.omo.reports;

import cz.cvut.fel.omo.Controller;
import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;
import cz.cvut.fel.omo.building.building_equipment.appliances.GasBoiler;
import cz.cvut.fel.omo.building.building_equipment.appliances.Sunblind;
import cz.cvut.fel.omo.building.building_equipment.appliances.sensors.Sensor;
import cz.cvut.fel.omo.creatures.Child;
import cz.cvut.fel.omo.creatures.Person;
import cz.cvut.fel.omo.creatures.Pet;
import cz.cvut.fel.omo.events.*;

import java.util.ArrayList;

public class EventReport extends Report{
    
    private static EventReport instance = null;
    private ArrayList<Event> events;

    /**
     * Singleton pattern
     *
     * @return instance of EventReport
     */
    public static EventReport getInstance(){
        if(instance == null){
            instance = new EventReport();
        }
        return instance;
    }

    /**
     * Generates report into file event_report.txt in folder generatedReports
     *
     * @param controller where we take data from
     */
    public void generateReport(Controller controller) {
        this.generateHeader("event_report");

        this.events = controller.getAllEvents();
        this.printSizesOfEvents();
        this.printAllEvents();

        this.writeReport();
    }

    private void printSizesOfEvents(){
        this.addLine("Number of all events: " + this.events.size());

        this.addLine("Number of BabyRepackEvents: " + (int) this.events
                .stream()
                .filter(e -> e.getClass() == BabyRepackEvent.class)
                .count());

        this.addLine("Number of DeviceBrokenEvents: " + (int) this.events
                .stream()
                .filter(e -> e.getClass() == DeviceBrokenEvent.class)
                .count());

        this.addLine("Number of FeedPetEvents: " + (int) this.events
                .stream()
                .filter(e -> e.getClass() == FeedPetEvent.class)
                .count());

        this.addLine("Number of LowTemperatureEvents: " + (int) this.events
                .stream()
                .filter(e -> e.getClass() == LowTemperatureEvent.class)
                .count());

        this.addLine("Number of StormEvents: " + (int) this.events
                .stream()
                .filter(e -> e.getClass() == StormEvent.class)
                .count());

        this.addLine("Number of StrongWindEvents: " + (int) this.events
                .stream()
                .filter(e -> e.getClass() == StrongWindEvent.class)
                .count());

        this.addLine("");
    }

    private void printAllEvents(){
        this.printBabyRepackEvents();
        this.addLine("");
        this.printFeedPetEventsEvents();
        this.addLine("");
        this.printDeviceBrokenEvents();
        this.addLine("");
        this.printLowTemperatureEvents();
        this.addLine("");
        this.printStrongWindEvents();
        this.addLine("");
        this.printStormEvents();
    }

    private void printBabyRepackEvents(){
        for (Event e : this.events){
            if (e.getClass() == BabyRepackEvent.class){
                Child child = (Child) e.getSourceSubscriber();
                String name;
                if (e.getAffectedSubscribers().size() > 0){
                    Person person = (Person) e.getAffectedSubscribers().get(0);
                    name = person.getName();
                }else{
                    name = null;
                }
                addLine(e.getEventType().toString() + " event triggered by: " + child.getName() + " handled by: " + name);
            }
        }
    }

    private void printDeviceBrokenEvents(){
        for (Event e : this.events){
            if (e.getClass() == DeviceBrokenEvent.class){
                Appliance appliance = (Appliance) e.getSourceSubscriber();
                String name;
                if (e.getAffectedSubscribers().size() > 0){
                    Person person = (Person) e.getAffectedSubscribers().get(0);
                    name = person.getName();
                }else{
                    name = null;
                }
                addLine(e.getEventType().toString() + " event triggered by: " + appliance.getName() + " handled by: " + name);
            }
        }
    }

    private void printFeedPetEventsEvents(){
        for (Event e : this.events){
            if (e.getClass() == FeedPetEvent.class){
                Pet pet = (Pet) e.getSourceSubscriber();
                String name;
                if (e.getAffectedSubscribers().size() > 0){
                    Person person = (Person) e.getAffectedSubscribers().get(0);
                    name = person.getName();
                }else{
                    name = null;
                }
                addLine(e.getEventType().toString() + " event triggered by: " + pet.getName() + " handled by: " + name);
            }
        }
    }

    private void printLowTemperatureEvents(){
        for (Event e : this.events){
            if (e.getClass() == LowTemperatureEvent.class){
                Sensor sensor = (Sensor) e.getSourceSubscriber();
                String name;
                if (e.getAffectedSubscribers().size() > 0){
                    GasBoiler gasBoiler = (GasBoiler) e.getAffectedSubscribers().get(0);
                    name = gasBoiler.getName();
                }else{
                    name = null;
                }
                addLine(e.getEventType().toString() + " event triggered by: " + sensor.getName() + " handled by: " + name);
            }
        }
    }

    private void printStormEvents(){
        for (Event e : this.events){
            if (e.getClass() == StormEvent.class){
                Sensor sensor = (Sensor) e.getSourceSubscriber();
                ArrayList<String> appliances = new ArrayList<>();
                for (EventSubscriber es : e.getAffectedSubscribers()){
                    Appliance a = (Appliance) es;
                    appliances.add(a.getName());
                }
                addLine(e.getEventType().toString() + " event triggered by: " + sensor.getName() + " handled by: " + appliances.toString());
            }
        }
    }

    private void printStrongWindEvents(){
        for (Event e : this.events){
            if (e.getClass() == StrongWindEvent.class){
                Sensor sensor = (Sensor) e.getSourceSubscriber();
                ArrayList<String> appliances = new ArrayList<>();
                for (EventSubscriber es : e.getAffectedSubscribers()){
                    Sunblind s = (Sunblind) es;
                    appliances.add(s.getName());
                }
                addLine(e.getEventType().toString() + " event triggered by: " + sensor.getName() + " handled by: " + appliances.toString());
            }
        }
    }
}
