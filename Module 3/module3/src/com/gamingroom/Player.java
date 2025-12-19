package com.gamingroom;

/**
 * Player class derived from Entity.
 */
public class Player extends Entity {

    public Player(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Player: " + name + " (ID: " + id + ")";
    }
}
