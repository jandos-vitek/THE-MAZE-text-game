package Commands.Agreeing;

import Commands.Command;
import Others.Player;

public class No implements Command {
    Player player;

    public No(Player p) {
        this.player = p;
    }

    /**
     * This method makes the player disagree
     * @return message that he chose to disagree
     */
    @Override
    public String execute() {
        player.setAgree(false);
        return "Vybral sis moznost ne";
    }

    @Override
    public Boolean end() {
        return false;
    }
}
