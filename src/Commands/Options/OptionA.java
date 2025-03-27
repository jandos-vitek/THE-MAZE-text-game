package Commands.Options;

import Commands.Command;
import Others.Player;

public class OptionA implements Command {
    Player player;

    public OptionA(Player p) {
        this.player = p;
    }
    /**
     * This method sets the players choice to a
     * @return message that he chose a
     */
    @Override
    public String execute() {
        player.setChoice('a');
        return "Vybral sis moznost A";
    }

    @Override
    public Boolean end() {
        return false;
    }
}
