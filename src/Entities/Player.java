package Entities;

import java.util.ArrayList;

public class Player {
    private int health;
    private int damage;

    private int numberOfCoins;
    private int numberOfMushrooms;

    public Player(int health, int damage, int numberOfCoins, int numberOfMushrooms) {
        this.health = health;
        this.damage = damage;
        this.numberOfCoins = numberOfCoins;
        this.numberOfMushrooms = numberOfMushrooms;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    public int getNumberOfMushrooms() {
        return numberOfMushrooms;
    }

    public void setNumberOfMushrooms(int numberOfMushrooms) {
        this.numberOfMushrooms = numberOfMushrooms;
    }
}
