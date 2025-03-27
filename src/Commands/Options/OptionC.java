package Commands.Options;

import Commands.Command;
import Others.Player;

public class OptionC implements Command {
    Player player;

    public OptionC(Player p) {
        this.player = p;
    }
    /**
     * This method sets the players choice to c
     * @return message that he chose c
     */
    @Override
    public String execute() {
        player.setChoice('c');
        return "Vybral sis moznost C";
    }

    @Override
    public Boolean end() {
        return false;
    }
}
