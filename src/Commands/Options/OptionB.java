package Commands.Options;

import Commands.Command;
import Others.Player;

public class OptionB implements Command {
    Player player;

    public OptionB(Player p) {
        this.player = p;
    }

    @Override
    public String execute() {
        player.setChoise('b');
        return "Vybral sis moznost B";
            }

    @Override
    public Boolean end() {
        return false;
    }
}
