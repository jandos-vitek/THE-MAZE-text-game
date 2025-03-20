package Commands.Fighting;

import Commands.Command;
import Entities.Enemy;
import Others.Player;

import java.util.Random;

public class Attack implements Command {
    Enemy enemy;
    Player player;
    Random rd= new Random();

    public Attack(Enemy e,Player p) {
        this.enemy = e;
        this.player=p;
    }

    @Override
    public String execute() {
        enemy.setHealth(enemy.getHealth()-(player.getDamage()+ rd.nextInt(player.getluck())));
        if(enemy.getHealth()>0) {
            player.setHealth(player.getHealth()- enemy.getDamage()- rd.nextInt(enemy.getLuck()));
            return "HP nepritele: " + enemy.getHealth() + "\nTvoje HP: " + player.getHealth();
        }
        return "";
    }

    @Override
    public Boolean end() {
        return false;
    }
}
