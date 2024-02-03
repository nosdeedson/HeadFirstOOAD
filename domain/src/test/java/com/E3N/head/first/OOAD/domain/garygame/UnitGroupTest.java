package com.E3N.head.first.OOAD.domain.garygame;

import com.E3N.head.first.OOAD.domain.garygame.GSF.model.Unit;
import com.E3N.head.first.OOAD.domain.garygame.GSF.model.UnitGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UnitGroupTest {

    @Test
    public void addingListOfUnitsToUnitGroup() {
        final var units = createListOfUnit();
        final var expectedUnitsInUnitGroup = 5;
        final var unitGroup = new UnitGroup(units);
        Assertions.assertNotNull(unitGroup);
        Assertions.assertEquals(expectedUnitsInUnitGroup, unitGroup.getUnits().size());
    }

    @Test
    public void addingUnitToAnExistentUnitGroup() {
        final var units = createListOfUnit();
        final var expectedUnitsInUnitGroup = 6;
        final var unitGroup = new UnitGroup(units);
        final var unit = new Unit("unit 6", 15);
        unitGroup.addUnit(unit);
        Assertions.assertNotNull(unitGroup);
        Assertions.assertEquals(expectedUnitsInUnitGroup, unitGroup.getUnits().size());
    }

    @Test
    public void addingUnitToAnEmptyUnitGroup() {
        final var expectedUnitsInUnitGroup = 1;
        final var unitGroup = new UnitGroup();
        final var unit = new Unit("unit 6", 15);
        unitGroup.addUnit(unit);
        Assertions.assertNotNull(unitGroup);
        Assertions.assertEquals(expectedUnitsInUnitGroup, unitGroup.getUnits().size());
    }

    @Test
    public void removingUnitToAnExistentUnitGroupById() {
        final var units = createListOfUnit();
        final var expectedUnitsInUnitGroup = 4;
        final var unitGroup = new UnitGroup(units);
        unitGroup.removeUnit(12);
        Assertions.assertNotNull(unitGroup);
        Assertions.assertEquals(expectedUnitsInUnitGroup, unitGroup.getUnits().size());
    }

    @Test
    public void removingUnitToAnExistentUnitGroupByUnit() {
        final var units = createListOfUnit();
        final var expectedUnitsInUnitGroup = 4;
        final var unitGroup = new UnitGroup(units);
        final var unit = unitGroup.getUnits().get(13);
        unitGroup.removeUnit(unit);
        Assertions.assertNotNull(unitGroup);
        Assertions.assertEquals(expectedUnitsInUnitGroup, unitGroup.getUnits().size());
    }

    @Test
    public void removingUnitsFromUnitGroup() {
        final var units = createListOfUnit();
        final var expectedUnitsInUnitGroup = 5;
        final var expectedUnitsInUnitGroupAfterRemovingAll = 0;

        final var unitGroup = new UnitGroup(units);

        Assertions.assertNotNull(unitGroup);
        Assertions.assertEquals(expectedUnitsInUnitGroup, unitGroup.getUnits().size());
        unitGroup.removeUnits();
        Assertions.assertEquals(expectedUnitsInUnitGroupAfterRemovingAll, unitGroup.getUnits().size());
    }


    private List<Unit> createListOfUnit(){
        return List.of(
                new Unit("unit 1", 10),
                new Unit("unit 2", 11),
                new Unit("unit 3", 12),
                new Unit("unit 4", 13),
                new Unit("unit 5", 14)
        );
    }
}