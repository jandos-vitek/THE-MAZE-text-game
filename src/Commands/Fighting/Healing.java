package Commands.Fighting;

import Commands.Command;
import Entities.Enemy;
import Others.Player;

import java.util.Random;

public class Healing implements Command {
    Player player;
    Enemy enemy;
    Random rd= new Random();

    public Healing(Player p, Enemy e ) {
        this.player=p;
        this.enemy=e;
    }
    /**
     * It checks if you have enough magic mushrooms to use healing
     * If you can it heals the player and takes away one of your magic mushrooms
     * @return information about your health and if the enemy isn't null also about enemy's health. Or if you can't heal right now it returns a message that you cant heal
     */
    @Override
    public String execute() {
        if(player.getNumberOfMushrooms()>0) {
            player.setHealth(player.getHealth()+ rd.nextInt(player.getluck()*3));
            player.setNumberOfMushrooms(player.getNumberOfMushrooms()-1);
            if(enemy!=null&&enemy.getHealth()>0){
                player.setHealth(player.getHealth()- enemy.getDamage()- rd.nextInt(enemy.getLuck()));
                return "Vylecil ses\nHP nepritele: " + enemy.getHealth() + "\nTvoje HP: " + player.getHealth();
            }
            return "Vylecil ses"+ "\nTvoje HP: " + player.getHealth();
        }else {
            return "Nemuzes se healovat, protoze nemas zadny magicky houby";
        }
    }

    @Override
    public Boolean end() {
        return false;
    }
}
