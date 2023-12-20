package com.E3N.head.first.OOAD.domain.garygame.model;

import java.util.Objects;

public class Unit {
    private String name;

    public Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Unit unit = (Unit) o;
        return Objects.equals(getName(), unit.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
