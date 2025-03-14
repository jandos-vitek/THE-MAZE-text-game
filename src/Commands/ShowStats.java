package Commands;

import Others.Player;

public class ShowStats implements Command{
    Player player;

    public ShowStats(Player p) {
        this.player = p;
    }

    @Override
    public String execute() {
        return player.showStats();
    }

    @Override
    public Boolean end() {
        return false;
    }
}
