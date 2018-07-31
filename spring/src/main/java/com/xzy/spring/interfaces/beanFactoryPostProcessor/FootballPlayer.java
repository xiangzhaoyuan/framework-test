package com.xzy.spring.interfaces.beanFactoryPostProcessor;

public class FootballPlayer {

    private String name;
    private String team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" + "name=" + name + ", team=" + team + '}';
    }
}
