package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

    /** Singleton instance reference */
    private static GameService instance = null;

    /** Private constructor to prevent direct instantiation */
    private GameService() {
    }

    /** Public accessor for obtaining the single instance */
    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    /**
     * A list of the active games
     */
    private static List<Game> games = new ArrayList<Game>();

    /*
     * Holds the next game identifier
     */
    private static long nextGameId = 1;

    /**
     * Construct a new game instance
     * 
     * @param name the unique name of the game
     * @return the game instance (new or existing)
     */
    public Game addGame(String name) {

        // a local game instance
        Game game = null;

        // Use iterator to look for existing game with same name
        Iterator<Game> gameIterator = games.iterator();
        while (gameIterator.hasNext()) {
            Game existing = gameIterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                return existing;
            }
        }

        // if not found, make a new game instance and add to list of games
        if (game == null) {
            game = new Game(nextGameId++, name);
            games.add(game);
        }

        // return the new/existing game instance to the caller
        return game;
    }

    /**
     * Returns the game instance at the specified index.
     * <p>
     * Scope is package/local for testing purposes.
     * </p>
     * @param index index position in the list to return
     * @return requested game instance
     */
    Game getGame(int index) {
        return games.get(index);
    }

    /**
     * Returns the game instance with the specified id.
     * 
     * @param id unique identifier of game to search for
     * @return requested game instance
     */
    public Game getGame(long id) {

        // a local game instance
        Game game = null;

        // Use iterator to look for existing game with same id
        Iterator<Game> gameIterator = games.iterator();
        while (gameIterator.hasNext()) {
            Game existing = gameIterator.next();
            if (existing.getId() == id) {
                game = existing;
                break;
            }
        }

        return game;
    }

    /**
     * Returns the game instance with the specified name.
     * 
     * @param name unique name of game to search for
     * @return requested game instance
     */
    public Game getGame(String name) {

        // a local game instance
        Game game = null;

        // Use iterator to look for existing game with same name
        Iterator<Game> gameIterator = games.iterator();
        while (gameIterator.hasNext()) {
            Game existing = gameIterator.next();
            if (existing.getName().equalsIgnoreCase(name)) {
                game = existing;
                break;
            }
        }

        return game;
    }

    /**
     * Returns the number of games currently active
     * 
     * @return the number of games currently active
     */
    public int getGameCount() {
        return games.size();
    }
}
