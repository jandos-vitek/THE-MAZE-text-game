package Commands.Fighting;

import Commands.Command;
import Entities.Enemy;
import Others.Player;

public class Healing implements Command {
    Player player;
    Enemy enemy;

    public Healing(Enemy e, Player p ) {
        this.enemy = e;
        this.player=p;
    }

    @Override
    public String execute() {
        if(player.getNumberOfMushrooms()>0) {
            player.setHealth(player.getHealth()+15);
            player.setNumberOfMushrooms(player.getNumberOfMushrooms()-1);
            player.setHealth(player.getHealth()-enemy.getDamage());
           return "HP nepritele: "+enemy.getHealth()+"\n__________________________\n"+player.showStats();
        }else {
            return "Nemuzes se healovat, protoze nemas zadny magicky houby";
        }
    }

    @Override
    public Boolean end() {
        return false;
    }
}
