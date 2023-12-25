package com.E3N.head.first.OOAD.domain.garygame;

import com.E3N.head.first.OOAD.domain.garygame.GSF.model.Board;
import com.E3N.head.first.OOAD.domain.garygame.GSF.model.Tile;
import com.E3N.head.first.OOAD.domain.garygame.GSF.model.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BoardTest {

    @Test
    public void givenWidthAnHeigth_shouldCreateABoard(){
        final var expectedWidth = 10;
        final var expectedHeigth = 7;
        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertNotNull(board);
        Assertions.assertEquals(expectedWidth, board.getTiles().size());
        for (List<Tile> tilesHeight: board.getTiles() ){
            Assertions.assertEquals(expectedHeigth, tilesHeight.size());
        }
    }

    @Test
    public void givenAValidBoard_whenCallGetTileInSpecificPosition_shouldReturnIt(){
        final var expectedWidth = 3;
        final var expectedHeigth = 6;
        final var expectedPosition = "2-2";
        final var expectedPosition1 = "1-6";
        final var expectedPosition2 = "3-6";

        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertNotNull(board);

        final var tile = board.getTileInPosition(2 ,2);
        Assertions.assertEquals(expectedPosition, tile.getMyPosition());

        final var tile1 = board.getTileInPosition(1 ,6);
        Assertions.assertEquals(expectedPosition1, tile1.getMyPosition());

        final var tile2 = board.getTileInPosition(3 ,6);
        Assertions.assertEquals(expectedPosition2, tile2.getMyPosition());
    }

    @Test
    public void givenAValidBoard_whenCallGetTileInWrongPosition_shouldThrowException(){
        final var expectedWidth = 4;
        final var expectedHeigth = 4;
        final var expectedErrorMessage = "'x' deve ser maior que zero e " +
                "menor igual width of the board.";
        final var expectedErrorMessage1 = "'y' deve ser maior que zero e" +
                " menor igual heigth of the board.";

        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertNotNull(board);

        var exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> board.getTileInPosition(5 ,3));

        Assertions.assertEquals(expectedErrorMessage, exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class,
                        () -> board.getTileInPosition(2 ,5));

        Assertions.assertEquals(expectedErrorMessage1, exception.getMessage());
    }

    @Test
    public void givenAValidBoard_whenCallsAddUnitToTile_ShouldAddIt(){
        final var expectedWidth = 5;
        final var expectedHeigth = 3;
        final int expectedX = 3;
        final int expectedY = 3;

        final var board = new Board(expectedWidth, expectedHeigth);
        final var units = List.of(new Unit("type1", 1), new Unit("type2", 2));
        Assertions.assertNotNull(board);
        board.addUnitToTile(expectedX, expectedY, units);

        final var unitsFromATile = board.getUnits(expectedX, expectedY);
        Assertions.assertNotNull(unitsFromATile);
        Assertions.assertEquals(units.get(0).getType(),
                unitsFromATile.get(0).getType());

        Assertions.assertEquals(units.get(0).getType(),
                unitsFromATile.get(0).getType());
    }

    @Test
    public void givenAValidBoard_whenCallsAddUnitToTileInWrongPosition_shouldThrowException() {
        final var expectedWidth = 3;
        final var expectedHeigth = 1;
        final var expectedErrorMessage = "'x' deve ser maior que zero e " +
                "menor igual width of the board.";
        final var expectedErrorMessage1 = "'y' deve ser maior que zero e" +
                " menor igual heigth of the board.";
        final var board = new Board(expectedWidth, expectedHeigth);
        final var unit = new Unit("test1", 1);
        Assertions.assertNotNull(board);
        var exception =
                Assertions.assertThrows(IllegalArgumentException.class,
                        () -> board.addUnitToTile(4, 1, unit));
        Assertions.assertEquals(expectedErrorMessage, exception.getMessage());
        exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> board.addUnitToTile(2, 3, unit));
        Assertions.assertEquals(expectedErrorMessage1, exception.getMessage());
    }

    @Test
    public void givenAValidBoard_whenCallsGetUnitsFromTile_shouldReturnUnits(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 3;
        final var expectedY = 9;
        final var board = new Board(expectedWidth, expectedHeigth);
        final var units = List.of(new Unit("type1", 1), new Unit("type2", 2));
        Assertions.assertNotNull(board);
        board.addUnitToTile(expectedX, expectedY, units);
        final var unitsFromATile = board.getUnits(expectedX, expectedY);
        Assertions.assertFalse(unitsFromATile.isEmpty());
        Assertions.assertEquals(units, unitsFromATile);
    }

    @Test
    public void givenAValidBoard_whenCallsGetUnitsFromTiles_shouldBeAllEmpty(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertNotNull(board);
        for (int i = 0; i < expectedWidth; i++) {
            for (int j = 0; j < expectedHeigth; j++) {
                final var units = board.getUnits(i+1, j+1);
                Assertions.assertTrue(units.isEmpty());
            }
        }
    }

    @Test
    public void givenAValidBoard_whenCallsRemoveUnit_shouldRemoveIt(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final var expectedSize = 2;
        final var expectedLeft = "type2";

        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertNotNull(board);
        final var unit1 = new Unit("type1", 1);
        final var unit2 = new Unit("type2", 2);
        final var units = List.of(unit1, unit2);
        board.addUnitToTile(expectedX,expectedY, units);

        Assertions.assertEquals(expectedSize, board.getUnits(expectedX,
                expectedY).size());

        board.removeUnitFromTile(expectedX, expectedY, unit1);

        Assertions.assertEquals(expectedLeft, board.getUnits(expectedX,
                expectedY).get(0).getType());
    }

    @Test
    public void givenAValidBoard_whenCallsRemoveUnits_shouldRemoveThem(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final var expectedSize = 3;
        final var expectedSizeAfterRemoving = 0;

        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertNotNull(board);
        final var unit1 = new Unit("type1", 1);
        final var unit2 = new Unit("type2", 2);
        final var unit3 = new Unit("type3", 3);

        final var units = List.of(unit1, unit2, unit3);
        board.addUnitToTile(expectedX,expectedY, units);

        Assertions.assertEquals(expectedSize, board.getUnits(expectedX,
                expectedY).size());

        board.removeUnitFromTile(expectedX, expectedY);

        Assertions.assertEquals(expectedSizeAfterRemoving, board.getUnits(expectedX,
                expectedY).size());
    }

    @Test
    public void givenAValidBoard_whenCallsAddPropertiesToUnit_shouldAddThem(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final var expectedType = new Unit("type1", 1);
        final var expectedSizeProperties = 3;

        final var board = new Board(expectedWidth, expectedHeigth);
        final var properties = new HashMap<String, Object>();
        properties.put("soldier", "soldier");
        properties.put("gun", "gun");
        properties.put("tank", "tank");
        board.addUnitToTile(expectedX, expectedY, expectedType);
        board.addPropertiesToUnit(expectedX, expectedY, properties,
                expectedType.getType());

        Assertions.assertEquals(expectedSizeProperties,
                board.getUnits(expectedX, expectedY).stream().filter(unit -> unit.equals(expectedType)).findFirst().get().getProperties().size());
    }

    @Test
    public void givenAValidBoard_whenCallsAddPropertyToUnit_shouldAddIt(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final var expectedUnit = new Unit("type1", 1);
        final var expectedSizeProperties = 1;

        final var expectedKey = "soldier";
        final var expectedValue = "soldier";

        final var board = new Board(expectedWidth, expectedHeigth);

        board.addUnitToTile(expectedX, expectedY, expectedUnit);
        board.addPropertyToUnit(expectedX, expectedY, expectedKey,
                expectedValue, expectedUnit.getId());

        Assertions.assertEquals(expectedSizeProperties,
                board.getUnits(expectedX, expectedY).stream().filter(unit -> unit.equals(expectedUnit)).findFirst()
                        .get().getProperties().size());
    }

    @Test
    public void givenAValidBoard_whenCallsRemovePropertiesFromUnit_shouldRemoveThem(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final var expectedType = new Unit("type1", 1);
        final var expectedSize = 0;

        final var board = new Board(expectedWidth, expectedHeigth);
        final var properties = new HashMap<String, Object>();
        properties.put("soldier", "soldier");
        properties.put("gun", "gun");
        properties.put("tank", "tank");
        board.addUnitToTile(expectedX, expectedY, expectedType);
        board.addPropertiesToUnit(expectedX, expectedY, properties,
                expectedType.getType());

        board.removePropertiesFromUnit(expectedX, expectedY, expectedType.getType());
        board.getUnits(expectedX, expectedY).forEach(unit -> {
            Assertions.assertEquals(expectedSize, unit.getProperties().size());
        });
    }

    @Test
    public void givenAValidBoard_whenCallsRemovePropertyFromUnit_shouldRemoveIt(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final var expectedUnit = new Unit("type1", 1);
        final var expectedSize = 2;
        final var expectedKey = "soldier";

        final var board = new Board(expectedWidth, expectedHeigth);
        final var properties = new HashMap<String, Object>();
        properties.put("soldier", "soldier");
        properties.put("gun", "gun");
        properties.put("tank", "tank");
        board.addUnitToTile(expectedX, expectedY, expectedUnit);
        board.addPropertiesToUnit(expectedX, expectedY, properties,
                expectedUnit.getType());

        board.removePropertyFromUnit(expectedX, expectedY, expectedUnit.getType(),
                expectedKey);
        board.getUnits(expectedX, expectedY).forEach(unit -> {
            Assertions.assertEquals(expectedSize, unit.getProperties().size());
        });
    }

    @Test
    public void givenAValidBoard_whenCallsAddNullUnitToTile_shouldThrowException() {
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final Unit expectedUnit = null;
        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> board.addUnitToTile(expectedX, expectedY, expectedUnit));

    }

    @Test
    public void givenAValidBoard_whenCallsAddNullListOfUnitToTile_shouldThrowException() {
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final List<Unit> expectedList = null;
        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> board.addUnitToTile(expectedX, expectedY, expectedList));

    }

    @Test
    public void givenAValidBoard_whenCallsAddNullPropertiesToUnit_shouldThrowException() {
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final Unit expectedUnit = new Unit("type1", 1);
        final HashMap<String, Object> expectedProperties = null;
        final var board = new Board(expectedWidth, expectedHeigth);
        board.addUnitToTile(expectedX, expectedY, expectedUnit);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> board.addPropertiesToUnit(expectedX, expectedY,
                        expectedProperties, expectedUnit.getType()));

    }

    public void givenAValidBoard_whenCallsAddNullPropertyToUnit_shouldThrowException() {
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var expectedX = 5;
        final var expectedY = 5;
        final Unit expectedUnit = new Unit("type1", 1);
        final String expectedKey = null;
        final String expectedValue = null;

        final var board = new Board(expectedWidth, expectedHeigth);
        board.addUnitToTile(expectedX, expectedY, expectedUnit);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> board.addPropertyToUnit(expectedX, expectedY,
                        expectedKey, expectedValue, expectedUnit.getId()));

    }
}
