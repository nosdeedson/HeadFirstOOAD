package com.E3N.head.first.OOAD.domain.garygame.GSF.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Board {

    private final Integer width;
    private final Integer height;

    private final List<List<Tile>> tiles;

    public Board(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        this.tiles = new ArrayList<>(width);
        this.initialize();
    }

    public void initialize() {
        for (int i = 0; i < width; i++) {
            final var line = new ArrayList<Tile>(width);
            for (int j = 0; j < height; j++) {
                String myPosition =
                        String.valueOf(i + 1).concat("-".concat(String.valueOf(j + 1)));
                line.add(new Tile(myPosition));
            }
            tiles.add(line);
        }
    }

    public Tile getTileInPosition(final int x, final int y) {
        this.validatePositionOfX(x);
        this.validatePositionOfY(y);
        return this.tiles.get(x - 1).get(y - 1);
    }

    public void addUnitToTile(final int x, final int y, final Unit unit) {
        Tile atPosition = getTileInPosition(x, y);
        atPosition.setUnit(unit);
    }

    public void addUnitToTile(final int x, final int y, final List<Unit> units) {
        if (units == null){
            throw new IllegalArgumentException("List shoul not be null");
        }
        Tile atPosition = getTileInPosition(x, y);
        atPosition.getUnits().addAll(units);
    }

    public void removeUnitFromTile(final int x, final int y, Unit unitToRemove) {
        Tile tile = getTileInPosition(x, y);
        if (!tile.getUnits().isEmpty()) {
            tile.removeUnit(unitToRemove);
        }
    }

    public void removeUnitFromTile(final int x, final int y) {
        final var tile = getTileInPosition(x, y);
        if (!tile.getUnits().isEmpty()) {
            tile.removeUnits();
        }
    }

    public void addPropertiesToUnit(final int x, final int y, final Map<String,
            Object> properties, final String type) {
        final var tile = getTileInPosition(x, y);
        final var unit =
                tile.getUnits().stream().filter(it -> it.getType().equals(type)).findFirst();
        unit.ifPresent(value -> value.setProperties(properties));
    }

    public void addPropertyToUnit(final int x, final int y,
                                  final String key, final Object value, final int id) {
        final var tile = getTileInPosition(x, y);
        final var unit =
                tile.getUnits().stream().filter(it -> it.getId() == id).findFirst();
        unit.ifPresent(unit1 -> unit1.setProperty(key, value));
    }

    public void removePropertyFromUnit(final int x, final int y,
                                       final String type, final String key) {
        final var tile = getTileInPosition(x, y);
        final var unit =
                tile.getUnits().stream().filter(it -> it.getType().equals(type)).findFirst();
        unit.ifPresent(unit1 -> unit1.removeProperty(key));
    }

    public void removePropertiesFromUnit(final int x, final int y,
                                   final String type) {
        final var units = getUnits(x, y);
        for (final Unit unit : units) {
            if (unit.getType().equals(type)){
                unit.removeProperties();
            }
        }
    }

    public List<Unit> getUnits(final int x, final int y) {
        final var tile = getTileInPosition(x, y);
        return Collections.unmodifiableList(tile.getUnits());
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }

    private void validatePositionOfX(int value) {
        if (value < 1 || value > width) {
            throw new IllegalArgumentException("'x' deve ser maior que zero e " +
                    "menor igual width of the board.");
        }
    }

    private void validatePositionOfY(int value) {
        if (value < 1 || value > height) {
            throw new IllegalArgumentException("'y' deve ser maior que zero e" +
                    " menor igual heigth of the board.");
        }
    }
}
