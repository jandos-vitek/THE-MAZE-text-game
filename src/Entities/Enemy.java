package Entities;

import Others.Player;

public class Enemy extends Entity {
    private int health;
    private boolean attacksImmediately;
    private boolean alive;
    private String description;
    Player player;

    public Enemy(int health, boolean attacksImmediately, boolean alive, String description) {
        this.health = health;
        this.attacksImmediately = attacksImmediately;
        this.alive = alive;
        this.description = description;
    }

    @Override
    public String play() {
        return "";
    }
}
