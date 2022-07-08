package cz.cvut.fel.omo;

import cz.cvut.fel.omo.building.House;
import cz.cvut.fel.omo.config.HouseConfiguration;
import cz.cvut.fel.omo.reports.ConsumptionReport;
import cz.cvut.fel.omo.reports.EventReport;
import cz.cvut.fel.omo.reports.HouseInfReport;
import cz.cvut.fel.omo.reports.PersonActivitiesReport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of days in which the simulation will run:\n");
        int  daysCount = sc.nextInt();

        HouseConfiguration houseConfiguration = new HouseConfiguration();
        //can switch config to buildHouse2()
        House house = houseConfiguration.buildHouse();

        Controller controller = Controller.getInstance(house, daysCount);
        controller.start();

        HouseInfReport hr = HouseInfReport.getInstance();
        hr.generateReport(controller);

        EventReport er = EventReport.getInstance();
        er.generateReport(controller);

        ConsumptionReport cr = ConsumptionReport.getInstance();
        cr.generateReport(controller);

        PersonActivitiesReport pr = PersonActivitiesReport.getInstance();
        pr.generateReport(controller);
    }

}
