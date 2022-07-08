package cz.cvut.fel.omo.reports;

import cz.cvut.fel.omo.Controller;
import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;
import java.util.List;


public class ConsumptionReport extends Report {
    
    private static ConsumptionReport instance = null;

    /**
     * Singleton pattern
     *
     * @return instance of ConsumptionReport
     */
    public static ConsumptionReport getInstance(){
        if(instance == null){
            instance = new ConsumptionReport();
        }
        return instance;
    }

    /**
     * Generates report into file consumption_report.txt in folder generatedReports
     *
     * @param controller where we take data from
     */
    public void generateReport(Controller controller) {
        int water = 0;
        int gas = 0;
        int electricity = 0;
        this.generateHeader("consumption_report");
        List<Appliance> appliances = controller.getHouse().getAppliances();
        for(Appliance a : appliances){
            water += a.getConsumptionOfWater();
            gas += a.getConsumptionOfGas();
            electricity += a.getConsumptionOfElectricity();
            this.addLine("Appliance: " + a.getName());
            this.addLine("Electricity: " + a.getConsumptionOfElectricity()
                + "  Gas: " + a.getConsumptionOfGas()
                + "  Water: " + a.getConsumptionOfWater());
            this.addLine("");
        }
        this.addLine("\n");
        this.addLine("Household electricity consumption: " + electricity + " units == " + electricity/40 + " Kč");
        this.addLine("Household gas consumption: " + gas + " units == " + gas/25 + " Kč");
        this.addLine("Household water consumption: " + water + " units == " + water + " Kč");
        writeReport();
    }
}
