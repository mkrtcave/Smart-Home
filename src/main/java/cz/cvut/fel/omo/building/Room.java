package cz.cvut.fel.omo.building;

import java.util.ArrayList;

public class Room extends BuildingComponent{

    private final String name;
    private final Floor floor;

    private ArrayList<BuildingComponent> appliances = new ArrayList<>();
    private ArrayList<BuildingComponent> sportsEquipment = new ArrayList<>();

    /**
     * Constructor
     *
     * @param name name of the room
     * @param floor floor where room is
     */
    public Room(String name, Floor floor) {
        this.name = name;
        this.floor = floor;
    }

    /**
     * Adds component to appliances list
     * Composite Pattern
     *
     * @param component Component to be added
     */
    @Override
    public void add(BuildingComponent component){
        appliances.add(component);
    }

    /**
     * Removes component from appliances list
     * Composite Pattern
     *
     * @param component Component to be added
     */
    @Override
    public void remove(BuildingComponent component){
        appliances.remove(component);
    }

    /**
     * Adds component to sports equipment list
     *
     * @param component Component to be added
     */
    public void addEquipment(BuildingComponent component){
        sportsEquipment.add(component);
    }

    /**
     * Removes component from sports equipment list
     *
     * @param component Component to be added
     */
    public void removeEquipment(BuildingComponent component){
        sportsEquipment.remove(component);
    }

    public String getName() {
        return name;
    }

    public ArrayList<BuildingComponent> getAppliances() {
        return appliances;
    }

    public ArrayList<BuildingComponent> getSportsEquipment() {
        return sportsEquipment;
    }

    public Floor getFloor() {
        return floor;
    }
}
