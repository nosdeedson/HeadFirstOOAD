package com.E3N.head.first.OOAD.domain.garygame.GSF.model;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private List<Unit> units;
    private final String myPosition;

    public Tile(String myPosition) {
        this.myPosition = myPosition;
        this.units = new ArrayList<>(3);
    }

    protected void removeUnit(final Unit unitToRemove){
        if (unitToRemove != null){
            units.remove(unitToRemove);
        }
    }

    protected void removeUnits(){
        /*
          There is no need to increment 'i' because we want to remove all units
          after we remove de first unit the list will decrement itself
          so, we have to remove the first item of the list until there is
          none to remove anymore
         */
        for (int i = 0; i < this.units.size();) {
            removeUnit(this.getUnits().get(i));
        }
    }

    protected List<Unit> getUnits() {
        return this.units;
    }

    protected void setUnit(Unit unit) {
        if (unit == null){
            throw new IllegalArgumentException("unit should not be null");
        }
        this.units.add(unit);
    }

    public final String getMyPosition() {
        return myPosition;
    }
}
