package cz.cvut.fel.omo.creatures;

import cz.cvut.fel.omo.building.Floor;
import cz.cvut.fel.omo.building.House;
import cz.cvut.fel.omo.building.Room;
import cz.cvut.fel.omo.building.building_equipment.appliances.Appliance;
import cz.cvut.fel.omo.building.building_equipment.appliances.ApplianceType;
import cz.cvut.fel.omo.building.building_equipment.appliances.manuals.Manual;
import cz.cvut.fel.omo.building.building_equipment.sports_equipment.SportsEquipment;
import cz.cvut.fel.omo.building.building_equipment.sports_equipment.SportsEquipmentType;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.IdleState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OffState;
import cz.cvut.fel.omo.building.building_equipment.stateMachine.OnState;
import cz.cvut.fel.omo.creatures.enums.PersonAbility;
import cz.cvut.fel.omo.creatures.enums.PersonType;
import cz.cvut.fel.omo.creatures.stateMachine.PersonState;
import cz.cvut.fel.omo.creatures.stateMachine.RelaxingState;
import cz.cvut.fel.omo.creatures.stateMachine.WaitingState;
import cz.cvut.fel.omo.creatures.stateMachine.WorkingState;
import cz.cvut.fel.omo.events.BabyRepackEvent;
import cz.cvut.fel.omo.events.DeviceBrokenEvent;
import cz.cvut.fel.omo.events.EventSubscriber;
import cz.cvut.fel.omo.events.FeedPetEvent;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public abstract class Person implements EventSubscriber {

    private String name;
    private Room room;
    private PersonType personType;
    protected PersonState state = new WaitingState();
    protected int timeLeftDoingSomething = 0;
    
    private final Random random = new Random();
    
    private List<Appliance> historyOfUsedDevices = new ArrayList<>();
    private List<SportsEquipment> historyOfUsedSportsEquipment = new ArrayList<>();

    /**
     * Constructor
     *
     * @param name person name
     * @param room the room where person is located
     */
    public Person(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    /**
     * Updates person
     * changes its state
     * generates random activities
     */
    @Override
    public void tick(){
        if (this.timeLeftDoingSomething > 0){
            this.timeLeftDoingSomething--;
        }
        if (this.timeLeftDoingSomething == 0){
            this.setState(new WaitingState());
            if (this.getRoom() == null){
                this.setRoom(this.getRandomRoom());
            }
        }
        if (this.state.getClass() == WaitingState.class){
            generateRandomAction();
        }
    }

    /**
     * Person handles given BabyRepackEvent
     * changes its state to working state
     * changes its room to the room of event source
     *
     * @param event given event to handle
     */
    @Override
    public void handleEvent(BabyRepackEvent event) {
        if (event.getAffectedSubscribers().size() < 1){
            if (this.getPersonType().hasAbility(PersonAbility.REPACK_BABY) && this.getState().getClass() == WaitingState.class){
                Child child = (Child) event.getSourceSubscriber();
                this.setRoom(child.getRoom());
                this.setTimeLeftDoingSomething(1);
                this.setState(new WorkingState());
                event.addAffectedSubscriber(this);
            }
        }
    }

    /**
     * Person handles given DeviceBrokenEvent
     * changes its state to working state
     * changes its room to the room of event source
     * uses Manual
     *
     * @param event given event to handle
     */
    @Override
    public void handleEvent(DeviceBrokenEvent event) {
        if (event.getAffectedSubscribers().size() < 1){
            if (this.getPersonType().hasAbility(PersonAbility.REPAIR_APPLIANCE) && this.getState().getClass() == WaitingState.class){
                Appliance appliance = (Appliance) event.getSourceSubscriber();
                Manual manual = Manual.getManualByType(appliance.getType());
                this.setRoom(appliance.getRoom());
                this.setTimeLeftDoingSomething(manual.getRequiredTime());
                this.setState(new WorkingState());
                appliance.setState(new IdleState());
                event.addAffectedSubscriber(this);
            }
        }
    }

    /**
     * Person handles given FeedPetEvent
     * changes its state to working state
     * changes its room to the room of event source
     *
     * @param event given event to handle
     */
    @Override
    public void handleEvent(FeedPetEvent event) {
        if (event.getAffectedSubscribers().size() < 1){
            if (this.getPersonType().hasAbility(PersonAbility.FEED_PET) && this.getState().getClass() == WaitingState.class){
                Pet pet = (Pet) event.getSourceSubscriber();
                this.setRoom(pet.getRoom());
                this.setTimeLeftDoingSomething(1);
                this.setState(new WorkingState());
                pet.setHunger(0);
                event.addAffectedSubscriber(this);
            }
        }
    }

    protected void generateRandomAction(){
        int randomInt = random.nextInt(2);

        switch (randomInt) {
            case 0 -> this.workOut();
            case 1 -> this.useRandomDevice();
        }
    }

    private void workOut(){
        int randomInt = random.nextInt(2);

        switch (randomInt) {
            case 0 -> {
                if(this.personType.hasAbility(PersonAbility.GO_WORK_OUT)){this.goSkiing();}
            }
            case 1 -> {
                if(this.personType.hasAbility(PersonAbility.GO_WORK_OUT)){this.goCycling();}
            }
        }
    }

    private void useRandomDevice(){
        int randomInt = random.nextInt(6);

        switch (randomInt) {
            case 0 -> {
                if(this.personType.hasAbility(PersonAbility.USE_COMPUTER)){this.useComputer();}
            }
            case 1 -> {
                if(this.personType.hasAbility(PersonAbility.USE_CD_PLAYER)){this.useCDPlayer();}
            }
            case 2 -> {
                if(this.personType.hasAbility(PersonAbility.USE_TV)){this.useTV();}
            }
            case 3 -> {
                if(this.personType.hasAbility(PersonAbility.USE_FRIDGE)){this.useFridge();}
            }
            case 4 -> {
                if(this.personType.hasAbility(PersonAbility.USE_VACUUMING_ROBOT)){this.useVacuumingRobot();}
            }
            case 5 -> {
                if(this.personType.hasAbility(PersonAbility.USE_WASHING_MACHINE)){this.useWashingMachine();}
            }
        }
    }

    private void goSkiing(){
        this.getHouse()
                .getSportsEquipment()
                .stream()
                .filter(s -> s.getType().equals(SportsEquipmentType.SKI))
                .filter(SportsEquipment::isAvailable)
                .findAny()
                .ifPresent(
                        s -> {
                            s.setAvailable(false);
                            s.setUsageTimeLeft(s.getUsageTime());
                            this.setTimeLeftDoingSomething(s.getUsageTime());
                            this.setState(new RelaxingState());
                            this.setRoom(null);
                            this.historyOfUsedSportsEquipment.add(s);
                        }
                );
    }

    private void goCycling(){
        this.getHouse()
                .getSportsEquipment()
                .stream()
                .filter(b -> b.getType().equals(SportsEquipmentType.BICYCLE))
                .filter(SportsEquipment::isAvailable)
                .findAny()
                .ifPresent(
                        b -> {
                            b.setAvailable(false);
                            b.setUsageTimeLeft(b.getUsageTime());
                            this.setTimeLeftDoingSomething(b.getUsageTime());
                            this.setState(new RelaxingState());
                            this.setRoom(null);
                            this.historyOfUsedSportsEquipment.add(b);                        }
                );
    }

    private void useComputer(){
        this.getHouse()
                .getAppliances()
                .stream()
                .filter(c -> c.getType().equals(ApplianceType.COMPUTER))
                .filter(c -> c.getState().getClass() == IdleState.class || c.getState().getClass() == OffState.class)
                .findAny()
                .ifPresent(
                        c -> {
                            c.setState(new OnState());
                            c.setUsageTimeLeft(c.getUsageTime());
                            this.setTimeLeftDoingSomething(c.getUsageTime());
                            this.setState(new RelaxingState());
                            this.setRoom(c.getRoom());
                            this.historyOfUsedDevices.add(c);
                        }
                );
    }

    private void useCDPlayer(){
        this.getHouse()
            .getAppliances()
            .stream()
            .filter(c -> c.getType().equals(ApplianceType.CD_PLAYER))
            .filter(c -> c.getState().getClass() == IdleState.class || c.getState().getClass() == OffState.class)
            .findAny()
            .ifPresent(
                    c -> {
                        c.setState(new OnState());
                        c.setUsageTimeLeft(c.getUsageTime());
                        this.setTimeLeftDoingSomething(c.getUsageTime());
                        this.setState(new RelaxingState());
                        this.setRoom(c.getRoom());
                        this.historyOfUsedDevices.add(c);
                    }
            );
    }

    private void useTV(){
        this.getHouse()
                .getAppliances()
                .stream()
                .filter(t -> t.getType().equals(ApplianceType.TELEVISION))
                .filter(t -> t.getState().getClass() == IdleState.class || t.getState().getClass() == OffState.class)
                .findAny()
                .ifPresent(
                        t -> {
                            t.setState(new OnState());
                            t.setUsageTimeLeft(t.getUsageTime());
                            this.setTimeLeftDoingSomething(t.getUsageTime());
                            this.setState(new RelaxingState());
                            this.setRoom(t.getRoom());
                            this.historyOfUsedDevices.add(t);
                        }
                );
    }

    private void useFridge(){
        this.getHouse()
                .getAppliances()
                .stream()
                .filter(f -> f.getType().equals(ApplianceType.FRIDGE))
                .filter(f -> f.getState().getClass() == IdleState.class || f.getState().getClass() == OffState.class)
                .findAny()
                .ifPresent(
                        f -> {
                            f.setState(new OnState());
                            f.setUsageTimeLeft(f.getUsageTime());
                            this.setTimeLeftDoingSomething(f.getUsageTime());
                            this.setState(new RelaxingState());
                            this.setRoom(f.getRoom());
                            this.historyOfUsedDevices.add(f);
                        }
                );
    }

    private void useVacuumingRobot(){
        this.getHouse()
                .getAppliances()
                .stream()
                .filter(v -> v.getType().equals(ApplianceType.VACUUMING_ROBOT))
                .filter(v -> v.getState().getClass() == IdleState.class || v.getState().getClass() == OffState.class)
                .findAny()
                .ifPresent(
                        v -> {
                            v.setState(new OnState());
                            v.setUsageTimeLeft(v.getUsageTime());
                            this.setTimeLeftDoingSomething(v.getUsageTime());
                            this.setState(new WorkingState());
                            this.setRoom(v.getRoom());
                            this.historyOfUsedDevices.add(v);
                        }
                );
    }

    private void useWashingMachine(){
        this.getHouse()
                .getAppliances()
                .stream()
                .filter(w -> w.getType().equals(ApplianceType.WASHING_MACHINE))
                .filter(w -> w.getState().getClass() == IdleState.class || w.getState().getClass() == OffState.class)
                .findAny()
                .ifPresent(
                        w -> {
                            w.setState(new OnState());
                            w.setUsageTimeLeft(w.getUsageTime());
                            this.setTimeLeftDoingSomething(w.getUsageTime());
                            this.setState(new WorkingState());
                            this.setRoom(w.getRoom());
                            this.historyOfUsedDevices.add(w);                        }
                );
    }
    
    public String getName() {
        return name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public PersonState getState() {
        return state;
    }

    public void setState(PersonState state) {
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    private House getHouse(){return controller.getHouse();}

    public void setTimeLeftDoingSomething(int timeLeftDoingSomething) {
        this.timeLeftDoingSomething = timeLeftDoingSomething;
    }

    protected Room getRandomRoom(){
        Floor floor = (Floor) this.getHouse().getFloors().get(random.nextInt(this.getHouse().getFloors().size()));
        return (Room) floor.getRooms().get(random.nextInt(floor.getRooms().size()));
    }

    public List<Appliance> getHistoryOfUsedDevices() {
        return historyOfUsedDevices;
    }

    public List<SportsEquipment> getHistoryOfUsedSportsEquipment() {
        return historyOfUsedSportsEquipment;
    }
}
