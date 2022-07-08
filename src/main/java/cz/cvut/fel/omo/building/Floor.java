package cz.cvut.fel.omo.building;

import java.util.ArrayList;

public class Floor extends BuildingComponent{

    private final int level;

    private ArrayList<BuildingComponent> rooms = new ArrayList<>();


    /**
     * Constructor
     *
     * @param level level of floor number
     */
    public Floor(int level) {
        this.level = level;
    }

    /**
     * Adds component to rooms list
     * Composite Pattern
     *
     * @param component Component to be added
     */
    @Override
    public void add(BuildingComponent component){
        rooms.add(component);
    }

    /**
     * Remove component from rooms list
     * Composite Pattern
     *
     * @param component Component to be removed
     */
    @Override
    public void remove(BuildingComponent component){
        rooms.remove(component);
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<BuildingComponent> getRooms() {
        return rooms;
    }
}
