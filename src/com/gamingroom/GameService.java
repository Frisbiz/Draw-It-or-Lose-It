package com.gamingroom;

import java.util.HashMap;
import java.util.Map;

public class GameService {
    private static GameService instance;
    private Map<Integer, Game> games;

    private int nextGameId = 1;
    private int nextTeamId = 1;
    private int nextPlayerId = 1;

    private GameService() {
        games = new HashMap<>();

        // Simple log initialization for different platforms
        if (System.getProperty("os.name").startsWith("Windows")) {
            System.out.println("Initializing GameService on Windows platform.");
        } else if (System.getProperty("os.name").startsWith("Mac")) {
            System.out.println("Initializing GameService on Mac platform.");
        } else if (System.getProperty("os.name").startsWith("Linux")) {
            System.out.println("Initializing GameService on Linux platform.");
        }
        // Mobile platforms would be handled by clients connecting to the server
    }

    public static synchronized GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    public Game addGame(String name) {
        Game game = new Game(nextGameId++, name);
        games.put(game.getId(), game);
        return game;
    }

    public Game getGame(int id) {
        return games.get(id);
    }

    public Team addTeam(Game game, String name) {
        Team team = new Team(nextTeamId++, name);
        game.addTeam(team);
        return team;
    }

    public Player addPlayer(Team team, String name) {
        Player player = new Player(nextPlayerId++, name);
        team.addPlayer(player);
        return player;
    }
}