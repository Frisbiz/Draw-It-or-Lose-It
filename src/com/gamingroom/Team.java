package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

public class Team extends Entity {
    private List<Player> players;

    public Team(int id, String name) {
        super(id, name);
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        for (Player p : players) {
            if (p.getName().equals(player.getName())) {
                throw new IllegalArgumentException("Player name must be unique");
            }
        }
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }
}