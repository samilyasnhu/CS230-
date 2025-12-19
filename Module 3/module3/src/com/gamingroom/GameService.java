package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Singleton service managing games, teams, and players.
 */
public class GameService {

    // --- Singleton Instance ---
    private static GameService instance = null;

    /** Private constructor prevents instantiation */
    private GameService() {}

    /**
     * Returns the one-and-only GameService instance.
     */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    // --- Collections & ID Tracking ---
    private List<Game> games = new ArrayList<>();
    private long nextGameId = 1;
    private long nextTeamId = 1;
    private long nextPlayerId = 1;

    // --- Game Methods ---
    public Game addGame(String name) {

        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game existing = iterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                return existing;
            }
        }

        Game game = new Game(nextGameId++, name);
        games.add(game);
        return game;
    }

    public Game getGame(long id) {
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game game = iterator.next();
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }

    public Game getGame(String name) {
        Iterator<Game> iterator = games.iterator();
        while (iterator.hasNext()) {
            Game game = iterator.next();
            if (game.getName().equalsIgnoreCase(name)) {
                return game;
            }
        }
        return null;
    }

    public int getGameCount() {
        return games.size();
    }

    // --- Team Methods ---
    public Team addTeam(Game game, String name) {
        return game.addTeam(nextTeamId++, name);
    }

    // --- Player Methods ---
    public Player addPlayer(Team team, String name) {
        return team.addPlayer(nextPlayerId++, name);
    }
}
