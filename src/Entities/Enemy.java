package Entities;

import Commands.Commands;
import Others.MapOfRooms;
import Others.Player;

import java.util.Random;

public class Enemy extends Entity {
    private int health;
    private boolean attacksImmediately;
    private boolean isAlive;
    private String description;
    private int damage;
    private int luck;
    Player player;
    Commands commands;


    public Enemy(int health, int luck,int damage,boolean attacksImmediately, boolean isAlive, String description, Player p) {
        this.health = health;
        this.attacksImmediately = attacksImmediately;
        this.isAlive = isAlive;
        this.description = description;
        this.player = p;
        this.damage = damage;
        this.luck=luck;
        commands = new Commands(null, player, this);
    }

    @Override
    public String play() {
        if (isAlive) {
            if (!attacksImmediately) {
                System.out.println("rozhodni jestli chces zautocit");
                commands.agreeing();
                if (player.agree()) {
                    System.out.println("boj zacina");
                    return fight();
                }
                if (!player.agree()) {
                    return "rozhodl ses neutocit ☹\uFE0F☹\uFE0F☹\uFE0F";
                } else return "tenhle prikaz neexistuje";
            } else {
                System.out.println("boj zacina");
                return fight();
            }
        }
        return "uz je mrtvej  ☠\uFE0F☠\uFE0F☠\uFE0F☠\uFE0F";
    }


    public String fight() {
        while (this.health > 0 && player.getHealth() > 0) {
            commands.fighting();
        }
        if (this.health <= 0) {
            setAlive(false);
            return "Vyhral jsi 🎉✨✨🎉🎉";
        } else if (player.getHealth() <= 0) {
            return "Byl jsi porazen 😵";
        } else {
            return "Nečekaná chyba v souboji";
        }
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

    public String getDescription() {
        return description;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getLuck() {
        return luck;
    }
}
