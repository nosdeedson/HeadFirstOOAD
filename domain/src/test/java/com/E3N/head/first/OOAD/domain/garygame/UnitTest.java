package com.E3N.head.first.OOAD.domain.garygame;

import com.E3N.head.first.OOAD.domain.garygame.GSF.model.Board;
import com.E3N.head.first.OOAD.domain.garygame.GSF.model.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {

    @Test
    public void givenValidAttributes_shouldCreateAnUnit(){
        final var expectedUnitType = "infantry";
        final var expectedProperty = "hitPoints";
        final var expectedHitPoints = 25;
        final var unit = new Unit(expectedUnitType, 1);
        final var board = new Board(10, 10);
        board.addUnitToTile(2,2, unit);
        board.addPropertyToUnit(2, 2, expectedProperty, expectedHitPoints, unit.getId());
        Assertions.assertEquals(expectedUnitType, unit.getType());
        Assertions.assertTrue(unit.getProperties().containsKey(expectedProperty));
        Assertions.assertEquals(expectedHitPoints, unit.getProperties().get(expectedProperty) );
    }

    @Test
    public void givenValidUnit_whenSetHitPoints_shouldChangeIt(){
        final var expectedUnitType = "infantry";
        final var expectedProperty = "hitPoints";
        final var expectedHitPoints = 25;
        final var expectedHitPointsAfterEditing = 15;
        final var unit = new Unit(expectedUnitType, 1);
        final var board = new Board(10, 10);
        board.addUnitToTile(2,2, unit);
        board.addPropertyToUnit(2, 2, expectedProperty, expectedHitPoints, unit.getId());
        Assertions.assertEquals(expectedUnitType, unit.getType());
        Assertions.assertTrue(unit.getProperties().containsKey(expectedProperty));
        Assertions.assertEquals(expectedHitPoints, unit.getProperties().get(expectedProperty) );

        board.addPropertyToUnit(2, 2, expectedProperty, expectedHitPointsAfterEditing, unit.getId());
        Assertions.assertEquals(expectedHitPointsAfterEditing, unit.getProperties().get(expectedProperty) );
    }

    @Test
    public void givenValidUnit_whenCallsUnexistentPropertie_shouldBeOk(){
        final var expectedUnitType = "infantry";
        final var expectedProperty = "hitPoints";
        final var expectedHitPoints = 25;
        final var expectedUnexistentProperty = "strength";
        final var unit = new Unit(expectedUnitType, 1);
        final var board = new Board(10, 10);
        board.addUnitToTile(2,2, unit);
        board.addPropertyToUnit(2, 2, expectedProperty, expectedHitPoints, unit.getId());
        Assertions.assertEquals(expectedUnitType, unit.getType());
        Assertions.assertTrue(unit.getProperties().containsKey(expectedProperty));

        Assertions.assertDoesNotThrow(() -> unit.getProperties().get(expectedUnexistentProperty));

        Assertions.assertEquals(expectedHitPoints, unit.getProperties().get(expectedProperty) );
    }
}
