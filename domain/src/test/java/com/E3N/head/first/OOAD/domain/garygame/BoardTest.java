package com.E3N.head.first.OOAD.domain.garygame;

import com.E3N.head.first.OOAD.domain.garygame.model.Board;
import com.E3N.head.first.OOAD.domain.garygame.model.Tile;
import com.E3N.head.first.OOAD.domain.garygame.model.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

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
        final int[] expectedTilePositionWithUnits = {3,3};
        final var board = new Board(expectedWidth, expectedHeigth);
        final var units = List.of(new Unit("test1"), new Unit("test2"));
        Assertions.assertNotNull(board);
        board.addUnitToTile(expectedTilePositionWithUnits[0],
                expectedTilePositionWithUnits[1], units);

        final var tileWithUnits =
                board.getTileInPosition(expectedTilePositionWithUnits[0],
                        expectedTilePositionWithUnits[1]);
        Assertions.assertNotNull(tileWithUnits);
        Assertions.assertEquals(units.get(0).getName(),
                tileWithUnits.getUnits().get(0).getName());

        Assertions.assertEquals(units.get(1).getName(),
                tileWithUnits.getUnits().get(1).getName());
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
        final var unit = new Unit("test1");
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
        final var units = List.of(new Unit("test1"), new Unit("test2"));
        Assertions.assertNotNull(board);
        board.addUnitToTile(expectedX, expectedY, units);
        final var unitsFromTile =
                board.getTileInPosition(expectedX, expectedY).getUnits();
        Assertions.assertFalse(unitsFromTile.isEmpty());
        Assertions.assertEquals(units, unitsFromTile);
    }

    @Test
    public void givenAValidBoard_whenCallsGetUnitsFromTiles_shouldBeAllEmpty(){
        final var expectedWidth = 10;
        final var expectedHeigth = 10;
        final var board = new Board(expectedWidth, expectedHeigth);
        Assertions.assertNotNull(board);
        board.getTiles().forEach(listaOfTile -> {
            listaOfTile.forEach(tile -> Assertions.assertTrue(tile.getUnits().isEmpty()));
        });
    }
}
