package com.gamingroom;

public class ProgramDriver {
    public static void main(String[] args) {
        GameService service = GameService.getInstance();

        Game game = service.addGame("Game1");
        System.out.println("Created game: " + game.getName());

        Team team1 = service.addTeam(game, "Team1");
        System.out.println("Added team: " + team1.getName());

        Player player1 = service.addPlayer(team1, "Player1");
        System.out.println("Added player: " + player1.getName());
    }
}