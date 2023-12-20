package com.E3N.head.first.OOAD.domain.garygame.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Integer width;
    private final Integer height;

    private final List<List<Tile>> tiles;

    public Board(Integer width, Integer height) {
        this.width = width;
        this.height = height;
        this.tiles = new ArrayList<>(width);
        this.inicialize();
    }

    public void inicialize(){
        for (int i = 0; i < width; i++) {
            final var line = new ArrayList<Tile>(width);
            for (int j = 0; j < height; j++) {
                String myPosition =
                        String.valueOf(i+1).concat("-".concat(String.valueOf(j+1)));
                line.add(new Tile(myPosition));
            }
            tiles.add(line);
        }
    }

    public Tile getTileInPosition(final int x, final int y){
        this.validatePositionOfX(x);
        this.validatePositionOfY(y);
        return this.tiles.get(x-1).get(y-1);
    }

    public void addUnitToTile(final int x, final int y, final Unit unit){
        this.validatePositionOfX(x);
        this.validatePositionOfY(y);
        Tile atPosition = this.tiles.get(x-1).get(y-1);
        atPosition.setUnit(unit);
    }

    public void addUnitToTile(final int x, final int y, final List<Unit> units){
        this.validatePositionOfX(x);
        this.validatePositionOfY(y);
        Tile atPosition = this.tiles.get(x-1).get(y-1);
        atPosition.getUnits().addAll(units);
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

    private void validatePositionOfX(int value){
        if(value < 1 || value > width){
            throw new IllegalArgumentException("'x' deve ser maior que zero e " +
                    "menor igual width of the board.");
        }
    }

    private void validatePositionOfY(int value){
        if (value < 1 || value > height ){
            throw new IllegalArgumentException("'y' deve ser maior que zero e" +
                    " menor igual heigth of the board.");
        }
    }
}
