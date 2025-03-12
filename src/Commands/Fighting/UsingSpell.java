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
            player.setHealth(player.getHealth()-enemy.getDamage());
            if(enemy.getHealth()>0) {
                return "HP nepritele: " + enemy.getHealth() + "\n__________________________\n" + player.showStats();
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
