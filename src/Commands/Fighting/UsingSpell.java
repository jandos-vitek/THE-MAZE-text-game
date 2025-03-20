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
