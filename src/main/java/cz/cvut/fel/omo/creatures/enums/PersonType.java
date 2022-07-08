package cz.cvut.fel.omo.creatures.enums;

import java.util.Set;

public enum PersonType {
    ADULT(Set.of(
            PersonAbility.GO_WORK_OUT,
            PersonAbility.USE_COMPUTER,
            PersonAbility.USE_CD_PLAYER,
            PersonAbility.USE_TV,
            PersonAbility.USE_FRIDGE,
            PersonAbility.USE_WASHING_MACHINE,
            PersonAbility.USE_VACUUMING_ROBOT,
            PersonAbility.USE_GAS_BOILER,
            PersonAbility.USE_SENSOR,
            PersonAbility.USE_SUNBLIND,
            PersonAbility.FEED_PET,
            PersonAbility.REPAIR_APPLIANCE,
            PersonAbility.REPACK_BABY,
            PersonAbility.SWITCH_ROOMS
    )),
    CHILD(Set.of(
            PersonAbility.GO_WORK_OUT,
            PersonAbility.USE_COMPUTER,
            PersonAbility.USE_CD_PLAYER,
            PersonAbility.USE_TV,
            PersonAbility.USE_FRIDGE,
            PersonAbility.USE_SUNBLIND,
            PersonAbility.FEED_PET,
            PersonAbility.SWITCH_ROOMS
    ));

    private final Set<PersonAbility> abilities;

    PersonType(Set<PersonAbility> abilities) {
        this.abilities = abilities;
    }

    public boolean hasAbility(PersonAbility ability){
        return abilities.contains(ability);
    }
}


