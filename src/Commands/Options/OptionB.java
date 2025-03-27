package Commands.Options;

import Commands.Command;
import Others.Player;

public class OptionB implements Command {
    Player player;

    public OptionB(Player p) {
        this.player = p;
    }
    /**
     * This method sets the players choice to b
     * @return message that he chose b
     */
    @Override
    public String execute() {
        player.setChoice('b');
        return "Vybral sis moznost B";
            }

    @Override
    public Boolean end() {
        return false;
    }
}
