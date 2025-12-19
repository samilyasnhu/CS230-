package com.gamingroom;

/**
 * Application entry point for testing the GameService functionality.
 */
public class ProgramDriver {

    public static void main(String[] args) {

        GameService service = GameService.getInstance();

        System.out.println("Initializing game data...\n");

        Game game1 = service.addGame("Championship");
        System.out.println(game1);

        Team team1 = service.addTeam(game1, "Red Dragons");
        System.out.println(team1);

        Player player1 = service.addPlayer(team1, "PlayerOne");
        System.out.println(player1);

        SingletonTester tester = new SingletonTester();
        tester.testSingleton();
    }
}
