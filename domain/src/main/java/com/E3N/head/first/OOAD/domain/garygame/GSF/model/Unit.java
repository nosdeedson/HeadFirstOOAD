package com.E3N.head.first.OOAD.domain.garygame.GSF.model;

import java.util.*;

public class Unit {
    private final String type;
    private int id;
    private String name;
    private List<Weapon> weapons;
    private Map<String, Object> properties;

    public Unit(final String type, final int id ) {
        this.id = id;
        this.type = type;
        properties = new HashMap<>(3);
        weapons = new ArrayList<>(1);
    }

    protected void addWeapon(final Weapon weapon){
        this.weapons.add(weapon);
    }

    protected void removeProperty(final String key){
        if (key != null){
            properties.remove(key);
        }
    }

    protected void removeProperties(){
        final List<String> keys =
                new ArrayList<>(this.getProperties().keySet());
        for (String key : keys) {
            this.removeProperty(key);
        }
    }

    protected void setProperty(final String key, final Object value){
        if(key != null && value != null){
            properties.put(key, value);
        }
    }

    protected void setProperties(final Map<String, Object> properties){
        if (properties == null){
            throw new IllegalArgumentException("properties should not be null");
        }
        if (this.properties == null){
            this.properties = new HashMap<>();
        }
        this.properties.putAll(properties);
    }

    public String getType() {
        return type;
    }

    public Map<String, Object> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    public Unit setName(String name) {
        this.name = name;
        return this;
    }

    public Unit setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        final Unit unit = (Unit) object;
        return Objects.equals(getType(), unit.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType());
    }
}
