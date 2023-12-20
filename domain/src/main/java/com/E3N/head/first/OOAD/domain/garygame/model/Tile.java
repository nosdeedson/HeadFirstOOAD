package com.E3N.head.first.OOAD.domain.garygame.model;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private List<Unit> units;
    private final String myPosition;

    public Tile(String myPosition) {
        this.myPosition = myPosition;
    }

    public List<Unit> getUnits() {
        if (this.units == null){
            this.units = new ArrayList<>();
        }
        return this.units;
    }

    public void setUnit(Unit unit) {
        this.units.add(unit);
    }

    public String getMyPosition() {
        return myPosition;
    }
}
