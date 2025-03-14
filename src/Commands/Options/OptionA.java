package Commands.Options;

import Commands.Command;
import Others.Player;

public class OptionA implements Command {
    Player player;

    public OptionA(Player p) {
        this.player = p;
    }

    @Override
    public String execute() {
        player.setChoise('a');
        return "Vybral sis moznost A";
    }

    @Override
    public Boolean end() {
        return false;
    }
}
