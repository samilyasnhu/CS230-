package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Game class storing teams.
 */
public class Game extends Entity {

    private List<Team> teams = new ArrayList<>();

    public Game(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a team to this game, ensuring unique team names.
     */
    public Team addTeam(long id, String name) {
        // Iterator pattern to search for existing team
        Iterator<Team> iterator = teams.iterator();
        while (iterator.hasNext()) {
            Team existing = iterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                return existing; // return existing team
            }
        }

        // Not found → create new team
        Team team = new Team(id, name);
        teams.add(team);
        return team;
    }

    @Override
    public String toString() {
        return "Game: " + name + " (ID: " + id + ")";
    }
}
