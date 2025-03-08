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


    public Enemy(int health, boolean attacksImmediately, boolean isAlive, String description,int damage,Player p) {
        this.health = health;
        this.attacksImmediately = attacksImmediately;
        this.isAlive = isAlive;
        this.description = description;
        this.player=p;
        this.damage=damage;
        commands=new Commands(null,player);
    }

    @Override
    public String play() {
        if(attacksImmediately){
            while (isAlive&&player.getHealth()>0){
                fight();
            }
            if(player.getHealth()<=0){
                return "Umrel jsi";
            }else {
                return "zabil jsi nepritele";
            }
        }
        else if (player.agree()){
            while (isAlive&&player.getHealth()>0){
                fight();
            }
            if(player.getHealth()<=0){
                return "Umrel jsi";
            }else {
                return "zabil jsi nepritele";
            }
        }

            return "rozhodl si se neutocit";

    }


    public String fight(){
        commands.executing();
        switch (player.getChoise()){
            case 'A':
            case 'B':
            case 'C':
            default: return "tohle by se nemelo stat";
        }
    }

}
