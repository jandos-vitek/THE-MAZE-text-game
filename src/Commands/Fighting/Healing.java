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

    @Override
    public String execute() {
        if(player.getNumberOfMushrooms()>0) {
            player.setHealth(player.getHealth()+ rd.nextInt(player.getluck()*3));
            player.setNumberOfMushrooms(player.getNumberOfMushrooms()-1);
            if(enemy!=null&&enemy.getHealth()>0){
                player.setHealth(player.getHealth()- enemy.getDamage()- rd.nextInt(enemy.getLuck()));
                return "Vylecil ses\nHP nepritele: " + enemy.getHealth() + "\n──────────────────────────────\n" + player.showStats();
            }
            return "Vylecil ses"+ "\n──────────────────────────────\n" + player.showStats();
        }else {
            return "Nemuzes se healovat, protoze nemas zadny magicky houby";
        }
    }

    @Override
    public Boolean end() {
        return false;
    }
}
