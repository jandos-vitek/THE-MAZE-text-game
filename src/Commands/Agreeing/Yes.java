package Commands.Agreeing;

import Commands.Command;
import Entities.Enemy;
import Entities.Entity;
import Others.Player;

public class Yes implements Command {
    Player player;

    public Yes(Player p) {
        this.player = p;
    }

    @Override
    public String execute() {
        player.setAgree(true);
        return "Vybral sis moznost ano";
    }

    @Override
    public Boolean end() {
        return false;
    }
}
