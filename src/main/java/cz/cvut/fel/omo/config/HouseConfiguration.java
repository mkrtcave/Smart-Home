package cz.cvut.fel.omo.config;

import cz.cvut.fel.omo.building.Floor;
import cz.cvut.fel.omo.building.House;
import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.appliances.*;
import cz.cvut.fel.omo.building.building_equipment.appliances.sensors.StormSensor;
import cz.cvut.fel.omo.building.building_equipment.appliances.sensors.TemperatureSensor;
import cz.cvut.fel.omo.building.building_equipment.appliances.sensors.WindSensor;
import cz.cvut.fel.omo.building.building_equipment.sports_equipment.Bike;
import cz.cvut.fel.omo.building.building_equipment.sports_equipment.Ski;
import cz.cvut.fel.omo.creatures.creaturesFactory.CreaturesFactory;

public class HouseConfiguration {


    /**
     * Creates house for simulation
     */
    public House buildHouse(){

        House house = House.getInstance();

        Floor floor0 = new Floor(0);
        house.add(floor0);

        Floor floor1 = new Floor(1);
        house.add(floor1);
        

        Room kitchen = new Room("Kitchen", floor0);
        floor0.add(kitchen);

        Room livingRoom = new Room("Living Room", floor0);
        floor0.add(livingRoom);

        Room bathroom = new Room("Bathroom", floor0);
        floor0.add(bathroom);
        
        Room toilet = new Room("Toilet", floor0);
        floor0.add(toilet);
        
        Room garage = new Room("Garage", floor0);
        floor0.add(garage);
        
        Room bedroom = new Room("Bedroom", floor1);
        floor1.add(bedroom);
        
        Room kidsRoom = new Room("Kids Room", floor1);
        floor1.add(kidsRoom);

        Room kidsRoom2 = new Room("Kids Room 2", floor1);
        floor1.add(kidsRoom2);

        Room toilet2 = new Room("Toilet 2", floor1);
        floor1.add(toilet2);


        Fridge fridge = new Fridge("Fridge", kitchen);
        kitchen.add(fridge);

        Sunblind sunblind = new Sunblind("Sunblind", livingRoom);
        livingRoom.add(sunblind);

        VacuumingRobot robot = new VacuumingRobot("Robot", livingRoom);
        livingRoom.add(robot);

        Television television = new Television("Television", livingRoom);
        livingRoom.add(television);

        CDPlayer cdPlayer = new CDPlayer("CD Player", livingRoom);
        livingRoom.add(cdPlayer);

        TemperatureSensor temperatureSensor = new TemperatureSensor("Temperature Sensor", livingRoom);
        livingRoom.add(temperatureSensor);

        WashingMachine washingMachine = new WashingMachine("Washing Machine", bathroom);
        bathroom.add(washingMachine);

        GasBoiler boiler = new GasBoiler("Gas Boiler", garage);
        garage.add(boiler);

        WindSensor windSensor = new WindSensor("Wind Sensor", garage);
        garage.add(windSensor);

        StormSensor stormSensor = new StormSensor("Storm Sensor", garage);
        garage.add(stormSensor);

        Television television2 = new Television("Television 2", bedroom);
        bedroom.add(television2);

        Computer computer = new Computer("Computer", bedroom);
        bedroom.add(computer);

        CDPlayer cdPlayer2 = new CDPlayer("CD Player 2", bedroom);
        bedroom.add(cdPlayer2);

        Sunblind sunblind2 = new Sunblind("Sunblind 2", bedroom);
        bedroom.add(sunblind2);

        Computer computer2 = new Computer("Computer 2", kidsRoom);
        kidsRoom.add(computer2);

        CDPlayer cdPlayer3 = new CDPlayer("CD Player 3", kidsRoom);
        kidsRoom.add(cdPlayer3);

        Sunblind sunblind3 = new Sunblind("Sunblind 3", kidsRoom);
        kidsRoom.add(sunblind3);

        Computer computer3 = new Computer("Computer 3", kidsRoom2);
        kidsRoom2.add(computer3);

        CDPlayer cdPlayer4 = new CDPlayer("CD Player 4", kidsRoom2);
        kidsRoom2.add(cdPlayer4);

        Sunblind sunblind4 = new Sunblind("Sunblind 4", kidsRoom2);
        kidsRoom2.add(sunblind4);


        Ski ski = new Ski("Ski");
        garage.addEquipment(ski);

        Ski ski2 = new Ski("Ski 2");
        garage.addEquipment(ski2);

        Bike bike = new Bike("Bike");
        garage.addEquipment(bike);

        Bike bike2 = new Bike("Bike 2");
        garage.addEquipment(bike2);

        CreaturesFactory cf = new CreaturesFactory(house);

        house.addPerson(cf.getPerson("ADULT"));
        house.addPerson(cf.getPerson("ADULT"));
        house.addPerson(cf.getPerson("CHILD"));
        house.addPerson(cf.getPerson("CHILD"));
        house.addPerson(cf.getPerson("CHILD"));
        house.addPerson(cf.getPerson("CHILD"));

        house.addPet(cf.getPet("PET"));
        house.addPet(cf.getPet("PET"));
        house.addPet(cf.getPet("PET"));


        return house;
    }


    /**
     * Creates house for simulation
     */
    public House buildHouse2(){

        House house = House.getInstance();

        Floor floor0 = new Floor(0);
        house.add(floor0);

        Floor floor1 = new Floor(1);
        house.add(floor1);

        Floor floor2 = new Floor(2);
        house.add(floor2);

        Room kitchen = new Room("Kitchen", floor0);
        floor0.add(kitchen);

        Room livingRoom = new Room("Living Room", floor0);
        floor0.add(livingRoom);

        Room bathroom = new Room("Bathroom", floor0);
        floor0.add(bathroom);

        Room toilet = new Room("Toilet", floor0);
        floor0.add(toilet);

        Room garage = new Room("Garage", floor0);
        floor0.add(garage);

        Room toilet2 = new Room("Toilet 2", floor1);
        floor1.add(toilet2);

        Room bedroom = new Room("Bedroom", floor1);
        floor1.add(bedroom);

        Room kidsRoom = new Room("Kids Room", floor1);
        floor1.add(kidsRoom);

        Room bathroom2 = new Room("Bathroom 2", floor1);
        floor1.add(bathroom2);

        Room bedroom2 = new Room("Bedroom", floor2);
        floor2.add(bedroom2);

        Room kidsRoom2 = new Room("Kids Room 2", floor2);
        floor2.add(kidsRoom2);

        Room bathroom3 = new Room("Bathroom 3", floor2);
        floor2.add(bathroom3);

        Room pingPongRoom = new Room("Ping Pong", floor2);
        floor2.add(pingPongRoom);


        Fridge fridge = new Fridge("Fridge", kitchen);
        kitchen.add(fridge);

        Fridge fridge2 = new Fridge("Fridge 2", kitchen);
        kitchen.add(fridge2);

        Sunblind sunblind = new Sunblind("Sunblind", livingRoom);
        livingRoom.add(sunblind);

        VacuumingRobot robot = new VacuumingRobot("Robot", livingRoom);
        livingRoom.add(robot);

        Television television = new Television("Television", livingRoom);
        livingRoom.add(television);

        CDPlayer cdPlayer = new CDPlayer("CD Player", livingRoom);
        livingRoom.add(cdPlayer);

        TemperatureSensor temperatureSensor = new TemperatureSensor("Temperature Sensor", livingRoom);
        livingRoom.add(temperatureSensor);

        WashingMachine washingMachine = new WashingMachine("Washing Machine", bathroom);
        bathroom.add(washingMachine);

        GasBoiler boiler = new GasBoiler("Gas Boiler", garage);
        garage.add(boiler);

        GasBoiler boiler2 = new GasBoiler("Gas Boiler 2", garage);
        garage.add(boiler2);

        WindSensor windSensor = new WindSensor("Wind Sensor", garage);
        garage.add(windSensor);

        StormSensor stormSensor = new StormSensor("Storm Sensor", garage);
        garage.add(stormSensor);

        Television television2 = new Television("Television 2", bedroom);
        bedroom.add(television2);

        Computer computer = new Computer("Computer", bedroom);
        bedroom.add(computer);

        CDPlayer cdPlayer2 = new CDPlayer("CD Player 2", bedroom);
        bedroom.add(cdPlayer2);

        Sunblind sunblind2 = new Sunblind("Sunblind 2", bedroom);
        bedroom.add(sunblind2);

        Television television3 = new Television("Television 3", kidsRoom);
        kidsRoom.add(television3);

        Computer computer2 = new Computer("Computer 2", kidsRoom);
        kidsRoom.add(computer2);

        Computer computer3 = new Computer("Computer 3", kidsRoom);
        kidsRoom.add(computer3);

        CDPlayer cdPlayer3 = new CDPlayer("CD Player 3", kidsRoom);
        kidsRoom.add(cdPlayer3);

        Sunblind sunblind3 = new Sunblind("Sunblind 3", kidsRoom);
        kidsRoom.add(sunblind3);

        WashingMachine washingMachine2 = new WashingMachine("Washing Machine 2", bathroom2);
        bathroom2.add(washingMachine2);

        Computer computer4 = new Computer("Computer 4", kidsRoom2);
        kidsRoom2.add(computer4);

        CDPlayer cdPlayer4 = new CDPlayer("CD Player 4", kidsRoom2);
        kidsRoom2.add(cdPlayer4);

        Sunblind sunblind4 = new Sunblind("Sunblind 4", kidsRoom2);
        kidsRoom2.add(sunblind4);

        WashingMachine washingMachine3 = new WashingMachine("Washing Machine 3", bathroom3);
        bathroom3.add(washingMachine3);

        Television television4 = new Television("Television 4", bedroom2);
        bedroom2.add(television4);

        Computer computer5 = new Computer("Computer 5", bedroom2);
        bedroom2.add(computer5);

        CDPlayer cdPlayer5 = new CDPlayer("CD Player 5", bedroom2);
        bedroom2.add(cdPlayer5);

        CDPlayer cdPlayer6 = new CDPlayer("CD Player 6", pingPongRoom);
        pingPongRoom.add(cdPlayer6);

        TemperatureSensor temperatureSensor2 = new TemperatureSensor("Temperature Sensor 2", pingPongRoom);
        pingPongRoom.add(temperatureSensor2);


        Ski ski = new Ski("Ski");
        garage.addEquipment(ski);

        Ski ski2 = new Ski("Ski 2");
        garage.addEquipment(ski2);

        Ski ski3 = new Ski("Ski 3");
        garage.addEquipment(ski3);

        Bike bike = new Bike("Bike");
        garage.addEquipment(bike);

        Bike bike2 = new Bike("Bike 2");
        garage.addEquipment(bike2);

        Bike bike3 = new Bike("Bike 3");
        garage.addEquipment(bike3);

        CreaturesFactory cf = new CreaturesFactory(house);

        house.addPerson(cf.getPerson("ADULT"));
        house.addPerson(cf.getPerson("ADULT"));
        house.addPerson(cf.getPerson("ADULT"));
        house.addPerson(cf.getPerson("ADULT"));
        house.addPerson(cf.getPerson("CHILD"));
        house.addPerson(cf.getPerson("CHILD"));
        house.addPerson(cf.getPerson("CHILD"));
        house.addPerson(cf.getPerson("CHILD"));
        house.addPerson(cf.getPerson("CHILD"));
        house.addPerson(cf.getPerson("CHILD"));

        house.addPet(cf.getPet("PET"));
        house.addPet(cf.getPet("PET"));
        house.addPet(cf.getPet("PET"));
        house.addPet(cf.getPet("PET"));

        return house;
    }
}
