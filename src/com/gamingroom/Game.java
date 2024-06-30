package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

public class Game extends Entity {
    private List<Team> teams;

    public Game(int id, String name) {
        super(id, name);
        teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        for (Team t : teams) {
            if (t.getName().equals(team.getName())) {
                throw new IllegalArgumentException("Team name must be unique");
            }
        }
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }
}