package com.gamingroom;

/**
 * Verifies that GameService follows the Singleton pattern.
 */
public class SingletonTester {

    public void testSingleton() {

        System.out.println("\nTesting Singleton behavior...\n");

        GameService first = GameService.getInstance();
        GameService second = GameService.getInstance();

        if (first == second) {
            System.out.println("SUCCESS: Only one GameService instance exists.");
        } else {
            System.out.println("ERROR: Multiple instances detected.");
        }
    }
}
