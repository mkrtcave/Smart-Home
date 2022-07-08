package cz.cvut.fel.omo.config;

public enum Constants {
    //hours a day
    ACTIVE_HOURS_A_DAY(24),
    //1 : value
    DEVICE_BREAK_PROBABILITY(300),
    //in how a many hours you need to feed pet
    PET_HUNGER(36),
    //1 : value
    CHILD_NEEDS_REPACK_PROBABILITY(24),
    //1 : value
    LOW_TEMPERATURE_PROBABILITY(48),
    //1 : value
    STORM_PROBABILITY(168),
    //1 : value
    STRONG_WIND_PROBABILITY(84);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
