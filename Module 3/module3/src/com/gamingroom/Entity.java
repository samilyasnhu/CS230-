package com.gamingroom;

/**
 * Base class representing common attributes for all entities.
 * Holds shared id and name fields and behaviors.
 */
public class Entity {

    protected long id;
    protected String name;

    /**
     * Constructor for initializing entity ID and name.
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns entity ID.
     */
    public long getId() {
        return id;
    }

    /**
     * Returns entity name.
     */
    public String getName() {
        return name;
    }

    /**
     * String representation of an entity.
     */
    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
