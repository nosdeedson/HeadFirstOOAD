package com.E3N.head.first.OOAD.domain.garygame.GSF.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitGroup {

    private Map<Integer, Unit> units;

    public UnitGroup() {
        if (this.units == null){
            this.units = new HashMap<>();
        }
    }

    public UnitGroup(final List<Unit> units) {
        if (this.units == null){
            this.units = new HashMap<>();
        }
        for (Unit unit: units){
            addUnit(unit);
        }
    }

    public void addUnit(final Unit unit){
       this.units.put(unit.getId(), unit);
    }

    public void removeUnit(final Integer id){
        this.units.remove(id);
    }

    public void removeUnit(final Unit unit){
        this.units.remove(unit.getId());
    }

    public void removeUnits(){
        this.units.clear();
    }

    public Map<Integer, Unit> getUnits() {
        return units;
    }
}
