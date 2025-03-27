package Commands.Fighting;

import Commands.Command;
import Entities.Enemy;
import Others.Player;

import java.util.Random;

public class UsingSpell implements Command {
    Enemy enemy;
    Player player;
    Random rd= new Random();

    public UsingSpell(Enemy e, Player p ) {
        this.enemy = e;
        this.player=p;
    }
    /**
     * This method checks if you have enough magic mushrooms to use this attack
     * If you can it takes away one of your magic mushrooms and lowers the enemy's health according to rules of fighting
     * If the enemy is still alive it fights back
     * @return information about your and the enemy's health or if the enemy is dead it returns empty String or message that zou can't use this attack
     */
    @Override
    public String execute() {
        if(player.getNumberOfMushrooms()>0) {
           enemy.setHealth(enemy.getHealth()- rd.nextInt(60));
            player.setNumberOfMushrooms(player.getNumberOfMushrooms()-1);
            if(enemy.getHealth()>0) {
                player.setHealth(player.getHealth()-enemy.getDamage()- rd.nextInt(enemy.getLuck()));
                return "HP nepritele: " + enemy.getHealth() + "\nTvoje HP: " + player.getHealth();
            }
        }
        else {
            return "Tento utok nemuzes pouzit, protoze nemas zadny magicky houby";
        }
        return "";
    }

    @Override
    public Boolean end() {
        return false;
    }
}
