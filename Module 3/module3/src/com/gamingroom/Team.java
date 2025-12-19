package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Team class storing players.
 */
public class Team extends Entity {

    private List<Player> players = new ArrayList<>();

    public Team(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a player, ensuring unique player names.
     */
    public Player addPlayer(long id, String name) {

        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player existing = iterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                return existing; // return existing
            }
        }

        Player player = new Player(id, name);
        players.add(player);
        return player;
    }

    @Override
    public String toString() {
        return "Team: " + name + " (ID: " + id + ")";
    }
}
