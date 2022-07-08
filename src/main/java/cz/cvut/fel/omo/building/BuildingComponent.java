package cz.cvut.fel.omo.building;

public abstract class BuildingComponent {


    /**
     * Adds component to collection
     * Composite Pattern
     *
     * @param component Component to be added
     */
    public void add(BuildingComponent component){
        throw new UnsupportedOperationException();
    }

    /**
     * Remove component from collection
     * Composite Pattern
     *
     * @param component Component to be removed
     */
    public void remove(BuildingComponent component){
        throw new UnsupportedOperationException();
    }
}
