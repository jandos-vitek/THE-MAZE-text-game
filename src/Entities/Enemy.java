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
    Player player;
    Random rd = new Random();
    Commands commands;


    public Enemy(int health, boolean attacksImmediately, boolean isAlive, String description, int damage, Player p) {
        this.health = health;
        this.attacksImmediately = attacksImmediately;
        this.isAlive = isAlive;
        this.description = description;
        this.player = p;
        this.damage = damage;
        commands = new Commands(null, player, this);
    }

    @Override
    public String play() {
        System.out.println("jdete fightit");
        if (!attacksImmediately) {
            commands.agreeing();
            if (player.agree()) {
                return fight();
            }else {
                return "rozhodl ses neutocit";
            }
        }
        else {
           return fight();
        }

    }


public String fight(){
        while (this.health>0&&player.getHealth()>0) {
            commands.fighting();
        }
    if (this.health<=0){
        return "Vyhral jsi";
    }
    else {
        return "Byl jsi porazen";
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
}
