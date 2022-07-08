package cz.cvut.fel.omo.building;

import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;
import cz.cvut.fel.omo.building.building_equipment.sports_equipment.SportsEquipment;
import cz.cvut.fel.omo.creatures.Person;
import cz.cvut.fel.omo.creatures.Pet;

import java.util.ArrayList;

public class House extends BuildingComponent{
    private static House INSTANCE;

    private ArrayList<BuildingComponent> floors = new ArrayList();
    private ArrayList<Person> people = new ArrayList<>();
    private ArrayList<Pet> pets = new ArrayList<>();

    private House(){};


    /**
     * Singleton Pattern returns instance if created, if not, return new instance
     *
     * @return house instance
     */
    public synchronized static House getInstance(){
        if (INSTANCE == null){
            INSTANCE = new House();
        }
        return INSTANCE;
    }

    /**
     * Adds component to floors list
     * Composite Pattern
     *
     * @param component Component to be added
     */
    @Override
    public void add(BuildingComponent component){
        floors.add(component);
    }

    /**
     * Remove component from floors list
     * Composite Pattern
     *
     * @param component Component to be removed
     */
    @Override
    public void remove(BuildingComponent component){
        floors.remove(component);
    }

    public ArrayList<BuildingComponent> getFloors() {
        return floors;
    }


    /**
     * Returns list off all appliances that belong to this house
     *
     * @return list of appliances in house
     */
    public ArrayList<Appliance> getAppliances(){
        ArrayList<Appliance> appliances = new ArrayList<>();
        for (BuildingComponent floor : floors){
            for (BuildingComponent room : ((Floor) floor).getRooms()){
                for (BuildingComponent applince : ((Room) room).getAppliances()){
                    appliances.add((Appliance) applince);
                }
            }
        }
        return appliances;
    }

    /**
     * Returns list off all sports equipment that belong to this house
     *
     * @return list of sports equipment in house
     */
    public ArrayList<SportsEquipment> getSportsEquipment(){
        ArrayList<SportsEquipment> sportsEquipments = new ArrayList<>();
        for (BuildingComponent floor : floors){
            for (BuildingComponent room : ((Floor) floor).getRooms()){
                for (BuildingComponent sportsEquipment : ((Room) room).getSportsEquipment()){
                    sportsEquipments.add((SportsEquipment) sportsEquipment);
                }
            }
        }
        return sportsEquipments;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person){this.people.add(person);}

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void addPet(Pet pet){this.pets.add(pet);}
}
