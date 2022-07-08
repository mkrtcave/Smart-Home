package cz.cvut.fel.omo.reports;

import cz.cvut.fel.omo.Controller;
import cz.cvut.fel.omo.building.BuildingComponent;
import cz.cvut.fel.omo.building.Floor;
import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;
import cz.cvut.fel.omo.building.building_equipment.sports_equipment.SportsEquipment;

public class HouseInfReport extends Report{
    
    private static HouseInfReport instance = null;

    /**
     * Singleton pattern
     *
     * @return instance of HouseInfReport
     */
    public static HouseInfReport getInstance(){
        if(instance == null){
            instance = new HouseInfReport();
        }
        return instance;
    }

    /**
     * Generates report into file house_info_report.txt in folder generatedReports
     *
     * @param controller where we take data from
     */
    public void generateReport(Controller controller) {
        this.generateHeader("house_info_report");

        String numberOfPeople = Integer.toString(controller.getHouse().getPeople().size());
        this.addLine("Number of people: " + numberOfPeople);
        String numberOfPets = Integer.toString(controller.getHouse().getPets().size());
        this.addLine("Number of pets: " + numberOfPets);
        String numberOfAppliances = Integer.toString(controller.getHouse().getAppliances().size());
        this.addLine("Number of devices: " + numberOfAppliances);
        String numberOfFloors = Integer.toString(controller.getHouse().getFloors().size());
        this.addLine("Number of floors: " + numberOfFloors);
        String numberOfSportEquipment = Integer.toString(controller.getHouse().getSportsEquipment().size());
        this.addLine("Number of sport equipments: " + numberOfSportEquipment);
        this.addLine("\n");
        
        for(BuildingComponent floor : controller.getHouse().getFloors()){
            this.addLine("Floor: " + ((Floor) floor).getLevel());
            this.addLine("");
            this.addLine(" Rooms at floor " + ((Floor) floor).getLevel() + ":");
            addLine("");
            for(BuildingComponent room : ((Floor) floor).getRooms()){
                this.addLine("  " + ((Room) room).getName());
                for(BuildingComponent device : ((Room) room).getAppliances()){
                    this.addLine("   Device: " + ((Appliance) device).getName());
                }
                for(BuildingComponent equipment : ((Room) room).getSportsEquipment()){
                    this.addLine("   Equipment: " + ((SportsEquipment) equipment).getName());
                }
                addLine("");
            }
        }
        writeReport();
    }
}
