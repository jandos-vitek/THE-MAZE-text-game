package Commands.Options;

import Commands.Command;
import Others.Player;

public class OptionC implements Command {
    Player player;

    public OptionC(Player p) {
        this.player = p;
    }

    @Override
    public String execute() {
        player.setChoise('C');
        return "Vybral sis moznost C";
    }

    @Override
    public Boolean end() {
        return false;
    }
}
