package cz.cvut.fel.omo.reports;

import cz.cvut.fel.omo.Controller;
import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;
import cz.cvut.fel.omo.building.building_equipment.sports_equipment.SportsEquipment;
import cz.cvut.fel.omo.creatures.Person;
import java.util.ArrayList;
import java.util.List;


public class PersonActivitiesReport extends Report{
    
    private static PersonActivitiesReport instance = null;

    /**
     * Singleton pattern
     *
     * @return instance of PersonActivitiesReport
     */
    public static PersonActivitiesReport getInstance(){
        if(instance == null){
            instance = new PersonActivitiesReport();
        }
        return instance;
    }

    /**
     * Generates report into file person_activity_report.txt in folder generatedReports
     *
     * @param controller where we take data from
     */
    public void generateReport(Controller controller) {
        List<Person> persons = controller.getHouse().getPeople();
        this.generateHeader("person_activity_report");
        for(Person person : persons){
            this.addLine("Name of Person: " + person.getName());
            ArrayList<Appliance> used = new ArrayList<>();
            List<Appliance> all = person.getHistoryOfUsedDevices();
            for(Appliance a : all){
                if (!used.contains(a)){
                    used.add(a);
                    int count = (int) all.stream()
                            .filter(s->s.equals(a))
                            .count();
                    addLine(" used " + a.getName() + " - " + count + " times");
                }
            }
            ArrayList<SportsEquipment> used2 = new ArrayList<>();
            List<SportsEquipment> all2 = person.getHistoryOfUsedSportsEquipment();
            for(SportsEquipment s : all2){
                if (!used2.contains(s)){
                    used2.add(s);
                    int count = (int) all2.stream()
                            .filter(x -> x.equals(s))
                            .count();
                    addLine(" used " + s.getName() + " - " + count + " times");
                }
            }
            addLine("");
        }
        writeReport();
    }
}
