package Commands;

import Others.Player;

public class No implements Command{
    Player player;

    public No(Player p) {
        this.player = p;
    }

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
